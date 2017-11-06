import javax.swing.*;
import javax.swing.event.MouseInputListener;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Boris on 05.11.2017.
 */

public class Swing extends JFrame {
    public Swing() {
        super("Books");
        setSize(850, 450);
        setLocation(300, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTextField bookName = new JTextField();
        JTextField qty = new JTextField();
        JTextField price = new JTextField();
        JTextField authorName = new JTextField();
        JTextField email = new JTextField();
        JComboBox gender = new JComboBox();
        gender.addItem(Gender.Man);
        gender.addItem(Gender.Woman);

        BookModel m = new BookModel();
        JTable table = new JTable(m);
        JScrollPane jScrollPane = new JScrollPane(table);
        add(jScrollPane, BorderLayout.CENTER);

        final boolean[] isDelete = {false};
        final boolean[] isChange = {false};
        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                if (isDelete[0]) {
                    m.deleteBook(row);
                    isDelete[0] = false;
                }

                if(isChange[0]){
                    Book book = m.getBook(row);
                    Author author = book.getAuthor();

                    JDialog dialog = new JDialog();
                    dialog.setSize(350, 250);
                    dialog.setLocation(150, 100);
                    dialog.setTitle("Change book");
                    dialog.setModal(true);
                    JPanel panel = new JPanel(new GridLayout(6, 2, 5, 5));

                    bookName.setText(book.getName());
                    qty.setText(String.valueOf(book.getQty()));
                    price.setText(String.valueOf(book.getPrice()));
                    authorName.setText(author.getName());
                    email.setText(author.getEmail());
                    gender.setSelectedItem(author.getGender());


                    panel.add(new JLabel("Book name:"));
                    panel.add(bookName);

                    panel.add(new JLabel("qty:"));
                    panel.add(qty);

                    panel.add(new JLabel("price:"));
                    panel.add(price);

                    panel.add(new JLabel("Author name:"));
                    panel.add(authorName);

                    panel.add(new JLabel("email:"));
                    panel.add(email);

                    panel.add(new JLabel("gender:"));
                    panel.add(gender);

                    dialog.add(panel);

                    JButton ok = new JButton("OK");
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
                                JDialog error = new JDialog();
                                error.setSize(175, 150);
                                error.setLocation(150, 100);
                                error.add(new JLabel("  Incorrect Number Format!"));
                                error.setModal(true);
                                error.setVisible(true);
                                flag = false;
                            }

                            if((bookName.getText().isEmpty())||(authorName.getText().isEmpty())||(email.getText().isEmpty())){
                                JDialog error = new JDialog();
                                error.setSize(175, 150);
                                error.setLocation(150, 100);
                                error.add(new JLabel("  Remained Empty Field!"));
                                error.setModal(true);
                                error.setVisible(true);
                                flag = false;
                            }

                            if(flag) {
                                m.setBook(row,new Book(bookName.getText(), q, pr, new Author(authorName.getText(), email.getText(), (Gender)gender.getSelectedItem())));
                                dialog.dispose();
                            }
                        }
                    });

                    dialog.add(ok,BorderLayout.SOUTH);
                    dialog.setVisible(true);

                    isChange[0] = false;
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        JButton create = new JButton("Create"); create.setEnabled(false);
        JButton delete = new JButton("Delete"); delete.setEnabled(false);
        JButton change = new JButton("Change");change.setEnabled(false);

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
                JDialog dialog = new JDialog();
                dialog.setSize(350, 250);
                dialog.setLocation(150, 100);
                dialog.setTitle("New book");
                dialog.setModal(true);
                JPanel panel = new JPanel(new GridLayout(6, 2, 5, 5));
                panel.add(new JLabel("Book name:"));
                panel.add(bookName);

                panel.add(new JLabel("qty:"));
                panel.add(qty);

                panel.add(new JLabel("price:"));
                panel.add(price);

                panel.add(new JLabel("Author name:"));
                panel.add(authorName);

                panel.add(new JLabel("email:"));
                panel.add(email);

                panel.add(new JLabel("gender:"));
                panel.add(gender);

                dialog.add(panel);

                JButton ok = new JButton("OK");
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
                            JDialog error = new JDialog();
                            error.setSize(175, 150);
                            error.setLocation(150, 100);
                            error.add(new JLabel("  Incorrect Number Format!"));
                            error.setModal(true);
                            error.setVisible(true);
                            flag = false;
                        }

                       if((bookName.getText().isEmpty())||(authorName.getText().isEmpty())||(email.getText().isEmpty())){
                            JDialog error = new JDialog();
                            error.setSize(175, 150);
                            error.setLocation(150, 100);
                            error.add(new JLabel("  Remained Empty Field!"));
                            error.setModal(true);
                            error.setVisible(true);
                            flag = false;
                        }

                        if(flag) {
                            m.addBook(new Book(bookName.getText(), q, pr, new Author(authorName.getText(), email.getText(), (Gender)gender.getSelectedItem())));
                            dialog.dispose();
                        }
                    }
                });

                dialog.add(ok,BorderLayout.SOUTH);
                dialog.setVisible(true);
            }
        });

        JPanel flow = new JPanel(new FlowLayout(FlowLayout.CENTER));
        flow.add(grid);
        add(flow, BorderLayout.EAST);

        JMenuBar menu = new JMenuBar();
        JMenu file = new JMenu("File");

        JMenuItem newFile = new JMenuItem("New");
        file.add(newFile);
        newFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog dialog = new JDialog();
                dialog.setSize(350, 150);
                dialog.setLocation(150, 100);
                dialog.setTitle("New library");
                dialog.setModal(true);
                JPanel panel = new JPanel(new GridLayout(2, 1, 5, 5));
                panel.add(new JLabel("File name:"));
                JTextField text = new JTextField();
                panel.add(text);
                JButton ok = new JButton("OK");
                dialog.add(panel);
                dialog.add(ok,BorderLayout.SOUTH);
                ok.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(!text.getText().isEmpty()) {
                            boolean flag = true;
                            try {
                                m.newFile(text.getText());
                                dialog.dispose();
                            } catch (IOException ex){
                                JDialog error = new JDialog();
                                error.setSize(175, 150);
                                error.setLocation(150, 100);
                                error.add(new JLabel("  File Not Create!"));
                                error.setModal(true);
                                error.setVisible(true);
                                flag = false;
                            }
                            if (flag){
                                create.setEnabled(true);
                                delete.setEnabled(true);
                                change.setEnabled(true);
                                m.setFile(text.getText()+".txt");
                            }
                        }
                    }
                });
                dialog.setVisible(true);
            }
        });

        JMenuItem open = new JMenuItem("Open");
        file.add(open);
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean flag = true;
                m.clear();
                JFileChooser openFile = new JFileChooser();
                openFile.setCurrentDirectory(new File("."));
                int res = openFile.showDialog(null, "Open file");
                if (res == JFileChooser.APPROVE_OPTION) {
                    File file = openFile.getSelectedFile();
                    try {
                        m.setFile(file.getName());
                    } catch (NumberFormatException ex){
                        JDialog error = new JDialog();
                        error.setSize(175, 150);
                        error.setLocation(150, 100);
                        error.add(new JLabel(" Incorrect Selected File!"));
                        error.setModal(true);
                        error.setVisible(true);
                        flag = false;
                    }
                    if (flag) {
                        create.setEnabled(true);
                        delete.setEnabled(true);
                        change.setEnabled(true);
                    }
                    setVisible(true);
                }
            }
        });
        JMenuItem save = new JMenuItem("Save");
        file.add(save);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                m.saveFile();
            }
        });

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
