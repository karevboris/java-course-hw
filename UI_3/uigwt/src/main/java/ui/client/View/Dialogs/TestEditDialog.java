package ui.client.View.Dialogs;

import com.google.gwt.user.client.ui.*;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;
import ui.client.Client;
import ui.client.View.ClientServices;
import ui.client.View.Elements.Field;
import ui.client.View.Tables.AnswerTable;
import ui.client.View.Tables.TestTable;
import ui.shared.*;

import java.util.*;

public class TestEditDialog extends DialogBox {
    private TestGWT testGWT;
    private HorizontalPanel horizontalPanel;
    private ClientServices clientServices;
    private List<QuestionGWT> questList;

    public TestEditDialog(Client client, ClientServices clientServices, TestGWT testGWT, TestTable testTable, int width, int height) {
        setTitle("Edit Test");
        this.testGWT = testGWT;
        this.clientServices = clientServices;
        if (testGWT.getId().equals(-1)) {
            setTitle("Create Test");
            getElement().setAttribute("title", "Create Test");
            setPixelSize(300, 100);
            center();
            VerticalPanel panel = new VerticalPanel();
            panel.setSpacing(1);
            panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

            Field field = new Field("Enter test name:");

            HorizontalPanel horizontalPanel = new HorizontalPanel();
            Button okButton = new Button("Ok");
            Button cancelButton = new Button("Cancel");
            cancelButton.addClickHandler(event -> hide());
            okButton.addClickHandler(event -> {
                if (field.getTextBox().getText().isEmpty()) new InfoDialog("Incorrect name of test");
                else {
                    clientServices.testClient.add(new TestGWT(0, field.getTextBox().getText(), testGWT.getUserId()), new MethodCallback<TestGWT>() {
                        @Override
                        public void onFailure(Method method, Throwable exception) {
                            new ErrorDialog().show();
                        }

                        @Override
                        public void onSuccess(Method method, TestGWT response) {
                            new InfoDialog("Test added");
                            hide();
                            client.refreshTestTable(clientServices, testTable);
                        }
                    });
                }
            });
            horizontalPanel.add(okButton);
            horizontalPanel.add(cancelButton);
            horizontalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
            panel.add(field);
            panel.add(horizontalPanel);
            setWidget(panel);
        } else {
            setPixelSize(width, height);
            horizontalPanel = new HorizontalPanel();
            horizontalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
            horizontalPanel.setBorderWidth(1);

            VerticalPanel rightVerticalPanel = new VerticalPanel();
            rightVerticalPanel.setWidth(String.valueOf(3 * width / 4));
            rightVerticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
            rightVerticalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP);
            rightVerticalPanel.setSpacing(10);

            AnswerTable answerTable = new AnswerTable();
            clientServices.testQuestClient.getQuestions(this.testGWT.getId(), new MethodCallback<List<QuestionGWT>>() {
                @Override
                public void onFailure(Method method, Throwable exception) {
                    new InfoDialog("List").show();
                }

                @Override
                public void onSuccess(Method method, List<QuestionGWT> response) {
                    clientServices.answerClient.getAnswers(response.get(0).getId(), new MethodCallback<List<AnswerGWT>>() {
                        @Override
                        public void onFailure(Method method, Throwable exception) {
                            new InfoDialog("List of answers is empty").show();
                        }

                        @Override
                        public void onSuccess(Method method, List<AnswerGWT> response) {
                            answerTable.refreshTable(response);
                        }
                    });
                }
            });

            Field questBox = new Field("Question: ");
            Field timeBox = new Field("Time: ");
            Field pointsBox = new Field("Points: ");

            HorizontalPanel questButtonPanel = new HorizontalPanel();
            questButtonPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
            questButtonPanel.setSpacing(5);

            Button saveButton = new Button("Save");
            Button addAnswerButton = new Button("Add answer");
            Button deleteAnswerButton = new Button("Delete answer");
            Button editAnswerButton = new Button("Edit answer");

            questButtonPanel.add(saveButton);
            questButtonPanel.add(addAnswerButton);
            questButtonPanel.add(editAnswerButton);
            questButtonPanel.add(deleteAnswerButton);

            VerticalPanel leftVerticalPanel = new VerticalPanel();
            leftVerticalPanel.setPixelSize(width / 4, height);
            leftVerticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
            leftVerticalPanel.setSpacing(1);
            leftVerticalPanel.setBorderWidth(0);

            leftVerticalPanel.add(new Label("Test name:"));
            TextArea testNameTextArea = new TextArea();
            testNameTextArea.setText(testGWT.getName());
            leftVerticalPanel.add(testNameTextArea);

            HorizontalPanel idPanel = new HorizontalPanel();
            idPanel.setSpacing(5);
            idPanel.add(new Label("Add users: "));
            idPanel.add(new Label("Remove users: "));
            ListBox userListBox = new ListBox();
            userListBox.setMultipleSelect(true);
            userListBox.setVisibleItemCount(5);
            userListBox.setWidth("10");
            userListBox.setPixelSize(100, 100);

            HorizontalPanel userRemovePanel = new HorizontalPanel();
            userRemovePanel.add(userListBox);
            ListBox userRemoveListBox = new ListBox();
            userRemoveListBox.setMultipleSelect(true);
            userRemoveListBox.setVisibleItemCount(5);
            userRemovePanel.add(userRemoveListBox);
            userRemoveListBox.setPixelSize(100, 100);

            refreshUsersList(userListBox, userRemoveListBox);

            Button userAddButton = new Button("Save users");
            userAddButton.addClickHandler(event -> {
                List<UserGWT> addList = new LinkedList<>();
                List<UserGWT> removeList = new LinkedList<>();
                for (int i = 0; i < userListBox.getItemCount(); i++) {
                    if (userListBox.isItemSelected(i)) {
                        String line = userListBox.getItemText(i);
                        StringBuilder res = new StringBuilder();
                        int j = 0;
                        while ((j < line.length()) && (line.charAt(j) != ':')) {
                            res.append(line.charAt(j));
                            j++;
                        }
                        addList.add(new UserGWT(Integer.valueOf(res.toString()), line, String.valueOf(i), false));
                    }
                }
                for (UserGWT user : addList) {
                    clientServices.userTestClient.add(new UserTestGWT(0, user.getId(), this.testGWT.getId()), new MethodCallback<UserTestGWT>() {
                        @Override
                        public void onFailure(Method method, Throwable exception) {

                        }

                        @Override
                        public void onSuccess(Method method, UserTestGWT response) {
                            Date date = new Date();
                            clientServices.detailTestClient.add(new DetailTestGWT(0, 0, 0, 0.0, 0, new java.sql.Date(date.getTime()).toString()), new MethodCallback<DetailTestGWT>() {
                                @Override
                                public void onFailure(Method method, Throwable exception) {

                                }

                                @Override
                                public void onSuccess(Method method, DetailTestGWT response) {
                                    userListBox.removeItem(Integer.valueOf(user.getPassword()));
                                }
                            });
                        }
                    });
                }

                for (int i = 0; i < userRemoveListBox.getItemCount(); i++) {
                    if (userRemoveListBox.isItemSelected(i)) {
                        String line = userRemoveListBox.getItemText(i);
                        StringBuilder res = new StringBuilder();
                        int j = 0;
                        while ((j < line.length()) && (line.charAt(j) != ':')) {
                            res.append(line.charAt(j));
                            j++;
                        }
                        removeList.add(new UserGWT(Integer.valueOf(res.toString()), line, String.valueOf(i), false));
                    }
                }

                for (UserGWT user : addList) {
                    userRemoveListBox.addItem(user.getLogin());
                }

                for (UserGWT user : removeList) {
                    clientServices.userTestClient.getUserTest(user.getId(), this.testGWT.getId(), new MethodCallback<UserTestGWT>() {
                        @Override
                        public void onFailure(Method method, Throwable exception) {
                        }

                        @Override
                        public void onSuccess(Method method, UserTestGWT response) {
                            clientServices.userTestClient.deleteById(response.getId(), new MethodCallback<Integer>() {
                                @Override
                                public void onFailure(Method method, Throwable exception) {
                                }

                                @Override
                                public void onSuccess(Method method, Integer response) {
                                    userRemoveListBox.removeItem(Integer.valueOf(user.getPassword()));
                                    userListBox.addItem(user.getLogin());
                                }
                            });
                        }
                    });
                }
            });

            idPanel.setBorderWidth(0);
            userRemovePanel.setBorderWidth(0);
            leftVerticalPanel.add(idPanel);
            leftVerticalPanel.add(userRemovePanel);
            leftVerticalPanel.add(userAddButton);

            ListBox questionsListBox = new ListBox();
            questionsListBox.setVisibleItemCount(1);
            clientServices.testQuestClient.getQuestions(this.testGWT.getId(), new MethodCallback<List<QuestionGWT>>() {
                @Override
                public void onFailure(Method method, Throwable exception) {
                    new ErrorDialog().show();
                }

                @Override
                public void onSuccess(Method method, List<QuestionGWT> response) {
                    questList = response;
                    int i = 1;
                    questBox.getTextBox().setText(response.get(0).getText());
                    timeBox.getTextBox().setText(response.get(0).getTime().toString());
                    pointsBox.getTextBox().setText(response.get(0).getPoints().toString());
                    refreshAnswerTable(clientServices, answerTable, response.get(0).getId());
                    for (QuestionGWT questionGWT : response) {
                        questionsListBox.addItem("Question #" + i);
                        i++;
                    }
                }
            });

            questionsListBox.addChangeHandler(event -> {
                clientServices.testQuestClient.getQuestions(this.testGWT.getId(), new MethodCallback<List<QuestionGWT>>() {
                    @Override
                    public void onFailure(Method method, Throwable exception) {
                        new InfoDialog("List of questions is empty").show();
                    }

                    @Override
                    public void onSuccess(Method method, List<QuestionGWT> response) {
                        questList = response;
                        QuestionGWT question = response.get(questionsListBox.getSelectedIndex());
                        questBox.getTextBox().setText(question.getText());
                        timeBox.getTextBox().setText(question.getTime().toString());
                        pointsBox.getTextBox().setText(question.getPoints().toString());
                        refreshAnswerTable(clientServices, answerTable, question.getId());
                    }
                });
            });

            leftVerticalPanel.add(questionsListBox);

            addAnswerButton.addClickHandler(event -> {
                int index = questionsListBox.getSelectedIndex();
                new AnswerAddDialog(clientServices, answerTable, questList.get(index).getId(), null).show();
                cleanUserTest(testGWT.getId());
            });

            editAnswerButton.addClickHandler(event -> {
                int index = questionsListBox.getSelectedIndex();
                new AnswerAddDialog(clientServices, answerTable, questList.get(index).getId(), answerTable.getSelectionModel().getSelectedObject()).show();
                cleanUserTest(testGWT.getId());
            });

            saveButton.addClickHandler(event -> {
                int index = questionsListBox.getSelectedIndex();
                if (questBox.getTextBox().getText().length() < 10) new InfoDialog("The question is too short").show();
                else try {
                    Integer time = Integer.valueOf(timeBox.getTextBox().getText());
                    Double points = Double.valueOf(pointsBox.getTextBox().getText());
                    if (time < 10 || points <= 0) throw new NumberFormatException();
                    QuestionGWT questionGWT = questList.get(index);
                    clientServices.questionClient.update(new QuestionGWT(questionGWT.getId(), questBox.getTextBox().getText(), time, points), new MethodCallback<QuestionGWT>() {
                        @Override
                        public void onFailure(Method method, Throwable exception) {
                            new ErrorDialog().show();
                        }

                        @Override
                        public void onSuccess(Method method, QuestionGWT response) {
                            cleanUserTest(testGWT.getId());
                            new InfoDialog("Question updated").show();
                        }
                    });
                } catch (NumberFormatException ex) {
                    new InfoDialog("Incorrect data format for question").show();
                }
            });

            deleteAnswerButton.addClickHandler(event -> {
                AnswerGWT answer = answerTable.getSelectionModel().getSelectedObject();
                if (answer != null)
                    clientServices.answerClient.deleteById(answer.getId(), new MethodCallback<Integer>() {
                        @Override
                        public void onFailure(Method method, Throwable exception) {
                            new ErrorDialog().show();
                        }

                        @Override
                        public void onSuccess(Method method, Integer response) {
                            new InfoDialog("Answers deleted").show();
                            cleanUserTest(testGWT.getId());
                            QuestionGWT question = questList.get(questionsListBox.getSelectedIndex());
                            refreshAnswerTable(clientServices, answerTable, question.getId());
                        }
                    });
            });

            Button addQuestionButton = new Button("Add question");
            addQuestionButton.addClickHandler(event -> {
                new QuestionAddDialog(clientServices, questionsListBox, this.testGWT).show();
                clientServices.testQuestClient.getQuestions(this.testGWT.getId(), new MethodCallback<List<QuestionGWT>>() {
                    @Override
                    public void onFailure(Method method, Throwable exception) {
                        new InfoDialog("List of questions is empty").show();
                    }

                    @Override
                    public void onSuccess(Method method, List<QuestionGWT> response) {
                        questList = response;
                        cleanUserTest(testGWT.getId());
                    }
                });
            });
            leftVerticalPanel.add(addQuestionButton);

            Button deleteQuestionButton = new Button("Delete question");
            deleteQuestionButton.addClickHandler(event -> {
                clientServices.testQuestClient.getQuestions(TestEditDialog.this.testGWT.getId(), new MethodCallback<List<QuestionGWT>>() {
                    @Override
                    public void onFailure(Method method, Throwable exception) {
                        new InfoDialog("Question not found").show();
                    }

                    @Override
                    public void onSuccess(Method method, List<QuestionGWT> response) {
                        int idQuest = response.get(questionsListBox.getSelectedIndex()).getId();
                        clientServices.questionClient.deleteById(idQuest, new MethodCallback<Integer>() {
                            @Override
                            public void onFailure(Method method, Throwable exception) {
                                new ErrorDialog().show();
                            }

                            @Override
                            public void onSuccess(Method method, Integer response) {
                                clientServices.testQuestClient.getQuestions(TestEditDialog.this.testGWT.getId(), new MethodCallback<List<QuestionGWT>>() {
                                    @Override
                                    public void onFailure(Method method, Throwable exception) {
                                        new ErrorDialog().show();
                                    }

                                    @Override
                                    public void onSuccess(Method method, List<QuestionGWT> response) {
                                        questList = response;
                                        questionsListBox.clear();
                                        int i = 1;
                                        for (QuestionGWT questionGWT : response) {
                                            questionsListBox.addItem("Question #" + i);
                                            i++;
                                        }
                                    }
                                });
                                new InfoDialog("Question deleted");
                                cleanUserTest(testGWT.getId());
                            }
                        });
                    }
                });
            });
            leftVerticalPanel.add(deleteQuestionButton);

            Button okButton = new Button("Ok");
            okButton.addClickHandler(event -> {
                if (!TestEditDialog.this.testGWT.getName().equals(testNameTextArea.getText())) {
                    if (testNameTextArea.getText().isEmpty()) new InfoDialog("Test name is empty").show();
                    else {
                        TestEditDialog.this.testGWT = new TestGWT(TestEditDialog.this.testGWT.getId(), testNameTextArea.getText(), TestEditDialog.this.testGWT.getUserId());
                        clientServices.testClient.update(TestEditDialog.this.testGWT, new MethodCallback<TestGWT>() {
                            @Override
                            public void onFailure(Method method, Throwable exception) {
                                new ErrorDialog().show();
                            }

                            @Override
                            public void onSuccess(Method method, TestGWT response) {
                                new InfoDialog("Test update");
                                hide();
                                client.refreshTestTable(clientServices, testTable);
                            }
                        });
                    }
                } else {
                    new InfoDialog("Test update");
                    hide();
                    client.refreshTestTable(clientServices, testTable);
                }
            });
            leftVerticalPanel.add(okButton);
            Button cancelButton = new Button("Cancel");
            cancelButton.addClickHandler(event -> hide());
            leftVerticalPanel.add(cancelButton);

            rightVerticalPanel.add(new Label("Option of question"));
            rightVerticalPanel.add(questButtonPanel);
            rightVerticalPanel.add(questBox);
            rightVerticalPanel.add(timeBox);
            rightVerticalPanel.add(pointsBox);
            rightVerticalPanel.add(answerTable);

            horizontalPanel.add(leftVerticalPanel);
            horizontalPanel.add(rightVerticalPanel);
            setWidget(horizontalPanel);
            center();
        }
    }

    private void refreshAnswerTable(ClientServices clientServices, AnswerTable answerTable, Integer questId){
        clientServices.answerClient.getAnswers(questId, new MethodCallback<List<AnswerGWT>>() {
            @Override
            public void onFailure(Method method, Throwable exception) {
                new InfoDialog("List of answers is empty").show();
            }

            @Override
            public void onSuccess(Method method, List<AnswerGWT> response) {
                answerTable.refreshTable(response);
            }
        });
    }

    private void cleanUserTest(Integer testId){
        clientServices.userTestClient.getUsers(testId, new MethodCallback<List<UserGWT>>() {
            @Override
            public void onFailure(Method method, Throwable exception) {

            }

            @Override
            public void onSuccess(Method method, List<UserGWT> response) {
                for(UserGWT userGWT:response){
                    clientServices.userTestClient.getUserTest(userGWT.getId(), testId, new MethodCallback<UserTestGWT>() {
                        @Override
                        public void onFailure(Method method, Throwable exception) {

                        }

                        @Override
                        public void onSuccess(Method method, UserTestGWT response) {
                            clientServices.detailTestClient.update(new DetailTestGWT(response.getId(), 0, 0, 0.0, 0, null), new MethodCallback<DetailTestGWT>() {
                                @Override
                                public void onFailure(Method method, Throwable exception) {

                                }

                                @Override
                                public void onSuccess(Method method, DetailTestGWT response) {

                                }
                            });
                        }
                    });
                }
            }
        });
    }

    private void refreshUsersList(ListBox addList, ListBox removeList){
        addList.clear();
        removeList.clear();

        clientServices.userTestClient.getUsers(testGWT.getId(), new MethodCallback<List<UserGWT>>() {
            @Override
            public void onFailure(Method method, Throwable exception) {
                clientServices.userClient.getAll(new MethodCallback<List<UserGWT>>() {
                    @Override
                    public void onFailure(Method method, Throwable exception) {

                    }

                    @Override
                    public void onSuccess(Method method, List<UserGWT> newResponse) {
                        for(UserGWT userGWT:newResponse){
                            addList.addItem(userGWT.getId()+":"+userGWT.getLogin());
                        }
                    }
                });
            }

            @Override
            public void onSuccess(Method method, List<UserGWT> response) {
                for(UserGWT userGWT:response){
                    removeList.addItem(userGWT.getId()+":"+userGWT.getLogin());
                }
                clientServices.userClient.getAll(new MethodCallback<List<UserGWT>>() {
                    @Override
                    public void onFailure(Method method, Throwable exception) {

                    }

                    @Override
                    public void onSuccess(Method method, List<UserGWT> newResponse) {
                        for(UserGWT userGWT:newResponse){
                            if(!response.contains(userGWT)) addList.addItem(userGWT.getId()+":"+userGWT.getLogin());
                        }
                    }
                });
            }
        });
    }
}
