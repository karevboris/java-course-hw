package ui.client.View.Elements;

import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import ui.client.View.ClientServices;
import ui.shared.UserGWT;

public class ProfileView extends VerticalPanel {
    private ClientServices clientServices;
    private UserGWT userGWT;
    public ProfileView(ClientServices clientServices, UserGWT userGWT, int width, int height) {
        this.clientServices = clientServices;
        this.userGWT = userGWT;
        setVisible(true);
        setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        setPixelSize(width, height);
        HorizontalPanel loginPanel = new HorizontalPanel();
        Label loginLabel = new Label("Login:"+userGWT.getLogin());
    }
}
