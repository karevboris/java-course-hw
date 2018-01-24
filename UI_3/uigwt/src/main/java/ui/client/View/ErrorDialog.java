package ui.client.View;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;

public class ErrorDialog extends DialogBox {
    public ErrorDialog(){
        String SERVER_ERROR = "An error occurred while "
                + "attempting to contact the server. Please check your network "
                + "connection and try again.";
        setSize("450","450");
        setText("Remote Procedure Call");
        setAnimationEnabled(true);
        final Button closeButton = new Button("Close");
        closeButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                hide();
            }
        });
        VerticalPanel dialogVPanel = new VerticalPanel();
        final Label textToServerLabel = new Label();
        final HTML serverResponseLabel = new HTML();
        dialogVPanel.addStyleName("dialogVPanel");
        dialogVPanel.add(new HTML("<b>Sending name to the server:</b>"));
        dialogVPanel.add(textToServerLabel);
        dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
        dialogVPanel.add(serverResponseLabel);
        dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
        dialogVPanel.add(closeButton);
        setWidget(dialogVPanel);
        setText("Remote Procedure Call - Failure");
        serverResponseLabel.addStyleName("serverResponseLabelError");
        serverResponseLabel.setHTML(SERVER_ERROR);
        center();
        closeButton.setFocus(true);
    }
}
