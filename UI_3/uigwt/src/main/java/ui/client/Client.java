package ui.client;

import com.google.gwt.cell.client.ClickableTextCell;
import com.google.gwt.user.cellview.client.*;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SingleSelectionModel;
import org.fusesource.restygwt.client.Defaults;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import ui.shared.Book;

import java.util.List;

public class Client implements EntryPoint{

    private CellTable table;
    SimplePager pager;
    BookClient bookClient;

    public void refreshTable (List<Book> response){
        ListDataProvider<Book> dataProvider = new ListDataProvider<Book>();

        dataProvider.addDataDisplay(table);

        List<Book> list = dataProvider.getList();

        for (Book book : response) {
            list.add(book);
        }
    }

    public void onModuleLoad() {

        Defaults.setServiceRoot(GWT.getHostPageBaseURL());

        bookClient = GWT.create(BookClient.class);

        table = new CellTable<Book>();

        SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
        pager = new SimplePager(SimplePager.TextLocation.CENTER, pagerResources, false, 0, true);
        pager.setDisplay(table);
        RootPanel.get().add(pager);

        final SingleSelectionModel<Book> selectionModel
                = new SingleSelectionModel<>();
        table.setSelectionModel(selectionModel);
        selectionModel.addSelectionChangeHandler(event -> {
                    Book selected = selectionModel.getSelectedObject();
                    if (selected != null) {
                        bookClient.deleteBook(selected.getId(), new MethodCallback<List<Book>>() {
                            @Override
                            public void onFailure(Method method, Throwable exception) {
                                new ErrorDialog();
                            }

                            @Override
                            public void onSuccess(Method method, List<Book> response) {
                                refreshTable(response);
                            }
                        });
                    }
                });

        final Button deleteAllButton = new Button();
        deleteAllButton.setText("Delete all books");
        deleteAllButton.setVisible(true);
        RootPanel.get().add(deleteAllButton);
        deleteAllButton.addClickHandler(event -> bookClient.deleteAll(new MethodCallback<List<Book>>() {
            @Override
            public void onFailure(Method method, Throwable exception) {
                new ErrorDialog();
            }

            @Override
            public void onSuccess(Method method, List<Book> response) {
                ListDataProvider<Book> dataProvider = new ListDataProvider<Book>();

                dataProvider.addDataDisplay(table);

                List<Book> list = dataProvider.getList();

                for (Book book : response) {
                    list.add(book);
                }
            }
        }));

        final Button sendButton = new Button();
        sendButton.setText("Add book");
        sendButton.setVisible(true);
        RootPanel.get().add(sendButton);
        sendButton.addClickHandler(event -> {
            MyDialog myDialog = new MyDialog(bookClient, table);
            int left = Window.getClientWidth()/ 3;
            int top = Window.getClientHeight()/ 3;
            myDialog.setPopupPosition(left, top);
            myDialog.show();
        });
        RootPanel.get().add(sendButton);
        RootPanel.get().add(deleteAllButton);

        bookClient.getLibrary(new MethodCallback<List<Book>>() {
            @Override
            public void onFailure(Method method, Throwable exception) {
                new ErrorDialog();
            }

            @Override
            public void onSuccess(Method method, List<Book> response) {
                TextColumn<Book> idColumn = new TextColumn<Book>() {
                    @Override
                    public String getValue(Book book) {
                        return String.valueOf(book.getId());
                    }
                };

                TextColumn<Book> nameColumn = new TextColumn<Book>() {
                    @Override
                    public String getValue(Book book) {
                        return book.getName();
                    }
                };

                TextColumn<Book> pagesColumn = new TextColumn<Book>() {
                    @Override
                    public String getValue(Book book) {
                        return String.valueOf(book.getNumPages());
                    }
                };

                TextColumn<Book> authorColumn = new TextColumn<Book>() {
                    @Override
                    public String getValue(Book book) {
                        return book.getAuthor();
                    }
                };

                TextColumn<Book> datePublhnColumn = new TextColumn<Book>() {
                    @Override
                    public String getValue(Book book) {
                        return String.valueOf(book.getDatePublhn());
                    }
                };

                TextColumn<Book> dateColumn = new TextColumn<Book>() {
                    @Override
                    public String getValue(Book book) {
                        return book.getDate();
                    }
                };

                table.addColumn(idColumn, createHeader("Id"));
                table.addColumn(nameColumn, createHeader("Title"));
                table.addColumn(pagesColumn, createHeader("Pages"));
                table.addColumn(authorColumn, createHeader("Author"));
                table.addColumn(datePublhnColumn, createHeader("datePublication"));
                table.addColumn(dateColumn, createHeader("Date"));

                refreshTable(response);

                RootPanel.get().add(table);
            }
        });
    }

    public Header<String> createHeader(String name){
        Header<String> columnHeader = new Header<String>(new ClickableTextCell()) {
            @Override
            public String getValue() {
                return name;
            }
        };

        columnHeader.setUpdater(value -> bookClient.sortBook(value, new MethodCallback<List<Book>>() {
            @Override
            public void onFailure(Method method, Throwable exception) {
                new ErrorDialog();
            }

            @Override
            public void onSuccess(Method method, List<Book> response) {
                refreshTable(response);
            }
        }));
        return columnHeader;
    }
}
