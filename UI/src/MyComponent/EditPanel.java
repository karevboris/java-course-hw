package MyComponent;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Boris on 09.11.2017.
 */
public class EditPanel extends JPanel {
    public EditPanel(LayoutManager layout) {
        super(layout);
    }

    public void create(JTextField bookName, JTextField qty, JTextField price, JTextField authorName, JTextField email, JComboBox gender) {
        add(new JLabel("Book name:"));
        add(bookName);

        add(new JLabel("qty:"));
        add(qty);

        add(new JLabel("price:"));
        add(price);

        add(new JLabel("Author name:"));
        add(authorName);

        add(new JLabel("email:"));
        add(email);

        add(new JLabel("gender:"));
        add(gender);
    }
}
