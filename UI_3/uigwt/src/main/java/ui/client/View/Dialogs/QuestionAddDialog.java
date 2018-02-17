package ui.client.View.Dialogs;

import com.google.gwt.user.client.ui.*;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;
import ui.client.View.ClientServices;
import ui.client.View.Field;
import ui.shared.QuestionGWT;
import ui.shared.TestGWT;
import ui.shared.TestQuestGWT;

public class QuestionAddDialog extends DialogBox {
    public QuestionAddDialog(ClientServices clientServices, ListBox listBox, TestGWT testGWT) {
        setVisible(true);
        center();
        HorizontalPanel horizontalPanel = new HorizontalPanel();
        horizontalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        horizontalPanel.setSpacing(0);
        Button cancel = new Button("Cancel");
        cancel.addClickHandler(event -> QuestionAddDialog.this.hide());
        Button button = new Button("Ok");
        Label label = new Label("Enter question:");
        TextArea textArea = new TextArea();
        VerticalPanel panel = new VerticalPanel();
        Field timeField = new Field("Enter time:");
        Field pointsField = new Field("Enter points:");
        button.addClickHandler(event -> {
            if (textArea.getText().length()<10){
                new InfoDialog("The question is too short");
            } else if(Integer.valueOf(timeField.getTextBox().getText())<10){
                new InfoDialog("Incorrect time");
            } else if(Double.valueOf(pointsField.getTextBox().getText())<=0){
                new InfoDialog("Incorrect points");
            } else {
                clientServices.questionClient.add(new QuestionGWT(0, textArea.getText(), Integer.valueOf(timeField.getTextBox().getText()), Double.valueOf(pointsField.getTextBox().getText())), new MethodCallback<QuestionGWT>() {
                    @Override
                    public void onFailure(Method method, Throwable exception) {
                        new ErrorDialog().show();
                    }

                    @Override
                    public void onSuccess(Method method, QuestionGWT response) {
                        clientServices.testQuestClient.add(new TestQuestGWT(response.getId(), testGWT.getId()), new MethodCallback<TestQuestGWT>() {
                            @Override
                            public void onFailure(Method method, Throwable exception) {
                                new ErrorDialog().show();
                            }

                            @Override
                            public void onSuccess(Method method, TestQuestGWT response) {
                                new InfoDialog("Question added").show();
                                listBox.addItem("Question #"+(listBox.getItemCount()+1));
                            }
                        });
                    }
                });
                QuestionAddDialog.this.hide();
            }
        });
        horizontalPanel.add(button);
        horizontalPanel.add(cancel);
        panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        panel.setPixelSize(300,200);
        panel.add(label);
        panel.add(textArea);
        panel.add(timeField);
        panel.add(pointsField);
        panel.add(horizontalPanel);
        setWidget(panel);
    }
}
