package ui.client.View;

import com.google.gwt.user.client.ui.*;

public class Field extends VerticalPanel {
    private Label label;
    private TextArea textArea;

    public Field(String nameLabel) {
        label = new Label(nameLabel);
        textArea = new TextArea();
        setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        add(label);
        add(textArea);
        setVisible(true);
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public TextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(TextArea textArea) {
        this.textArea = textArea;
    }
}
