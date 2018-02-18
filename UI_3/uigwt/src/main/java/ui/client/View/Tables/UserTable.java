package ui.client.View.Tables;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.ColumnSortEvent;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SingleSelectionModel;
import ui.client.Interfaces.UserTestClient;
import ui.shared.UserGWT;

import java.util.List;

public class UserTable extends VerticalPanel {
    private CellTable<UserGWT> userTable;
    private SimplePager pager;
    private UserTestClient userTestClient;
    private final SingleSelectionModel<UserGWT> selectionModel;
    private TextColumn<UserGWT> idColumn;
    private TextColumn<UserGWT> nameColumn;
    private TextColumn<UserGWT> adminColumn;
    private TextColumn<UserGWT> countTestColumn;
    private TextColumn<UserGWT> countPassedTestColumn;
    private TextColumn<UserGWT> percentPassedTestColumn;

    public UserTable(UserTestClient userTestClient) {
        setVisible(true);
        setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

        this.userTestClient = userTestClient;
        userTable = new CellTable<>();
        pager = new SimplePager();

        SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
        pager = new SimplePager(SimplePager.TextLocation.CENTER, pagerResources, false, 0, true);
        pager.setDisplay(userTable);

        selectionModel = new SingleSelectionModel<>();
        userTable.setSelectionModel(selectionModel);

        idColumn = new TextColumn<UserGWT>() {
            @Override
            public String getValue(UserGWT user) {
                setSortable(true);
                setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
                return String.valueOf(user.getId());
            }
        };

        nameColumn = new TextColumn<UserGWT>() {
            @Override
            public String getValue(UserGWT user) {
                setSortable(true);
                setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
                return String.valueOf(user.getLogin());
            }
        };

        adminColumn = new TextColumn<UserGWT>() {
            @Override
            public String getValue(UserGWT user) {
                setSortable(true);
                setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
                return user.getAdmin()? "Admin":"User";
            }
        };

        countTestColumn = new TextColumn<UserGWT>() {
            @Override
            public String getValue(UserGWT user) {
                setSortable(true);
                setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
                return String.valueOf(user.getCount());
            }
        };

        countPassedTestColumn = new TextColumn<UserGWT>() {
            @Override
            public String getValue(UserGWT user) {
                setSortable(true);
                setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
                return String.valueOf(user.getPassed());
            }
        };

        percentPassedTestColumn = new TextColumn<UserGWT>() {
            @Override
            public String getValue(UserGWT user) {
                setSortable(true);
                setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
                if(user.getPercent().isNaN()) return "0%";
                return String.valueOf(user.getPercent())+'%';
            }
        };

        userTable.addColumn(idColumn,"User ID");
        userTable.addColumn(nameColumn,"Login");
        userTable.addColumn(adminColumn,"Access");
        userTable.addColumn(countTestColumn,"Available tests");
        userTable.addColumn(countPassedTestColumn,"Passed tests");
        userTable.addColumn(percentPassedTestColumn,"Percent of correct answers");

        add(userTable);
        add(pager);
    }

    public CellTable<UserGWT> getUserTable() {
        return userTable;
    }

    public SimplePager getPager() {
        return pager;
    }

    public UserTestClient getUserTestClient() {
        return userTestClient;
    }

    public SingleSelectionModel<UserGWT> getSelectionModel() {
        return selectionModel;
    }

    public void refreshTable (List<UserGWT> userList){
        userTable.setEmptyTableWidget(new Label(" No Records Found"));
        
        ListDataProvider<UserGWT> dataProvider = new ListDataProvider<>();

        dataProvider.addDataDisplay(userTable);

        List<UserGWT> list = dataProvider.getList();

        for (UserGWT user : userList) {
            list.add(user);
        }

        ColumnSortEvent.ListHandler<UserGWT> columnSortHandler = new ColumnSortEvent.ListHandler<>(list);
        columnSortHandler.setComparator(idColumn,
                (o1, o2) -> {
                    if (o1.equals(o2)) {
                        return 0;
                    }
                    if (o1!=null) {
                        return (o2!=null) ? o1.getId().compareTo(o2.getId()) : 1;
                    }
                    return -1;
                });

        ColumnSortEvent.ListHandler<UserGWT> columnNameSortHandler = new ColumnSortEvent.ListHandler<>(list);
        columnNameSortHandler.setComparator(nameColumn,
                (o1, o2) -> {
                    if (o1.equals(o2)) {
                        return 0;
                    }
                    if (o1!=null) {
                        return (o2!=null) ? o1.getLogin().compareTo(o2.getLogin()) : 1;
                    }
                    return -1;
                });

        ColumnSortEvent.ListHandler<UserGWT> columnUserNumColumnSortHandler = new ColumnSortEvent.ListHandler<>(list);
        columnUserNumColumnSortHandler.setComparator(countTestColumn,
                (o1, o2) -> {
                    if (o1.equals(o2)) {
                        return 0;
                    }
                    if (o1!=null) {
                        return (o2!=null) ? o1.getCount().compareTo(o2.getCount()) : 1;
                    }
                    return -1;
                });

        ColumnSortEvent.ListHandler<UserGWT> columnPassedColumnSortHandler = new ColumnSortEvent.ListHandler<>(list);
        columnPassedColumnSortHandler.setComparator(countPassedTestColumn,
                (o1, o2) -> {
                    if (o1.equals(o2)) {
                        return 0;
                    }
                    if (o1!=null) {
                        return (o2!=null) ? o1.getPassed().compareTo(o2.getPassed()) : 1;
                    }
                    return -1;
                });

        ColumnSortEvent.ListHandler<UserGWT> columnPercentColumnSortHandler = new ColumnSortEvent.ListHandler<>(list);
        columnPercentColumnSortHandler.setComparator(percentPassedTestColumn,
                (o1, o2) -> {
                    if (o1.equals(o2)) {
                        return 0;
                    }
                    if (o1!=null) {
                        return (o2!=null) ? o1.getPercent().compareTo(o2.getPercent()) : 1;
                    }
                    return -1;
                });

        ColumnSortEvent.ListHandler<UserGWT> columnAdminColumnSortHandler = new ColumnSortEvent.ListHandler<>(list);
        columnAdminColumnSortHandler.setComparator(adminColumn,
                (o1, o2) -> {
                    String role1 = (o1.getAdmin()) ? "Admin":"User";
                    String role2 = (o2.getAdmin()) ? "Admin":"User";
                    if (o1.equals(o2)) {
                        return 0;
                    }
                    if (o1!=null) {
                        return (o2!=null) ? role1.compareTo(role2) : 1;
                    }
                    return -1;
                });

        userTable.getColumnSortList().clear();
        userTable.addColumnSortHandler(columnAdminColumnSortHandler);
        userTable.getColumnSortList().push(adminColumn);
        ColumnSortEvent.fire(userTable, userTable.getColumnSortList());
        userTable.addColumnSortHandler(columnPercentColumnSortHandler);
        userTable.getColumnSortList().push(percentPassedTestColumn);
        ColumnSortEvent.fire(userTable, userTable.getColumnSortList());
        userTable.addColumnSortHandler(columnPassedColumnSortHandler);
        userTable.getColumnSortList().push(countPassedTestColumn);
        ColumnSortEvent.fire(userTable, userTable.getColumnSortList());
        userTable.addColumnSortHandler(columnUserNumColumnSortHandler);
        userTable.getColumnSortList().push(countTestColumn);
        ColumnSortEvent.fire(userTable, userTable.getColumnSortList());
        userTable.addColumnSortHandler(columnNameSortHandler);
        userTable.getColumnSortList().push(nameColumn);
        ColumnSortEvent.fire(userTable, userTable.getColumnSortList());
        userTable.addColumnSortHandler(columnSortHandler);
        userTable.getColumnSortList().push(idColumn);
        ColumnSortEvent.fire(userTable, userTable.getColumnSortList());
    }
}
