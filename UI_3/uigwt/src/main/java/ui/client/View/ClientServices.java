package ui.client.View;

import com.google.gwt.core.client.GWT;
import ui.client.Interfaces.*;

public class ClientServices {
    public AnswerClient answerClient = GWT.create(AnswerClient.class);
    public UserTestClient userTestClient = GWT.create(UserTestClient.class);
    public UserClient userClient = GWT.create(UserClient.class);
    public QuestionClient questionClient = GWT.create(QuestionClient.class);
    public TestClient testClient = GWT.create(TestClient.class);
    public DetailTestClient detailTestClient = GWT.create(DetailTestClient.class);
    public TestQuestClient testQuestClient = GWT.create(TestQuestClient.class);
}
