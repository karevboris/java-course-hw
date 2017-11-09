package MyUI;

import MyComponent.TextDialog;
import SwingWorker.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by Boris on 09.11.2017.
 */
public class MyMenu {
    private Swing swing;
    private JMenu file;

    public MyMenu(Swing swing, JMenu file) {
        this.swing = swing;
        this.file = file;
    }

    public void addNewFile(){
        JMenuItem newFile = new JMenuItem("New");
        file.add(newFile);
        newFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TextDialog dialog = new TextDialog();
                dialog.showDialog("New library", 350,150, false);

                JPanel panel = new JPanel(new GridLayout(2, 1, 5, 5));
                panel.add(new JLabel("File name:"));
                JTextField text = new JTextField();
                panel.add(text);
                dialog.add(panel);


                JButton ok = new JButton("OK");
                dialog.add(ok,BorderLayout.SOUTH);
                ok.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(!text.getText().isEmpty()) {
                            boolean flag = true;
                            try {
                                new FileCreator(text.getText()).execute();
                                swing.m.clear();
                                dialog.dispose();
                            } catch (Exception ex){
                                new TextDialog().showDialog("  File Not Create!",175,150, true);
                                flag = false;
                            }
                            if (flag){
                                swing.create.setEnabled(true);
                                swing.setEnabled(true);
                                swing.setEnabled(true);
                                swing.m.setFileName(text.getText()+".txt");
                            }
                        }
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    public void addOpen(){
        JMenuItem open = new JMenuItem("Open");
        file.add(open);
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean flag = true;
                swing.m.clear();
                JFileChooser openFile = new JFileChooser();
                openFile.setCurrentDirectory(new File("."));
                int res = openFile.showDialog(null, "Open file");
                if (res == JFileChooser.APPROVE_OPTION) {
                    File file = openFile.getSelectedFile();
                    try {
                        new FileReader(file.getAbsolutePath(),swing.m).execute();
                    } catch (Exception ex){
                        new TextDialog().showDialog(" Incorrect Selected File!", 175,150, true);
                        flag = false;
                    }
                    if (flag) {
                        swing.create.setEnabled(true);
                        swing.delete.setEnabled(true);
                        swing.change.setEnabled(true);
                    }
                    swing.setVisible(true);
                }
            }
        });
    }

    public void addSave (){
        JMenuItem save = new JMenuItem("Save");
        file.add(save);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FileSaver(swing.m.getBooks(), swing.m.getFileName()).execute();
            }
        });
    }
}
