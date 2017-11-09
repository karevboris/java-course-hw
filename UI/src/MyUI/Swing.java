package MyUI;

import Library.*;
import MyComponent.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Boris on 05.11.2017.
 */

public class Swing extends JFrame {

    JTextField bookName,qty,price,authorName,email;
    JComboBox gender = new JComboBox();
    BookModel m;
    JTable table;
    JButton create;
    JButton delete;
    JButton change;
    final boolean[] isDelete = {false};
    final boolean[] isChange = {false};

    public Swing() {
        super("Books");
        setSize(850, 450);
        setLocation(300, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        bookName = new JTextField();
        qty = new JTextField();
        price = new JTextField();
        authorName = new JTextField();
        email = new JTextField();
        gender = new JComboBox();
        gender.addItem(Gender.Man);
        gender.addItem(Gender.Woman);

        m = new BookModel();
        table = new JTable(m);
        table.addMouseListener(new MyMouseListener(this));
        JScrollPane jScrollPane = new JScrollPane(table);
        add(jScrollPane, BorderLayout.CENTER);

        create = new JButton("Create"); create.setEnabled(false);
        delete = new JButton("Delete"); delete.setEnabled(false);
        change = new JButton("Change");change.setEnabled(false);

        JPanel grid = new JPanel(new GridLayout(3, 1, 0, 5));

        grid.add(create);
        grid.add(delete);
        grid.add(change);

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isDelete[0] = true;
            }
        });

        change.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isChange[0] = true;
            }
        });

        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TextDialog dialog = new TextDialog();
                dialog.showDialog("New book",350,250, false);

                EditPanel panel = new EditPanel(new GridLayout(6, 2, 5, 5));
                panel.create(bookName,qty,price,authorName, email,gender);
                dialog.add(panel);

                JButton ok = new JButton("OK");
                dialog.add(ok,BorderLayout.SOUTH);
                ok.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        boolean flag = true;
                        int q = 0;
                        double pr =0;

                        try {
                            q = Integer.valueOf(qty.getText());
                            pr = Double.valueOf(price.getText());
                            if ((q<0)||(pr<0)) new NumberFormatException();
                        } catch (NumberFormatException ex){
                            new TextDialog().showDialog("  Incorrect Number Format!", 175,150, true);
                            flag = false;
                        }

                       if((bookName.getText().isEmpty())||(authorName.getText().isEmpty())||(email.getText().isEmpty())){
                            new TextDialog().showDialog("  Remained Empty Field!", 175, 150, true);
                            flag = false;
                        }

                        if(flag) {
                            m.addBook(new Book(bookName.getText(), q, pr, new Author(authorName.getText(), email.getText(), (Gender)gender.getSelectedItem())));
                            dialog.dispose();
                        }
                    }
                });
                dialog.setVisible(true);
            }
        });

        JPanel flow = new JPanel(new FlowLayout(FlowLayout.CENTER));
        flow.add(grid);
        add(flow, BorderLayout.EAST);

        JMenuBar menu = new JMenuBar();
        JMenu file = new JMenu("File");
        MyMenu item = new MyMenu(this, file);
        item.addNewFile();
        item.addOpen();
        item.addSave();

        menu.add(file);
        setJMenuBar(menu);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Swing();
            }
        });
    }
}
