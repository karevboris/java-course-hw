package ui.client.View.Dialogs;

import com.google.gwt.user.client.ui.*;

public class InfoDialog extends DialogBox {
    public InfoDialog(String text) {
        setVisible(true);
        center();
        Button button = new Button("Ok");
        button.addClickHandler(event -> InfoDialog.this.hide());
        Label label = new Label(text);
        VerticalPanel panel = new VerticalPanel();
        panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        panel.setPixelSize(200,100);
        panel.add(label);
        panel.add(button);
        setWidget(panel);
    }
}
