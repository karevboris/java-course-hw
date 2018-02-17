package ui.client.View.Dialogs;

import com.google.gwt.user.client.ui.*;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;
import ui.client.View.ClientServices;
import ui.client.View.Field;
import ui.client.View.Tables.UserTable;
import ui.shared.UserGWT;

import java.util.List;

public class UserAddDialog extends DialogBox {
    public UserAddDialog(ClientServices clientServices, UserTable userTable) {
        center();
        setPixelSize(270, 250);
        VerticalPanel verticalPanel = new VerticalPanel();
        verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        Field login = new Field("Enter login:");

        Field password = new Field("Enter password:");
        password.remove(1);
        PasswordTextBox firstPass = new PasswordTextBox();
        password.add(firstPass);

        Field repeatPass = new Field("Confirm the password:");
        repeatPass.remove(1);
        PasswordTextBox confPass = new PasswordTextBox();
        repeatPass.add(confPass);

        HorizontalPanel horizontalPanel = new HorizontalPanel();
        horizontalPanel.add(new Label("Set admin role:"));
        CheckBox checkBox = new CheckBox();
        checkBox.setEnabled(true);
        horizontalPanel.add(checkBox);
        verticalPanel.add(login);
        verticalPanel.add(password);
        verticalPanel.add(repeatPass);
        verticalPanel.add(horizontalPanel);

        HorizontalPanel buttonPanel = new HorizontalPanel();
        Button okButton = new Button("Ok");
        Button cancelButton = new Button("Cancel");
        cancelButton.addClickHandler(event -> hide());
        okButton.addClickHandler(event -> {
            if(login.getTextBox().getText().length()<6) new InfoDialog("Login is too short. Need more 5 characters");
            else if (firstPass.getText().length()<6) new InfoDialog("Password is too short. Need more 5 characters");
            else if (!firstPass.getText().equals(confPass.getText())) new InfoDialog("Passwords don't match");
            else {
                clientServices.userClient.add(new UserGWT(0, login.getTextBox().getText(), firstPass.getText(), checkBox.getValue()), new MethodCallback<UserGWT>() {
                    @Override
                    public void onFailure(Method method, Throwable exception) {
                        new ErrorDialog().show();
                    }

                    @Override
                    public void onSuccess(Method method, UserGWT response) {
                        new InfoDialog("User added");
                        hide();
                        clientServices.userClient.getAll(new MethodCallback<List<UserGWT>>() {
                            @Override
                            public void onFailure(Method method, Throwable exception) {
                                new InfoDialog("List of users is empty");
                            }

                            @Override
                            public void onSuccess(Method method, List<UserGWT> response) {
                                clientServices.userClient.getAll(new MethodCallback<List<UserGWT>>() {
                                    @Override
                                    public void onFailure(Method method, Throwable exception) {
                                        new InfoDialog("List of users is empty").show();
                                    }

                                    @Override
                                    public void onSuccess(Method method, List<UserGWT> responseList) {
                                        for(UserGWT user:responseList) {
                                            clientServices.userTestClient.getCountTests(user.getId(), new MethodCallback<Integer>() {
                                                @Override
                                                public void onFailure(Method method, Throwable exception) {
                                                    user.setCount(0);
                                                    clientServices.userTestClient.getCountPassedTests(user.getId(), new MethodCallback<Integer>() {
                                                        @Override
                                                        public void onFailure(Method method, Throwable exception) {
                                                            user.setPassed(0);
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

                                                        @Override
                                                        public void onSuccess(Method method, Integer response) {
                                                            user.setPassed(response);
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
                                                    });
                                                }

                                                @Override
                                                public void onSuccess(Method method, Integer response) {
                                                    user.setCount(response);
                                                    clientServices.userTestClient.getCountPassedTests(user.getId(), new MethodCallback<Integer>() {
                                                        @Override
                                                        public void onFailure(Method method, Throwable exception) {
                                                            user.setPassed(0);
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

                                                        @Override
                                                        public void onSuccess(Method method, Integer response) {
                                                            user.setPassed(response);
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
                                                    });
                                                }
                                            });
                                        }
                                    }
                                });
                            }
                        });
                    }
                });
            }
        });
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);
        verticalPanel.add(buttonPanel);
        setWidget(verticalPanel);
    }
}
