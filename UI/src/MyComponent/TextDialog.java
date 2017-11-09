package MyComponent;

import javax.swing.*;

/**
 * Created by Boris on 08.11.2017.
 */
public class TextDialog extends JDialog {
    public void showDialog (String msg, int width, int height, boolean visible){
        setSize(width, height);
        setLocation(150, 100);
        add(new JLabel(msg));
        setModal(true);
        setVisible(visible);
    }
}
