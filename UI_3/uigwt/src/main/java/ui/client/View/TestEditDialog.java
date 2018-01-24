package ui.client.View;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;
import ui.shared.TestGWT;

public class TestEditDialog extends DialogBox {
    public TestEditDialog(TestGWT testClient, String width, String height) {

        if(testClient!=null) setTitle("Edit test");
        else setTitle("Create test");
        setVisible(true);
        setWidth(width);
        setHeight(height);
        setAnimationEnabled(true);
        setGlassEnabled(true);

        HorizontalPanel forButton = new HorizontalPanel();
        forButton.setHeight("20");
        forButton.setWidth(width);
        forButton.setSpacing(10);

        ScrollPanel scrollPanel = new ScrollPanel();
        scrollPanel.setWidth(width);
        scrollPanel.setHeight(height);
        VerticalPanel panel = new VerticalPanel();
        panel.setSize(width,height);
        panel.setSpacing(10);
        panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

        Field testName = new Field("Test name:");
        panel.add(testName);
        if(testClient!=null)testName.getTextArea().setText(testClient.getName());

        for(int i = 0; i<4; i++){
            Field nameQuestion = new Field("Question #"+(i+1));
            panel.add(nameQuestion);
            for(int j=0; j<5;j++){
                Field nameAnswer = new Field("Answer #"+(j+1));
                if(j==1) nameAnswer.getLabel().getElement().getStyle().setColor("GREEN");
                panel.add(nameAnswer);
            }
            Button addAnswer = new Button("Add answer");
            panel.add(addAnswer);
            addAnswer.addClickHandler(event -> {
                Field nameAnswer = new Field("Answer #");
                panel.insert(nameAnswer, addAnswer.getTabIndex());
            });
        }

        Button addQuestion = new Button("Add question");
        addQuestion.addClickHandler(event -> {
            Field nameQuestion = new Field("Question #");
            panel.insert(nameQuestion, addQuestion.getTabIndex());
            Button addAnswer = new Button("Add answer");
            panel.add(addAnswer);
            addAnswer.addClickHandler(event1 -> {
                Field nameAnswer = new Field("Answer #");
                panel.insert(nameAnswer, addAnswer.getTabIndex());
            });
        });
        panel.add(addQuestion);

        Button cancel = new Button("Cancel");
        cancel.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                TestEditDialog.this.hide();
            }
        });

        Button ok = new Button("Ok");

        forButton.add(ok);
        forButton.add(cancel);

        panel.add(forButton);
        scrollPanel.add(panel);
        setWidget(scrollPanel);
    }
}
