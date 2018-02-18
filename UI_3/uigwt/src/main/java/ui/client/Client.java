package ui.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import org.fusesource.restygwt.client.Defaults;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;
import ui.client.View.ClientServices;
import ui.client.View.Dialogs.*;
import ui.client.View.Tables.AttemptsTable;
import ui.client.View.Tables.TestTable;
import ui.client.View.Tables.UserTable;
import ui.shared.DetailTestGWT;
import ui.shared.TestGWT;
import ui.shared.UserGWT;
import ui.shared.UserTestGWT;

import java.util.LinkedList;
import java.util.List;

public class Client implements EntryPoint {
    public void onModuleLoad() {
        Defaults.setServiceRoot(GWT.getHostPageBaseURL());
        ClientServices clientServices = new ClientServices();

        clientServices.userClient.getUserByUsername(new MethodCallback<UserGWT>() {
            @Override
            public void onFailure(Method method, Throwable exception) {
                new ErrorDialog().show();
            }

            @Override
            public void onSuccess(Method method, UserGWT response) {
                if(response.getAdmin()) useRoleAdmin(clientServices, response);
                else useRoleUser(clientServices, response);
            }
        });
    }

    private void useRoleAdmin(ClientServices clientServices, UserGWT response) {
        HorizontalPanel horizontalPanel = new HorizontalPanel();
        horizontalPanel.setVisible(true);
        horizontalPanel.setPixelSize(RootPanel.get().getOffsetWidth(), RootPanel.get().getOffsetHeight());
        horizontalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

        final TabPanel tabAdminPanel = new TabPanel();

        String firstPageTitle = "Tests";
        String secondPageTitle = "Users";
        String thirdPageTitle = "Statistic";
        String fourthPageTitle = "Log in as user";
        String fifthPageTitle = "Log out";
        tabAdminPanel.setWidth("400");

        TestTable testTable = new TestTable(clientServices.userTestClient);
        UserTable userTable = new UserTable(clientServices.userTestClient);

        refreshUserTable(clientServices, userTable);

        refreshTestTable(clientServices, testTable);

        HorizontalPanel forUserButton = new HorizontalPanel();
        forUserButton.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        forUserButton.setHeight("20");
        forUserButton.setSpacing(10);

        Button newUserButton = new Button("Add new user");
        Button deleteUserButton = new Button("Delete user");
        Button refreshUserButton = new Button("Refresh table");

        newUserButton.addClickHandler(event -> {
            new UserAddDialog(clientServices, userTable);
        });

        deleteUserButton.addClickHandler(event -> {
            UserGWT userGWT = userTable.getSelectionModel().getSelectedObject();
            if (userGWT != null) {
                clientServices.testClient.getAll(new MethodCallback<List<TestGWT>>() {
                    @Override
                    public void onFailure(Method method, Throwable exception) {

                    }

                    @Override
                    public void onSuccess(Method method, List<TestGWT> response) {
                        for (TestGWT testGWT : response) {
                            if (userGWT.getId().equals(testGWT.getUserId())) {
                                clientServices.testClient.update(new TestGWT(testGWT.getId(), testGWT.getName(), null), new MethodCallback<TestGWT>() {
                                    @Override
                                    public void onFailure(Method method, Throwable exception) {

                                    }

                                    @Override
                                    public void onSuccess(Method method, TestGWT response) {

                                    }
                                });
                            }
                        }
                        clientServices.userClient.deleteById(userGWT.getId(), new MethodCallback<Integer>() {
                            @Override
                            public void onFailure(Method method, Throwable exception) {
                                new ErrorDialog().show();
                            }

                            @Override
                            public void onSuccess(Method method, Integer response) {
                                new InfoDialog("User deleted");
                                clientServices.userClient.getAll(new MethodCallback<List<UserGWT>>() {
                                    @Override
                                    public void onFailure(Method method, Throwable exception) {
                                        new InfoDialog("List of users is empty");
                                    }

                                    @Override
                                    public void onSuccess(Method method, List<UserGWT> response) {
                                        refreshUserTable(clientServices, userTable);
                                    }
                                });
                            }
                        });
                    }
                });
            }
        });

        refreshUserButton.addClickHandler(event -> {
            refreshUserTable(clientServices, userTable);
        });

        forUserButton.add(newUserButton);
        forUserButton.add(deleteUserButton);
        forUserButton.add(refreshUserButton);

        userTable.insert(forUserButton, 0);

        HorizontalPanel forTestButton = new HorizontalPanel();
        forTestButton.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        forTestButton.setHeight("20");
        forTestButton.setSpacing(10);

        Button newTestButton = new Button("Add new test");
        Button deleteTestButton = new Button("Delete test");
        Button editTestButton = new Button("Edit test");
        Button refreshButton = new Button("Refresh table");

        forTestButton.add(newTestButton);
        forTestButton.add(editTestButton);
        forTestButton.add(deleteTestButton);
        forTestButton.add(refreshButton);

        refreshButton.addClickHandler(event -> {
            refreshTestTable(clientServices, testTable);
        });

        newTestButton.addClickHandler(event -> {
            new TestEditDialog(clientServices, new TestGWT(-1, "newTest", response.getId()), testTable, 500, 500).show();
        });

        editTestButton.addClickHandler(event -> {
            clientServices.testClient.getAll(new MethodCallback<List<TestGWT>>() {
                @Override
                public void onFailure(Method method, Throwable exception) {
                    new InfoDialog("List of tests is empty");
                }

                @Override
                public void onSuccess(Method method, List<TestGWT> response) {
                    TestGWT test = testTable.getSelectionModel().getSelectedObject();
                    if (test != null) new TestEditDialog(clientServices, test, testTable, 700, 500).show();
                }
            });

        });

        deleteTestButton.addClickHandler(event -> {
            TestGWT test = testTable.getSelectionModel().getSelectedObject();
            if (test != null) {
                clientServices.testClient.deleteById(test.getId(), new MethodCallback<Integer>() {
                    @Override
                    public void onFailure(Method method, Throwable exception) {
                        new ErrorDialog().show();
                    }

                    @Override
                    public void onSuccess(Method method, Integer response) {
                        new InfoDialog("Test deleted").show();
                        refreshTestTable(clientServices, testTable);
                    }
                });
            }
        });

        testTable.insert(forTestButton, 0);

        tabAdminPanel.add(testTable, firstPageTitle);
        tabAdminPanel.add(userTable, secondPageTitle);
        tabAdminPanel.add(new VerticalPanel(), thirdPageTitle);
        tabAdminPanel.add(new VerticalPanel(), fourthPageTitle);
        tabAdminPanel.add(new VerticalPanel(), fifthPageTitle);

        tabAdminPanel.addSelectionHandler(event -> {
            if (event.getSelectedItem().equals(0)) History.newItem(firstPageTitle);
            else if (event.getSelectedItem().equals(1)) History.newItem(secondPageTitle);
            else if (event.getSelectedItem().equals(2)) History.newItem(thirdPageTitle);
            else if (event.getSelectedItem().equals(3)) History.newItem(fourthPageTitle);
            else History.newItem(fifthPageTitle);
        });

        History.addValueChangeHandler(event -> {
            String historyToken = event.getValue();
            if (historyToken.equals(secondPageTitle)) {
                tabAdminPanel.selectTab(1);
            } else if (historyToken.equals(firstPageTitle)) {
                tabAdminPanel.selectTab(0);
            } else if (historyToken.equals(thirdPageTitle)) {
                Window.Location.replace("/uigwt-1.0-SNAPSHOT/index.html");
            } else if (historyToken.equals(fourthPageTitle)){
                RootPanel.get().clear();
                useRoleUser(clientServices, response);
            } else if (historyToken.equals(fifthPageTitle)){
                Window.Location.replace("/uigwt-1.0-SNAPSHOT/logout");
            }
        });

        tabAdminPanel.selectTab(0);
        horizontalPanel.add(tabAdminPanel);
        RootPanel.get().add(horizontalPanel);
    }

    private void useRoleUser(ClientServices clientServices, UserGWT response) {
        HorizontalPanel horizontalPanel = new HorizontalPanel();
        horizontalPanel.setVisible(true);
        horizontalPanel.setPixelSize(RootPanel.get().getOffsetWidth(), RootPanel.get().getOffsetHeight());
        horizontalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

        final TabPanel tabUserPanel = new TabPanel();

        AttemptsTable attemptsTable = new AttemptsTable(clientServices);
        refreshAttemptsTable(clientServices, attemptsTable, response);

        String firstPageTitle = "Testing";
        String secondPageTitle = "Log out";
        tabUserPanel.setWidth("400");

        HorizontalPanel forTestButton = new HorizontalPanel();
        forTestButton.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        forTestButton.setHeight("20");
        forTestButton.setSpacing(10);

        Button editProfileButton = new Button("Edit profile");
        Button newAttemptButton = new Button("Start new attempt");
        Button refreshTableButton = new Button("Refresh table");
        Button redirectButton = new Button("Log in as admin");

        redirectButton.addClickHandler(event -> {
            RootPanel.get().clear();
            useRoleAdmin(clientServices, response);
        });

        refreshTableButton.addClickHandler(event -> {
            refreshAttemptsTable(clientServices, attemptsTable, response);
        });
        newAttemptButton.addClickHandler(event -> {
            DetailTestGWT detailTestGWT = attemptsTable.getSelectionModel().getSelectedObject();
            if (detailTestGWT != null)
                clientServices.userTestClient.get(detailTestGWT.getId(), new MethodCallback<UserTestGWT>() {
                    @Override
                    public void onFailure(Method method, Throwable exception) {
                        new ErrorDialog().show();
                    }

                    @Override
                    public void onSuccess(Method method, UserTestGWT oldResponse) {
                        clientServices.testQuestClient.getTestTime(oldResponse.getTestId(), new MethodCallback<Integer>() {
                            @Override
                            public void onFailure(Method method, Throwable exception) {
                                new ErrorDialog().show();
                            }

                            @Override
                            public void onSuccess(Method method, Integer time) {
                                new TestingDialog(response, oldResponse.getTestId(), attemptsTable, detailTestGWT, time, clientServices, 700, 500).show();
                            }
                        });
                    }
                });
        });
        forTestButton.add(newAttemptButton);
        forTestButton.add(refreshTableButton);
        forTestButton.add(editProfileButton);
        if(response.getAdmin()) forTestButton.add(redirectButton);

        tabUserPanel.add(attemptsTable, firstPageTitle);
        tabUserPanel.add(new VerticalPanel(), secondPageTitle);

        tabUserPanel.addSelectionHandler(event -> {
            if (event.getSelectedItem().equals(0)) History.newItem(firstPageTitle);
            else History.newItem(secondPageTitle);
        });

        History.addValueChangeHandler(event -> {
            String historyToken = event.getValue();
            if (historyToken.equals(firstPageTitle)) {
                tabUserPanel.selectTab(0);
            } else if (historyToken.equals(secondPageTitle)){
                Window.Location.replace("/uigwt-1.0-SNAPSHOT/logout");
            }
        });

        attemptsTable.insert(forTestButton, 0);
        tabUserPanel.selectTab(0);
        horizontalPanel.add(tabUserPanel);
        RootPanel.get().add(horizontalPanel);
    }

    private void refreshAttemptsTable(ClientServices clientServices, AttemptsTable attemptsTable, UserGWT userGWT) {
        clientServices.userTestClient.getTests(userGWT.getId(), new MethodCallback<List<TestGWT>>() {
            @Override
            public void onFailure(Method method, Throwable exception) {
                new InfoDialog("List of tests is empty");
            }

            @Override
            public void onSuccess(Method method, List<TestGWT> responseList) {
                List<DetailTestGWT> list = new LinkedList<>();
                for (TestGWT test : responseList) {
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
                                    if(list.size()==responseList.size())attemptsTable.refreshTable(list);
                                }
                            });
                        }
                    });
                }
            }
        });
    }

    private void refreshUserTable(ClientServices clientServices, UserTable userTable) {
        clientServices.userClient.getAll(new MethodCallback<List<UserGWT>>() {
            @Override
            public void onFailure(Method method, Throwable exception) {
                new InfoDialog("List of users is empty").show();
            }

            @Override
            public void onSuccess(Method method, List<UserGWT> responseList) {
                for (UserGWT user : responseList) {
                    clientServices.userTestClient.getCountTests(user.getId(), new MethodCallback<Integer>() {
                        @Override
                        public void onFailure(Method method, Throwable exception) {
                            user.setCount(0);
                            clientServices.userTestClient.getCountPassedTests(user.getId(), new MethodCallback<Integer>() {
                                @Override
                                public void onFailure(Method method, Throwable exception) {

                                    setUserDetails(clientServices, userTable, user, 0, responseList);
                                }

                                @Override
                                public void onSuccess(Method method, Integer response) {

                                    setUserDetails(clientServices, userTable, user, response, responseList);
                                }
                            });
                        }

                        @Override
                        public void onSuccess(Method method, Integer response) {
                            user.setCount(response);
                            clientServices.userTestClient.getCountPassedTests(user.getId(), new MethodCallback<Integer>() {
                                @Override
                                public void onFailure(Method method, Throwable exception) {
                                    setUserDetails(clientServices, userTable, user, 0, responseList);
                                }

                                @Override
                                public void onSuccess(Method method, Integer response) {
                                    setUserDetails(clientServices, userTable, user, response, responseList);
                                }
                            });
                        }
                    });
                }
            }
        });
    }

    private void refreshTestTable(ClientServices clientServices, TestTable testTable) {
        clientServices.testClient.getAll(new MethodCallback<List<TestGWT>>() {
            @Override
            public void onFailure(Method method, Throwable exception) {
                new InfoDialog("List of tests is empty").show();
            }

            @Override
            public void onSuccess(Method method, List<TestGWT> responseList) {
                for (TestGWT test : responseList) {
                    clientServices.userTestClient.getCountUsers(test.getId(), new MethodCallback<Integer>() {
                        @Override
                        public void onFailure(Method method, Throwable exception) {
                            test.setCount(0);
                            clientServices.userTestClient.getCountPassedUsers(test.getId(), new MethodCallback<Integer>() {
                                @Override
                                public void onFailure(Method method, Throwable exception) {
                                    setTestDetails(clientServices, testTable, test, 0, responseList);
                                }

                                @Override
                                public void onSuccess(Method method, Integer response) {
                                    setTestDetails(clientServices, testTable, test, response, responseList);
                                }
                            });
                        }

                        @Override
                        public void onSuccess(Method method, Integer response) {
                            test.setCount(response);
                            clientServices.userTestClient.getCountPassedUsers(test.getId(), new MethodCallback<Integer>() {
                                @Override
                                public void onFailure(Method method, Throwable exception) {
                                    setTestDetails(clientServices, testTable, test, 0, responseList);
                                }

                                @Override
                                public void onSuccess(Method method, Integer response) {
                                    setTestDetails(clientServices, testTable, test, response, responseList);
                                }
                            });
                        }
                    });
                }
            }
        });
    }

    private void setTestDetails(ClientServices clientServices, TestTable testTable, TestGWT test, Integer value, List<TestGWT> responseList) {
        test.setPassed(value);
        clientServices.userTestClient.getPercentPassedUsers(test.getId(), new MethodCallback<Double>() {
            @Override
            public void onFailure(Method method, Throwable exception) {
                test.setPercent(0.0);
                testTable.refreshTable(responseList);
            }

            @Override
            public void onSuccess(Method method, Double response) {
                test.setPercent(response);
                testTable.refreshTable(responseList);
            }
        });
    }

    private void setUserDetails(ClientServices clientServices, UserTable userTable, UserGWT user, Integer value, List<UserGWT> responseList) {
        user.setPassed(value);
        clientServices.userTestClient.getPercentPassedTests(user.getId(), new MethodCallback<Double>() {
            @Override
            public void onFailure(Method method, Throwable exception) {
                user.setPercent(0.0);
                userTable.refreshTable(responseList);
            }

            @Override
            public void onSuccess(Method method, Double response) {
                user.setPercent(response);
                userTable.refreshTable(responseList);
            }
        });
    }
}
