package SwingWorker;

import javax.swing.*;
import java.io.File;

/**
 * Created by Boris on 08.11.2017.
 */
public class FileCreator extends SwingWorker{
    protected String fileName;
    public FileCreator(String fileName) {
        this.fileName=fileName;
    }

    @Override
    protected Object doInBackground() throws Exception {
        File file = new File(fileName+".txt");
        file.createNewFile();
        return null;
    }
}
