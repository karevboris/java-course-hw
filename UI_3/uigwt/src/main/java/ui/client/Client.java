package ui.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TabPanel;
import org.fusesource.restygwt.client.Defaults;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;
import ui.client.Interfaces.AnswerClient;
import ui.client.View.ErrorDialog;
import ui.client.View.TestView;
import ui.shared.AnswerGWT;

public class Client implements EntryPoint{

    private CellTable table;
    SimplePager pager;

    /*public void refreshTable (List<Book> response){
        ListDataProvider<Book> dataProvider = new ListDataProvider<Book>();

        dataProvider.addDataDisplay(table);

        List<Book> list = dataProvider.getList();

        for (Book book : response) {
            list.add(book);
        }
    }*/

    public void onModuleLoad() {
        Defaults.setServiceRoot(GWT.getHostPageBaseURL());

        AnswerClient answerClient = GWT.create(AnswerClient.class);
        /*answerClient.getAnswers(new MethodCallback<List<AnswerGWT>>() {
            @Override
            public void onFailure(Method method, Throwable exception) {
                new ErrorDialog();
            }

            @Override
            public void onSuccess(Method method, List<AnswerGWT> response) {
                Window.alert(response.get(0).toString());
            }
        });*/

        answerClient.get(0, new MethodCallback<AnswerGWT>() {
            @Override
            public void onFailure(Method method, Throwable exception) {
                new ErrorDialog().show();
            }

            @Override
            public void onSuccess(Method method, AnswerGWT response) {
                Window.alert(response.toString());
            }
        });

        answerClient.deleteById(1, new MethodCallback<Integer>() {
            @Override
            public void onFailure(Method method, Throwable exception) {
                new ErrorDialog().show();
            }

            @Override
            public void onSuccess(Method method, Integer response) {
                Window.alert(response.toString());
            }
        });

        answerClient.add(new AnswerGWT(1, "hello"), new MethodCallback() {
            @Override
            public void onFailure(Method method, Throwable exception) {
                new ErrorDialog().show();
            }

            @Override
            public void onSuccess(Method method, Object response) {
                Window.alert("OK");
            }
        });

        final TabPanel tabPanel = new TabPanel();

        String firstPageTitle = "Tests";
        String secondPageTitle = "Users";
        tabPanel.setWidth("400");

        //TestView testView = new TestView(String.valueOf(Window.getClientWidth()), String.valueOf(Window.getClientHeight()));
        TestView testView = new TestView("100%","100%");
        TestView testView1 = new TestView(String.valueOf(Window.getClientWidth()), String.valueOf(Window.getClientHeight()));

	  /* add pages to tabPanel*/
        tabPanel.add(testView, firstPageTitle);
        tabPanel.add(testView1, secondPageTitle);

      /* add tab selection handler */
        tabPanel.addSelectionHandler(new SelectionHandler<Integer>() {
            @Override
            public void onSelection(SelectionEvent<Integer> event) {
            /* add a token to history containing pageIndex
             History class will change the URL of application
             by appending the token to it.
            */
                History.newItem("pageIndex" + event.getSelectedItem());
            }
        });

      /* add value change handler to History
       this method will be called, when browser's
       Back button or Forward button are clicked
       and URL of application changes.
       */
        History.addValueChangeHandler(new ValueChangeHandler<String>() {
            @Override
            public void onValueChange(ValueChangeEvent<String> event) {
                String historyToken = event.getValue();
            /* parse the history token */
                try {
                    if (historyToken.substring(0, 9).equals("pageIndex")) {
                        String tabIndexToken = historyToken.substring(9, 10);
                        int tabIndex = Integer.parseInt(tabIndexToken);
                  /* select the specified tab panel */
                        tabPanel.selectTab(tabIndex);
                    } else {
                        tabPanel.selectTab(0);
                    }
                } catch (IndexOutOfBoundsException e) {
                    tabPanel.selectTab(0);
                }
            }
        });
      /* select the first tab by default */
        tabPanel.selectTab(0);

      /* add controls to RootPanel */
        RootPanel.get().add(tabPanel);
    }

        /*Defaults.setServiceRoot(GWT.getHostPageBaseURL());

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

        AnswerInterface answerClient = GWT.create(AnswerInterface.class);
        answerClient.getAnswer(2, new MethodCallback<AnswerClient>() {
            @Override
            public void onFailure(Method method, Throwable exception) {
                new ErrorDialog();
            }

            @Override
            public void onSuccess(Method method, AnswerClient response) {
                Window.alert(response.toString());
            }
        });

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
    }*/
}
