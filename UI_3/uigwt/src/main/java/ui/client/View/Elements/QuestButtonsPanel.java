package ui.client.View.Elements;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TabPanel;

public class QuestButtonsPanel extends HorizontalPanel {
    public QuestButtonsPanel(int width, TabPanel tabPanel, int index, int size) {
        setSpacing(10);
        Button nextButton = new Button("Next");
        Button prevButton = new Button("Prev");
        add(nextButton);
        add(prevButton);

        if(index+1==size) nextButton.setEnabled(false);
        if(index==0) prevButton.setEnabled(false);

        nextButton.addClickHandler(event -> {
            tabPanel.selectTab(index+1);
        });

        prevButton.addClickHandler(event -> {
           tabPanel.selectTab(index-1);
        });
    }
}
