package Library;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Boris on 05.11.2017.
 */
public class BookModel extends AbstractTableModel {

    private List<Book> books = new ArrayList<>();
    private String fileName;

    public void setFileName(String fileName){
        this.fileName = fileName;
        fireTableDataChanged();
    }

    public void deleteBook(int row){
        books.remove(row);
        fireTableDataChanged();
    }

    public Book getBook(int row){
        return books.get(row);
    }

    public List<Book> getBooks(){
        return books;
    }

    public String getFileName(){
        return fileName;
    }

    public void setBook(int row, Book book){
        books.set(row, book);
        fireTableDataChanged();
    }

    public void clear(){
        books.clear();
        fireTableDataChanged();
    }

    public void addBook(Book b){
        books.add(b);
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return books.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Book cur=books.get(rowIndex);
        switch (columnIndex){
            case 0:
                return cur.getName();
            case 1:
                return cur.getAuthor().toString();
            case 2:
                return cur.getPrice();
            case 3:
                return cur.getQty();
        }
        return null;
    }

    public String getColumnName(int column) {
        switch (column){
            case 0:
                return "Library.Book name";
            case 1:
                return "Library.Author";
            case 2:
                return "Price";
            case 3:
                return "Count";
        }
        return "";
    }

    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex){
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return Double.class;
            case 3:
                return Integer.class;
        }
        return Object.class;
    }
}
