package ui.client.View.Tables;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.ColumnSortEvent;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SingleSelectionModel;
import ui.client.View.ClientServices;
import ui.shared.DetailTestGWT;

import java.util.List;

public class AttemptsTable extends VerticalPanel {
    private CellTable<DetailTestGWT> table;
    private SimplePager pager;
    private ClientServices clientServices;
    private final SingleSelectionModel<DetailTestGWT> selectionModel;
    private TextColumn<DetailTestGWT> nameColumn;
    private TextColumn<DetailTestGWT> attemptsColumn;
    private TextColumn<DetailTestGWT> passedCountColumn;
    private TextColumn<DetailTestGWT> failedCountColumn;
    private TextColumn<DetailTestGWT> resultColumn;

    public AttemptsTable(ClientServices clientServices) {
        this.clientServices = clientServices;
        setVisible(true);
        setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

        table = new CellTable<>();
        pager = new SimplePager();

        SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
        pager = new SimplePager(SimplePager.TextLocation.CENTER, pagerResources, false, 0, true);
        pager.setDisplay(table);

        selectionModel = new SingleSelectionModel<>();
        table.setSelectionModel(selectionModel);

        nameColumn = new TextColumn<DetailTestGWT>() {
            @Override
            public String getValue(DetailTestGWT detailTestGWT) {
                setSortable(true);
                setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
                return String.valueOf(detailTestGWT.getName());
            }
        };

        attemptsColumn = new TextColumn<DetailTestGWT>() {
            @Override
            public String getValue(DetailTestGWT detailTestGWT) {
                setSortable(true);
                setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
                return String.valueOf(detailTestGWT.getAttempts());
            }
        };

        passedCountColumn = new TextColumn<DetailTestGWT>() {
            @Override
            public String getValue(DetailTestGWT detailTestGWT) {
                setSortable(true);
                setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
                return String.valueOf(detailTestGWT.getCountPassed());
            }
        };

        failedCountColumn = new TextColumn<DetailTestGWT>() {
            @Override
            public String getValue(DetailTestGWT detailTestGWT) {
                setSortable(true);
                setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
                return String.valueOf(detailTestGWT.getCountFailed());
            }
        };

        resultColumn = new TextColumn<DetailTestGWT>() {
            @Override
            public String getValue(DetailTestGWT detailTestGWT) {
                setSortable(true);
                setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
                return String.valueOf(detailTestGWT.getResult());
            }
        };

        table.addColumn(nameColumn, "Name of test");
        table.addColumn(attemptsColumn, "Number of attempts");
        table.addColumn(passedCountColumn, "Number of correct answers");
        table.addColumn(failedCountColumn, "Number of incorrect answers");
        table.addColumn(resultColumn, "Result");

        add(table);
        add(pager);
    }

    public void refreshTable (List<DetailTestGWT> testList){
        ListDataProvider<DetailTestGWT> dataProvider = new ListDataProvider<>();

        dataProvider.addDataDisplay(table);

        List<DetailTestGWT> list = dataProvider.getList();

        for (DetailTestGWT test : testList) {
            list.add(test);
        }

        ColumnSortEvent.ListHandler<DetailTestGWT> columnNameSortHandler = new ColumnSortEvent.ListHandler<>(list);
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

        ColumnSortEvent.ListHandler<DetailTestGWT> columnSortHandler = new ColumnSortEvent.ListHandler<>(list);
        columnSortHandler.setComparator(attemptsColumn,
                (o1, o2) -> {
                    if (o1.equals(o2)) {
                        return 0;
                    }
                    if (o1!=null) {
                        return (o2!=null) ? o1.getAttempts().compareTo(o2.getAttempts()) : 1;
                    }
                    return -1;
                });

        ColumnSortEvent.ListHandler<DetailTestGWT> columnUserNumColumnSortHandler = new ColumnSortEvent.ListHandler<>(list);
        columnUserNumColumnSortHandler.setComparator(failedCountColumn,
                (o1, o2) -> {
                    if (o1.equals(o2)) {
                        return 0;
                    }
                    if (o1!=null) {
                        return (o2!=null) ? o1.getCountFailed().compareTo(o2.getCountFailed()) : 1;
                    }
                    return -1;
                });

        ColumnSortEvent.ListHandler<DetailTestGWT> columnPassedColumnSortHandler = new ColumnSortEvent.ListHandler<>(list);
        columnPassedColumnSortHandler.setComparator(resultColumn,
                (o1, o2) -> {
                    if (o1.equals(o2)) {
                        return 0;
                    }
                    if (o1!=null) {
                        return (o2!=null) ? o1.getResult().compareTo(o2.getResult()) : 1;
                    }
                    return -1;
                });

        ColumnSortEvent.ListHandler<DetailTestGWT> columnPercentColumnSortHandler = new ColumnSortEvent.ListHandler<>(list);
        columnPercentColumnSortHandler.setComparator(passedCountColumn,
                (o1, o2) -> {
                    if (o1.equals(o2)) {
                        return 0;
                    }
                    if (o1!=null) {
                        return (o2!=null) ? o1.getCountPassed().compareTo(o2.getCountPassed()) : 1;
                    }
                    return -1;
                });


        table.getColumnSortList().clear();
        table.addColumnSortHandler(columnPercentColumnSortHandler);
        table.getColumnSortList().push(passedCountColumn);
        ColumnSortEvent.fire(table, table.getColumnSortList());
        table.addColumnSortHandler(columnPassedColumnSortHandler);
        table.getColumnSortList().push(failedCountColumn);
        ColumnSortEvent.fire(table, table.getColumnSortList());
        table.addColumnSortHandler(columnUserNumColumnSortHandler);
        table.getColumnSortList().push(resultColumn);
        ColumnSortEvent.fire(table, table.getColumnSortList());
        table.addColumnSortHandler(columnSortHandler);
        table.getColumnSortList().push(attemptsColumn);
        ColumnSortEvent.fire(table, table.getColumnSortList());
        table.addColumnSortHandler(columnNameSortHandler);
        table.getColumnSortList().push(nameColumn);
        ColumnSortEvent.fire(table, table.getColumnSortList());
    }

    public CellTable<DetailTestGWT> getCellTable() {
        return table;
    }

    public SimplePager getPager() {
        return pager;
    }

    public ClientServices getClientServices() {
        return clientServices;
    }

    public SingleSelectionModel<DetailTestGWT> getSelectionModel() {
        return selectionModel;
    }
}
