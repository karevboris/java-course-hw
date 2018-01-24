package ui.client.View;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.MultiSelectionModel;
import ui.shared.TestGWT;

import java.util.LinkedList;
import java.util.List;

public class TestView extends VerticalPanel {
    private int tryNum;
    public TestView(String width, String height) {

        setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        setWidth("400");
        HorizontalPanel forButton = new HorizontalPanel();
        forButton.setHeight("20");
        forButton.setWidth("400");
        forButton.setSpacing(10);

        Button newTestButton = new Button("Add new test");
        Button deleteTestButton = new Button("Delete test");
        Button editTestButton = new Button("Edit test");

        forButton.add(newTestButton);
        forButton.add(editTestButton);
        forButton.add(deleteTestButton);

        CellTable table = new CellTable<TestGWT>();

        final MultiSelectionModel<TestGWT> selectionModel
                = new MultiSelectionModel<>();
        table.setSelectionModel(selectionModel);
        /*selectionModel.addSelectionChangeHandler(event -> {
            TestClient selected = selectionModel.getSelectedObject();
            if (selected != null) {
                (new TestEditDialog(width, height)).show();
            }
        });*/

        TextColumn<TestGWT> idColumn = new TextColumn<TestGWT>() {
            @Override
            public String getValue(TestGWT testClient) {
                setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
                return String.valueOf(testClient.getId());
            }
        };

        TextColumn<TestGWT> nameColumn = new TextColumn<TestGWT>() {
            @Override
            public String getValue(TestGWT testClient) {
                setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
                return testClient.getName();
            }
        };

        TextColumn<TestGWT> userNumColumn = new TextColumn<TestGWT>() {
            @Override
            public String getValue(TestGWT testClient) {
                //TODO
                setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
                return "10";
            }
        };

        TextColumn<TestGWT> tryNumColumn = new TextColumn<TestGWT>() {
            @Override
            public String getValue(TestGWT testClient) {
                //TODO
                setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
                tryNum = 20;
                return "20";
            }
        };

        TextColumn<TestGWT> passedNumColumn = new TextColumn<TestGWT>() {
            @Override
            public String getValue(TestGWT testClient) {
                //TODO
                setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
                return String.valueOf(((double)10)/tryNum*100)+'%';
            }
        };

        table.addColumn(idColumn,"ID");
        table.addColumn(nameColumn, "Name");
        table.addColumn(userNumColumn, "Number of users with access");
        table.addColumn(tryNumColumn, "Attempts of passing");
        table.addColumn(passedNumColumn, "Percent of passing");

        ListDataProvider<TestGWT> dataProvider = new ListDataProvider<TestGWT>();

        dataProvider.addDataDisplay(table);

        List<TestGWT> list = dataProvider.getList();

        list.add(new TestGWT(1, "newTest",10));
        list.add(new TestGWT(1, "newTest",10));
        list.add(new TestGWT(1, "newTest",10));
        list.add(new TestGWT(1, "newTest",10));

        setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        add(forButton);
        add(table);

        editTestButton.addClickHandler(event -> {
            List<TestGWT> list1 = dataProvider.getList();
            for(TestGWT test: list1){
                if(selectionModel.isSelected(test)) (new TestEditDialog(test, width, height)).show();
                break;
            }
        });

        deleteTestButton.addClickHandler(event -> {
            List<TestGWT> list12 = dataProvider.getList();
            List<TestGWT> copy = new LinkedList<>(list12);
            for(TestGWT test:copy){
            if(selectionModel.isSelected(test)) list12.remove(test);
            }
        });

        SimplePager pager;
        SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
        pager = new SimplePager(SimplePager.TextLocation.CENTER, pagerResources, false, 0, true);
        pager.setDisplay(table);
        add(pager);

        setVisible(true);

    }
}
