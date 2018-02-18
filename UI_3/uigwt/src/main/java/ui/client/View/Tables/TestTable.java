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
import ui.shared.TestGWT;

import java.util.List;

public class TestTable extends VerticalPanel {
    private CellTable<TestGWT> testTable;
    private SimplePager pager;
    private UserTestClient userTestClient;
    private final SingleSelectionModel<TestGWT> selectionModel;
    private TextColumn<TestGWT> idColumn;
    private TextColumn<TestGWT> nameColumn;
    private TextColumn<TestGWT> userNumColumn;
    private TextColumn<TestGWT> tryNumColumn;
    private TextColumn<TestGWT> passedNumColumn;
    public TestTable(UserTestClient userTestClient) {
        setVisible(true);
        setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

        this.userTestClient = userTestClient;
        testTable = new CellTable<>();
        pager = new SimplePager();

        SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
        pager = new SimplePager(SimplePager.TextLocation.CENTER, pagerResources, false, 0, true);
        pager.setDisplay(testTable);

        selectionModel = new SingleSelectionModel<>();
        testTable.setSelectionModel(selectionModel);

        idColumn = new TextColumn<TestGWT>() {
            @Override
            public String getValue(TestGWT testClient) {
                setSortable(true);
                setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
                return String.valueOf(testClient.getId());
            }
        };

        nameColumn = new TextColumn<TestGWT>() {
            @Override
            public String getValue(TestGWT testClient) {
                setSortable(true);
                setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
                return testClient.getName();
            }
        };

        userNumColumn = new TextColumn<TestGWT>() {
            @Override
            public String getValue(TestGWT test) {
                setSortable(true);
                setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
                return String.valueOf(test.getCount());
            }
        };

        tryNumColumn = new TextColumn<TestGWT>() {
            @Override
            public String getValue(TestGWT test) {
                setSortable(true);
                setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
                return String.valueOf(test.getPassed());
            }
        };

        passedNumColumn = new TextColumn<TestGWT>() {
            @Override
            public String getValue(TestGWT test) {
                setSortable(true);
                setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
                if(test.getPercent().isNaN()) return "0%";
                return String.valueOf(test.getPercent())+'%';
            }
        };

        testTable.addColumn(idColumn,"Test ID");
        testTable.addColumn(nameColumn, "Name");
        testTable.addColumn(userNumColumn, "Number of users with access");
        testTable.addColumn(tryNumColumn, "Attempts of passing");
        testTable.addColumn(passedNumColumn, "Percent of passing");

        add(testTable);
        add(pager);
    }

    public CellTable<TestGWT> getTestTable() {
        return testTable;
    }

    public SimplePager getPager() {
        return pager;
    }

    public UserTestClient getUserTestClient() {
        return userTestClient;
    }

    public SingleSelectionModel<TestGWT> getSelectionModel() {
        return selectionModel;
    }

    public void refreshTable (List<TestGWT> testList){
        testTable.setEmptyTableWidget(new Label(" No Records Found"));

        ListDataProvider<TestGWT> dataProvider = new ListDataProvider<>();

        dataProvider.addDataDisplay(testTable);

        List<TestGWT> list = dataProvider.getList();

        list.clear();

        for (TestGWT test : testList) {
            list.add(test);
        }

        dataProvider.flush();
        dataProvider.refresh();

        ColumnSortEvent.ListHandler<TestGWT> columnSortHandler = new ColumnSortEvent.ListHandler<>(list);
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

        ColumnSortEvent.ListHandler<TestGWT> columnNameSortHandler = new ColumnSortEvent.ListHandler<>(list);
        columnNameSortHandler.setComparator(nameColumn,
                (o1, o2) -> {
                    if (o1.equals(o2)) {
                        return 0;
                    }
                    if (o1!=null) {
                        return (o2!=null) ? o1.getName().compareTo(o2.getName()) : 1;
                    }
                    return -1;
                });

        ColumnSortEvent.ListHandler<TestGWT> columnUserNumColumnSortHandler = new ColumnSortEvent.ListHandler<>(list);
        columnUserNumColumnSortHandler.setComparator(userNumColumn,
                (o1, o2) -> {
                    if (o1.equals(o2)) {
                        return 0;
                    }
                    if (o1!=null) {
                        return (o2!=null) ? o1.getCount().compareTo(o2.getCount()) : 1;
                    }
                    return -1;
                });

        ColumnSortEvent.ListHandler<TestGWT> columnPassedColumnSortHandler = new ColumnSortEvent.ListHandler<>(list);
        columnPassedColumnSortHandler.setComparator(tryNumColumn,
                (o1, o2) -> {
                    if (o1.equals(o2)) {
                        return 0;
                    }
                    if (o1!=null) {
                        return (o2!=null) ? o1.getPassed().compareTo(o2.getPassed()) : 1;
                    }
                    return -1;
                });

        ColumnSortEvent.ListHandler<TestGWT> columnPercentColumnSortHandler = new ColumnSortEvent.ListHandler<>(list);
        columnPercentColumnSortHandler.setComparator(passedNumColumn,
                (o1, o2) -> {
                    if (o1.equals(o2)) {
                        return 0;
                    }
                    if (o1!=null) {
                        return (o2!=null) ? o1.getPercent().compareTo(o2.getPercent()) : 1;
                    }
                    return -1;
                });

        testTable.getColumnSortList().clear();
        testTable.addColumnSortHandler(columnPercentColumnSortHandler);
        testTable.getColumnSortList().push(passedNumColumn);
        ColumnSortEvent.fire(testTable, testTable.getColumnSortList());
        testTable.getColumnSortList().clear();
        testTable.addColumnSortHandler(columnPassedColumnSortHandler);
        testTable.getColumnSortList().push(tryNumColumn);
        ColumnSortEvent.fire(testTable, testTable.getColumnSortList());
        testTable.getColumnSortList().clear();
        testTable.addColumnSortHandler(columnUserNumColumnSortHandler);
        testTable.getColumnSortList().push(userNumColumn);
        ColumnSortEvent.fire(testTable, testTable.getColumnSortList());
        testTable.getColumnSortList().clear();
        testTable.addColumnSortHandler(columnNameSortHandler);
        testTable.getColumnSortList().push(nameColumn);
        ColumnSortEvent.fire(testTable, testTable.getColumnSortList());
        testTable.getColumnSortList().clear();
        testTable.addColumnSortHandler(columnSortHandler);
        testTable.getColumnSortList().push(idColumn);
        ColumnSortEvent.fire(testTable, testTable.getColumnSortList());
    }
}
