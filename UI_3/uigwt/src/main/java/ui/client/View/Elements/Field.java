package ui.client.View.Elements;

import com.google.gwt.user.client.ui.*;

public class Field extends HorizontalPanel {
    private Label label;
    private TextBox textBox;

    public Field(String nameLabel) {
        setSpacing(10);
        label = new Label(nameLabel);
        textBox = new TextBox();
        setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        add(label);
        add(textBox);
        setVisible(true);
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public TextBox getTextBox() {
        return textBox;
    }

    public void setTextArea(TextBox textBox) {
        this.textBox = textBox;
    }
}
