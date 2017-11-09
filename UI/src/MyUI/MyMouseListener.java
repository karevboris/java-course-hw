package MyUI;

import Library.Author;
import Library.Book;
import Library.Gender;
import MyComponent.EditPanel;
import MyComponent.TextDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Boris on 09.11.2017.
 */
public class MyMouseListener implements MouseListener {
    private Swing swing;

    public MyMouseListener(Swing swing) {
        this.swing = swing;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int row = swing.table.rowAtPoint(e.getPoint());
        if (swing.isDelete[0]) {
            swing.m.deleteBook(row);
            swing.isDelete[0] = false;
        }

        if(swing.isChange[0]){
            Book book = swing.m.getBook(row);
            Author author = book.getAuthor();

            TextDialog dialog = new TextDialog();
            dialog.showDialog("Change book", 350, 250, false);

            EditPanel panel = new EditPanel(new GridLayout(6, 2, 5, 5));
            panel.create(swing.bookName,swing.qty,swing.price,swing.authorName, swing.email,swing.gender);
            dialog.add(panel);

            swing.bookName.setText(book.getName());
            swing.qty.setText(String.valueOf(book.getQty()));
            swing.price.setText(String.valueOf(book.getPrice()));
            swing.authorName.setText(author.getName());
            swing.email.setText(author.getEmail());
            swing.gender.setSelectedItem(author.getGender());

            JButton ok = new JButton("OK");
            dialog.add(ok,BorderLayout.SOUTH);
            ok.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    boolean flag = true;
                    int q = 0;
                    double pr =0;

                    try {
                        q = Integer.valueOf(swing.qty.getText());
                        pr = Double.valueOf(swing.price.getText());
                        if ((q<0)||(pr<0)) new NumberFormatException();
                    } catch (NumberFormatException ex){
                        new TextDialog().showDialog("  Incorrect Number Format!", 175,150, true);
                        flag = false;
                    }

                    if((swing.bookName.getText().isEmpty())||(swing.authorName.getText().isEmpty())||(swing.email.getText().isEmpty())){
                        new TextDialog().showDialog("  Remained Empty Field!",175,150, true);
                        flag = false;
                    }

                    if(flag) {
                        swing.m.setBook(row,new Book(swing.bookName.getText(), q, pr, new Author(swing.authorName.getText(), swing.email.getText(), (Gender)swing.gender.getSelectedItem())));
                        dialog.dispose();
                    }
                }
            });
            dialog.setVisible(true);
            swing.isChange[0] = false;
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
}
