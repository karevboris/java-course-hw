package ui.client.View.Dialogs;

import com.google.gwt.user.client.ui.*;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;
import ui.client.View.ClientServices;
import ui.client.View.Elements.Field;
import ui.client.View.Tables.AnswerTable;
import ui.shared.AnswerGWT;

import java.util.List;

public class AnswerAddDialog extends DialogBox {
    public AnswerAddDialog(ClientServices clientServices, AnswerTable answerTable, Integer questId, AnswerGWT answerGWT) {
        center();
        setPixelSize(300, 200);
        VerticalPanel verticalPanel = new VerticalPanel();
        verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        Field text = new Field("Enter text:");
        if(answerGWT!=null) text.getTextBox().setText(answerGWT.getText());
        HorizontalPanel horizontalPanel = new HorizontalPanel();
        horizontalPanel.add(new Label("Is correct answer:"));
        CheckBox checkBox = new CheckBox();
        if(answerGWT!=null) checkBox.setValue(answerGWT.getCorrect());
        checkBox.setEnabled(true);
        horizontalPanel.add(checkBox);
        verticalPanel.add(text);
        verticalPanel.add(horizontalPanel);

        HorizontalPanel buttonPanel = new HorizontalPanel();
        Button okButton = new Button("Ok");
        Button cancelButton = new Button("Cancel");
        cancelButton.addClickHandler(event -> hide());
        okButton.addClickHandler(event -> {
            if(answerGWT==null) {
                if (text.getTextBox().getText().length() < 1)
                    new InfoDialog("Answer is too short. Need more 1 character");
                else {
                    clientServices.answerClient.add(new AnswerGWT(0, text.getTextBox().getText(), checkBox.getValue(), questId), new MethodCallback<AnswerGWT>() {
                        @Override
                        public void onFailure(Method method, Throwable exception) {
                            new ErrorDialog().show();
                        }

                        @Override
                        public void onSuccess(Method method, AnswerGWT response) {
                            new InfoDialog("Answer added");
                            hide();
                            clientServices.answerClient.getAnswers(questId, new MethodCallback<List<AnswerGWT>>() {
                                @Override
                                public void onFailure(Method method, Throwable exception) {
                                    new InfoDialog("List of answers is empty").show();
                                }

                                @Override
                                public void onSuccess(Method method, List<AnswerGWT> response) {
                                    answerTable.refreshTable(response);
                                }
                            });
                        }
                    });
                }
            } else {
                if (text.getTextBox().getText().length() < 1)
                    new InfoDialog("Answer is too short. Need more 1 character");
                else {
                    clientServices.answerClient.update(new AnswerGWT(answerGWT.getId(), text.getTextBox().getText(), checkBox.getValue(), questId), new MethodCallback<AnswerGWT>() {
                        @Override
                        public void onFailure(Method method, Throwable exception) {
                            new ErrorDialog().show();
                        }

                        @Override
                        public void onSuccess(Method method, AnswerGWT response) {
                            new InfoDialog("Answer updated").show();
                            hide();
                            clientServices.answerClient.getAnswers(questId, new MethodCallback<List<AnswerGWT>>() {
                                @Override
                                public void onFailure(Method method, Throwable exception) {
                                    new InfoDialog("List of answers is empty").show();
                                }

                                @Override
                                public void onSuccess(Method method, List<AnswerGWT> response) {
                                    answerTable.refreshTable(response);
                                }
                            });
                        }
                    });
                }
            }
        });
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);
        verticalPanel.add(buttonPanel);
        setWidget(verticalPanel);
    }
}
