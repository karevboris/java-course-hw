package ui.client.View.Tables;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SingleSelectionModel;
import ui.shared.AnswerGWT;

import java.util.List;

public class AnswerTable extends VerticalPanel {
    private CellTable<AnswerGWT> answerTable;
    private SimplePager pager;
    private final SingleSelectionModel<AnswerGWT> selectionModel;

    public AnswerTable() {
        setVisible(true);
        setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

        answerTable = new CellTable<>();
        pager = new SimplePager();

        SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
        pager = new SimplePager(SimplePager.TextLocation.CENTER, pagerResources, false, 0, true);
        pager.setDisplay(answerTable);

        selectionModel = new SingleSelectionModel<>();
        answerTable.setSelectionModel(selectionModel);

        TextColumn<AnswerGWT> idColumn = new TextColumn<AnswerGWT>() {
            @Override
            public String getValue(AnswerGWT answer) {
                setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
                return String.valueOf(answer.getId());
            }
        };

        TextColumn<AnswerGWT> nameColumn = new TextColumn<AnswerGWT>() {
            @Override
            public String getValue(AnswerGWT answer) {
                setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
                return String.valueOf(answer.getText());
            }
        };

        TextColumn<AnswerGWT> correctColumn = new TextColumn<AnswerGWT>() {
            @Override
            public String getValue(AnswerGWT answer) {
                setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
                return answer.getCorrect()? "Yes":"No";
            }
        };

        answerTable.addColumn(idColumn, "Id");
        answerTable.addColumn(correctColumn, "Correct answer");
        answerTable.addColumn(nameColumn, "Text");

        add(answerTable);
        add(pager);
    }

    public void refreshTable (List<AnswerGWT> answerList) {
        answerTable.setEmptyTableWidget(new Label(" No Records Found"));

        ListDataProvider<AnswerGWT> dataProvider = new ListDataProvider<>();

        dataProvider.addDataDisplay(answerTable);

        List<AnswerGWT> list = dataProvider.getList();

        for (AnswerGWT answer : answerList) {
            list.add(answer);
        }
    }

    public CellTable<AnswerGWT> getAnswerTable() {
        return answerTable;
    }

    public SimplePager getPager() {
        return pager;
    }

    public SingleSelectionModel<AnswerGWT> getSelectionModel() {
        return selectionModel;
    }
}
