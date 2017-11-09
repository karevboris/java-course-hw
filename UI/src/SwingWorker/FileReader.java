package SwingWorker;

import Library.Author;
import Library.Book;
import Library.BookModel;
import Library.Gender;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by Boris on 09.11.2017.
 */
public class FileReader extends FileCreator {
    protected BookModel bm;
    public FileReader(String fileName, BookModel bm) {
        super(fileName);
        this.bm = bm;
    }

    @Override
    protected Object doInBackground() throws Exception {
        try {
            Scanner scanner = new Scanner(Paths.get(fileName), StandardCharsets.UTF_8.name());
            String data;
            while(scanner.hasNext()) {
                data = scanner.useDelimiter("\n").next();

                StringTokenizer stok = new StringTokenizer(data, " ");

                String bookName = stok.nextToken();
                int qty = Integer.parseInt(stok.nextToken());
                double price = Double.parseDouble(stok.nextToken());
                String authorName = stok.nextToken();
                String email = stok.nextToken();
                Gender gender = Gender.Man;
                if(stok.nextToken().equals("Woman")) gender = Gender.Woman;

                bm.getBooks().add(new Book(bookName,qty,price,new Author(authorName,email,gender)));

                bm.setFileName(fileName);
            }
            scanner.close();
        } catch (IOException ex){
            ex.printStackTrace();
        }
        return null;
    }
}
