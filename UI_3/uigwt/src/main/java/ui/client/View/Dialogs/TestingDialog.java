package ui.client.View.Dialogs;

import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.*;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;
import ui.client.View.ClientServices;
import ui.client.View.Elements.QuestButtonsPanel;
import ui.client.View.ResultAnswer;
import ui.client.View.Tables.AttemptsTable;
import ui.shared.*;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

public class TestingDialog extends DialogBox {
    private UserGWT userGWT;
    private Integer testId;
    private DetailTestGWT detailTestGWT;
    private ClientServices clientServices;
    private List<QuestionGWT> questionList;
    private Integer minute;
    private Integer sec;

    public TestingDialog(UserGWT userGWT, Integer testId, AttemptsTable attemptsTable, DetailTestGWT detailTestGWT, Integer time, ClientServices clientServices, int width, int height) {
        this.userGWT = userGWT;
        this.testId = testId;
        this.detailTestGWT = detailTestGWT;
        this.clientServices = clientServices;

        List<ResultAnswer> resultAnswerList = new LinkedList<>();

        minute = time/60;
        sec = time%60;

        setVisible(true);
        setPixelSize(width,height);
        center();
        VerticalPanel verticalPanel = new VerticalPanel();
        verticalPanel.setSpacing(5);
        verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        verticalPanel.add(new Label("Test started"));

        HorizontalPanel timePanel = new HorizontalPanel();
        timePanel.add(new Label("Time left: "));
        Label labelTimer = new Label();
        Timer timer = new Timer() {
            @Override
            public void run() {
                sec--;
                if ( minute == 0 && sec == 0 ) {
                    cancel();
                    int num = 0;
                    Double result=0.0;
                    Double allPoints=0.0;
                    Integer passed=0;
                    Integer failed=0;
                    for (QuestionGWT questionGWT : questionList) {
                        ResultAnswer resAnswer = new ResultAnswer();
                        for(ResultAnswer resultAnswer:resultAnswerList){
                            if(resultAnswer.getQuestId().equals(questionGWT.getId())){
                                resAnswer = resultAnswer;
                                break;
                            }
                        }
                        String answer = resAnswer.getAnswer().getSelectedValue();
                        if (answer.equals("-")) {
                            failed++;
                            allPoints += questionGWT.getPoints();
                        } else if (Integer.valueOf(answer).equals(resAnswer.getCorrect())) {
                            result += questionGWT.getPoints();
                            passed++;
                            allPoints += questionGWT.getPoints();
                        } else {
                            failed++;
                            allPoints += questionGWT.getPoints();
                        }
                        num++;
                    }

                    final Double finalResult = result;
                    final Double finalAllPoints = allPoints;
                    final Integer finalPassed = passed;
                    final Integer finalFailed = failed;
                    java.util.Date date = new java.util.Date();
                    clientServices.detailTestClient.update(new DetailTestGWT(detailTestGWT.getId(), passed, failed, result, detailTestGWT.getAttempts() + 1, new Date(date.getTime()).toString()), new MethodCallback<DetailTestGWT>() {
                        @Override
                        public void onFailure(Method method, Throwable exception) {
                            new ErrorDialog().show();
                            hide();
                        }

                        @Override
                        public void onSuccess(Method method, DetailTestGWT response) {
                            new InfoDialog("Time is over\nYour result: " + finalResult + "/" + finalAllPoints).show();
                            clientServices.userTestClient.getTests(userGWT.getId(), new MethodCallback<List<TestGWT>>() {
                                @Override
                                public void onFailure(Method method, Throwable exception) {
                                    new InfoDialog("List of tests is empty");
                                }

                                @Override
                                public void onSuccess(Method method, List<TestGWT> responseList) {
                                    List<DetailTestGWT> list = new LinkedList<>();
                                    for (TestGWT test: responseList){
                                        clientServices.userTestClient.getUserTest(userGWT.getId(), test.getId(), new MethodCallback<UserTestGWT>() {
                                            @Override
                                            public void onFailure(Method method, Throwable exception) {
                                            }

                                            @Override
                                            public void onSuccess(Method method, UserTestGWT response) {
                                                clientServices.detailTestClient.get(response.getId(), new MethodCallback<DetailTestGWT>() {
                                                    @Override
                                                    public void onFailure(Method method, Throwable exception) {

                                                    }

                                                    @Override
                                                    public void onSuccess(Method method, DetailTestGWT response) {
                                                        response.setName(test.getName());
                                                        list.add(response);
                                                        attemptsTable.refreshTable(list);
                                                    }
                                                });
                                            }
                                        });
                                    }
                                }
                            });
                            hide();
                        }
                    });
                }
                if ( sec == -1 ) {
                    sec = 59;
                    minute--;
                }
                String time = (minute <= 9 ? "0" + minute : minute) + ":" + ( sec <= 9 ? "0" + sec : sec );
                labelTimer.setText(time);
            }
        };
        timer.scheduleRepeating(1000);
        timePanel.add(labelTimer);
        verticalPanel.add(timePanel);

        Button okButton = new Button("Finish the test");
        okButton.addClickHandler(event -> {
            boolean flag = false;
            int num = 0;
            Double result=0.0;
            Double allPoints=0.0;
            Integer passed=0;
            Integer failed=0;
            for (QuestionGWT questionGWT : questionList) {
                ResultAnswer resAnswer = new ResultAnswer();
                for(ResultAnswer resultAnswer:resultAnswerList){
                    if(resultAnswer.getQuestId().equals(questionGWT.getId())){
                        resAnswer = resultAnswer;
                        break;
                    }
                }
                String answer = resAnswer.getAnswer().getSelectedValue();
                if (answer.equals("-")) {
                    flag = true;
                    failed++;
                    allPoints += questionGWT.getPoints();
                } else if (Integer.valueOf(answer).equals(resAnswer.getCorrect())) {
                    result += questionGWT.getPoints();
                    passed++;
                    allPoints += questionGWT.getPoints();
                } else {
                    failed++;
                    allPoints += questionGWT.getPoints();
                }
                num++;
            }
            if (flag) {
                DialogBox dialogBox = new DialogBox();
                dialogBox.center();
                dialogBox.setPixelSize(300, 100);
                VerticalPanel panel = new VerticalPanel();
                panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
                panel.add(new Label("You didn't answer all questions"));
                panel.add(new Label("Are you sure that you want to finish the test?"));
                HorizontalPanel horizontalPanel = new HorizontalPanel();
                Button yesButton = new Button("Yes");
                Button noButton = new Button("No");
                noButton.addClickHandler(event1 -> {
                    dialogBox.hide();
                });
                final Double finalResult = result;
                final Double finalAllPoints = allPoints;
                final Integer finalPassed = passed;
                final Integer finalFailed = failed;
                yesButton.addClickHandler(event1 -> {
                    java.util.Date date = new java.util.Date();
                    clientServices.detailTestClient.update(new DetailTestGWT(detailTestGWT.getId(), finalPassed, finalFailed, finalResult, detailTestGWT.getAttempts() + 1, new Date(date.getTime()).toString()), new MethodCallback<DetailTestGWT>() {
                        @Override
                        public void onFailure(Method method, Throwable exception) {
                            new ErrorDialog().show();
                            dialogBox.hide();
                            TestingDialog.this.hide();
                            timer.cancel();
                        }

                        @Override
                        public void onSuccess(Method method, DetailTestGWT response) {
                            new InfoDialog("Test complete\nYour result: " + finalResult + "/" + finalAllPoints).show();
                            clientServices.userTestClient.getTests(userGWT.getId(), new MethodCallback<List<TestGWT>>() {
                                @Override
                                public void onFailure(Method method, Throwable exception) {
                                    new InfoDialog("List of tests is empty");
                                }

                                @Override
                                public void onSuccess(Method method, List<TestGWT> responseList) {
                                    List<DetailTestGWT> list = new LinkedList<>();
                                    for (TestGWT test: responseList){
                                        clientServices.userTestClient.getUserTest(userGWT.getId(), test.getId(), new MethodCallback<UserTestGWT>() {
                                            @Override
                                            public void onFailure(Method method, Throwable exception) {
                                            }

                                            @Override
                                            public void onSuccess(Method method, UserTestGWT response) {
                                                clientServices.detailTestClient.get(response.getId(), new MethodCallback<DetailTestGWT>() {
                                                    @Override
                                                    public void onFailure(Method method, Throwable exception) {

                                                    }

                                                    @Override
                                                    public void onSuccess(Method method, DetailTestGWT response) {
                                                        response.setName(test.getName());
                                                        list.add(response);
                                                        attemptsTable.refreshTable(list);
                                                    }
                                                });
                                            }
                                        });
                                    }
                                }
                            });
                            timer.cancel();
                            dialogBox.hide();
                            TestingDialog.this.hide();
                        }
                    });
                });
                horizontalPanel.add(yesButton);
                horizontalPanel.add(noButton);
                panel.add(horizontalPanel);
                dialogBox.setWidget(panel);
                dialogBox.show();
            } else{
                final Double finalResult = result;
                final Double finalAllPoints = allPoints;
                java.util.Date date = new java.util.Date();
                clientServices.detailTestClient.update(new DetailTestGWT(detailTestGWT.getId(), passed, failed, result, detailTestGWT.getAttempts() + 1, new Date(date.getTime()).toString()), new MethodCallback<DetailTestGWT>() {
                    @Override
                    public void onFailure(Method method, Throwable exception) {
                        new ErrorDialog().show();
                        TestingDialog.this.hide();
                        timer.cancel();
                    }

                    @Override
                    public void onSuccess(Method method, DetailTestGWT response) {
                        new InfoDialog("Test complete\nYour result: " + finalResult + "/" + finalAllPoints).show();
                        clientServices.userTestClient.getTests(userGWT.getId(), new MethodCallback<List<TestGWT>>() {
                            @Override
                            public void onFailure(Method method, Throwable exception) {
                                new InfoDialog("List of tests is empty");
                            }

                            @Override
                            public void onSuccess(Method method, List<TestGWT> responseList) {
                                List<DetailTestGWT> list = new LinkedList<>();
                                for (TestGWT test: responseList){
                                    clientServices.userTestClient.getUserTest(userGWT.getId(), test.getId(), new MethodCallback<UserTestGWT>() {
                                        @Override
                                        public void onFailure(Method method, Throwable exception) {
                                        }

                                        @Override
                                        public void onSuccess(Method method, UserTestGWT response) {
                                            clientServices.detailTestClient.get(response.getId(), new MethodCallback<DetailTestGWT>() {
                                                @Override
                                                public void onFailure(Method method, Throwable exception) {

                                                }

                                                @Override
                                                public void onSuccess(Method method, DetailTestGWT response) {
                                                    response.setName(test.getName());
                                                    list.add(response);
                                                    attemptsTable.refreshTable(list);
                                                }
                                            });
                                        }
                                    });
                                }
                            }
                        });
                        TestingDialog.this.hide();
                        timer.cancel();
                    }
                });
            }
        });

        TabPanel tabPanel = new TabPanel();
        tabPanel.setPixelSize(width, height);
        tabPanel.setVisible(true);
        verticalPanel.add(okButton);
        verticalPanel.add(tabPanel);
        setWidget(verticalPanel);

        clientServices.testQuestClient.getQuestions(testId, new MethodCallback<List<QuestionGWT>>() {
            @Override
            public void onFailure(Method method, Throwable exception) {
                new InfoDialog("List of questions is empty").show();
            }

            @Override
            public void onSuccess(Method method, List<QuestionGWT> response) {
                questionList = response;
                List<Integer> index = new LinkedList<>();
                for (QuestionGWT questionGWT:response) {
                    VerticalPanel questPanel = new VerticalPanel();
                    questPanel.setVisible(true);
                    Label questLabel = new Label(questionGWT.getText());
                    questLabel.setPixelSize(width, 30);
                    questPanel.add(questLabel);
                    clientServices.answerClient.getAnswers(questionGWT.getId(), new MethodCallback<List<AnswerGWT>>() {
                        @Override
                        public void onFailure(Method method, Throwable exception) {
                        }

                        @Override
                        public void onSuccess(Method method, List<AnswerGWT> response) {
                            int number = 1;
                            ListBox answerBox = new ListBox();
                            ResultAnswer resultAnswer = new ResultAnswer();
                            resultAnswer.setQuestId(questionGWT.getId());
                            for (AnswerGWT answerGWT : response) {
                                if(answerGWT.getCorrect()) resultAnswer.setCorrect(number);
                                HorizontalPanel horizontalPanel = new HorizontalPanel();
                                horizontalPanel.setPixelSize(width, 20);
                                horizontalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP);
                                horizontalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
                                horizontalPanel.add(new Label(number + ". " + answerGWT.getText()));
                                number++;
                                questPanel.add(horizontalPanel);
                            }
                            HorizontalPanel horizontalPanel = new HorizontalPanel();
                            horizontalPanel.add(new Label("Answer: "));
                            answerBox.setVisibleItemCount(1);
                            answerBox.setMultipleSelect(false);
                            answerBox.addItem("-");
                            for (int i = 1; i < number; i++) answerBox.addItem(String.valueOf(i));
                            answerBox.setSelectedIndex(0);
                            resultAnswer.setAnswer(answerBox);
                            resultAnswerList.add(resultAnswer);
                            horizontalPanel.add(answerBox);
                            questPanel.add(horizontalPanel);
                            questPanel.add(new QuestButtonsPanel(width, tabPanel, index.size(), questionList.size()));
                            index.add(0);
                            tabPanel.add(questPanel, "Quest#" + index.size());
                            tabPanel.selectTab(0);
                        }
                    });
                }
            }
        });

        tabPanel.addSelectionHandler(event -> {
            tabPanel.selectTab(event.getSelectedItem());
        });
        tabPanel.selectTab(0);
    }
}
