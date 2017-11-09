package SwingWorker;

import Library.Book;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by Boris on 08.11.2017.
 */
public class FileSaver extends FileCreator {
    protected List<Book> books;

    public FileSaver(List<Book> books, String fileName) {
        super(fileName);
        this.books = books;
    }

    @Override
    protected Object doInBackground() throws Exception {
        String data = "";

        for (Book book:books) {
            data+=book.getName()+" "+book.getQty()+" "+book.getPrice()+ " " + book.getAuthor().getName()+ " " + book.getAuthor().getEmail()+ " " + book.getAuthor().getGender() + "\n";
        }

        File file = new File(fileName);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            fileWriter.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
