package ui.server;

import ui.shared.Book;

import javax.ws.rs.*;
import java.io.*;
import java.util.*;

@Path("library")
public class BookResource {

    File file;
    FileWriter fileWriter;

    public int getCount(){
        int count=-1;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            if (line!=null) count =  Integer.valueOf(line);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    public List<Book> getList(){
        List<Book> list = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            line = reader.readLine();
            String name, author, date;
            int pages, id, datePublhn;
            while (line != null) {
                StringTokenizer stok = new StringTokenizer(line, "*");
                id = Integer.valueOf(stok.nextToken());
                name = stok.nextToken();
                pages = Integer.valueOf(stok.nextToken());
                author = stok.nextToken();
                datePublhn = Integer.valueOf(stok.nextToken());
                date = stok.nextToken();
                list.add(new Book(id, name, pages, author, datePublhn, date));
                line = reader.readLine();
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void writeToFile(List<Book> books, int inc){
        try {
            int count = getCount()+inc;
            fileWriter = new FileWriter("newLibrary.txt", false);
            fileWriter.write(String.valueOf(count)+"\n");
            fileWriter.flush();
            fileWriter = new FileWriter("newLibrary.txt", true);
            for (Book book:books){
                fileWriter.write(book.toString());
            }
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BookResource() {
        try {
            fileWriter = new FileWriter("newLibrary.txt", true);
            file = new File("newLibrary.txt");
            if(getCount()==-1) try {
                fileWriter.write("0\n");
                fileWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GET
    @Produces("application/json")
    public List<Book> get() {
        return getList();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public List<Book> add(Book book){
            int count = getCount()+1;
            Book newBook = new Book(count,book.getName(),book.getNumPages(),book.getAuthor(),book.getDatePublhn(),book.getDate());
            List<Book> books = getList();
            books.add(newBook);
            writeToFile(books, 1);
            return books;
    }

    @DELETE
    @Path("/{id}")
    @Produces("application/json")
    public List<Book> delete(@PathParam("id") int id){
        List<Book> books = getList();
        for (Book book:books){
            if(book.getId()==id) {
                books.remove(book);
                break;
            }
        }
        writeToFile(books, 0);
        return books;
    }

    @DELETE
    @Produces("application/json")
    public void deleteAll(){
        try {
            int count = getCount();
            if (count == -1) count = 0;
            fileWriter = new FileWriter("newLibrary.txt", false);
            fileWriter.write(String.valueOf(count+"\n"));
            fileWriter.flush();
            fileWriter = new FileWriter("newLibrary.txt", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GET
    @Path("/{string}")
    @Produces("application/json")
    public List<Book> sort(@PathParam("string") String string) {
        List<Book> books = getList();
        switch (string) {
            case "Id":{
                books.sort(((o1, o2) -> {
                    if (o1 == o2) {
                        return 0;
                    }

                    if (o1 != null) {
                        return (o2 != null) ? o1.getId()-o2.getId() : 1;
                    }
                    return -1;
                }));
                break;
            }
            case "Title": {
                books.sort((o1, o2) -> {
                    if (o1 == o2) {
                        return 0;
                    }

                    if (o1 != null) {
                        return (o2 != null) ? o1.getName().compareTo(o2.getName()) : 1;
                    }
                    return -1;
                });
                break;
            }
            case "Pages":{
                books.sort(((o1, o2) -> {
                    if (o1 == o2) {
                        return 0;
                    }

                    if (o1 != null) {
                        return (o2 != null) ? o1.getNumPages()-o2.getNumPages() : 1;
                    }
                    return -1;
                }));
                break;
            }
            case "Author":{
                books.sort((o1, o2) -> {
                    if (o1 == o2) {
                        return 0;
                    }

                    if (o1 != null) {
                        return (o2 != null) ? o1.getAuthor().compareTo(o2.getAuthor()) : 1;
                    }
                    return -1;
                });
                break;
            }
            case "datePublication":{
                books.sort(((o1, o2) -> {
                    if (o1 == o2) {
                        return 0;
                    }

                    if (o1 != null) {
                        return (o2 != null) ? o1.getDatePublhn()-o2.getDatePublhn() : 1;
                    }
                    return -1;
                }));
                break;
            }
            case "Date":{
                books.sort((o1, o2) -> {
                    if (o1 == o2) {
                        return 0;
                    }

                    if (o1 != null) {
                        return (o2 != null) ? o1.getDate().compareTo(o2.getDate()) : 1;
                    }
                    return -1;
                });
                break;
            }
        }
        return books;
    }
}
