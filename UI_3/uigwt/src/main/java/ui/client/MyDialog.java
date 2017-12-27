package ui.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.view.client.ListDataProvider;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;
import ui.shared.Book;

import java.util.Date;
import java.util.List;

public class MyDialog extends DialogBox {
    public MyDialog(BookClient bookClient, CellTable table){
        setText("Add new book");
        setAnimationEnabled(true);
        setGlassEnabled(true);

        HorizontalPanel forButton = new HorizontalPanel();
        forButton.setHeight("20");
        forButton.setWidth("450");
        forButton.setSpacing(10);

        Label nameLabel = new Label("Enter name:"); TextBox name = new TextBox();name.setText("New book");

        Label pagesLabel = new Label("Enter number of pages:"); TextBox pages = new TextBox(); pages.setText("100");

        Label authorLabel = new Label("Enter name of author"); TextBox author = new TextBox(); author.setText("Author");

        Label datePublhnLabel = new Label("Enter date of publication"); TextBox datePublhn = new TextBox(); datePublhn.setText("2017");

        Label dateLabel = new Label("Enter date"); DateBox date = new DateBox(); date.getTextBox().setText("2017 Dec 21 00:00:00");

        VerticalPanel panel = new VerticalPanel();
        panel.setHeight("450");
        panel.setWidth("450");
        panel.setSpacing(10);
        panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

        panel.add(nameLabel); panel.add(name);

        panel.add(pagesLabel); panel.add(pages);

        panel.add(authorLabel); panel.add(author);

        panel.add(datePublhnLabel); panel.add(datePublhn);

        panel.add(dateLabel); panel.add(date);

        panel.add(forButton);

        Button cancel = new Button("Cancel");
        cancel.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                MyDialog.this.hide();
            }
        });

        Button ok = new Button("Ok");
        ok.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {

                String title = name.getText();
                int page = Integer.valueOf(pages.getText());
                String Author = author.getText();
                int DatePubl = Integer.valueOf(datePublhn.getText());
                String dateStr = date.getTextBox().getText();

                if (!title.isEmpty() && page > 0 && !Author.isEmpty()&&DatePubl>-1&&DatePubl<2018&&!dateStr.isEmpty()) {
                    Book newBook = new Book(0, title, page, Author, DatePubl, dateStr);
                    bookClient.addBook(newBook, new MethodCallback<List<Book>>() {
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
                    });
                    MyDialog.this.hide();
                }
            }
        });

        forButton.add(ok);
        forButton.add(cancel);

        setWidget(panel);
    }
}
