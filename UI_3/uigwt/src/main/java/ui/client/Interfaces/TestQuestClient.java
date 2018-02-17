package ui.client.Interfaces;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;
import ui.shared.QuestionGWT;
import ui.shared.TestQuestGWT;

import javax.ws.rs.*;
import java.util.List;

@Path("/api/testQuest")
public interface TestQuestClient extends RestService {
    @GET
    void getAll(MethodCallback<List<TestQuestGWT>> callback);

    @GET
    @Path("/{idT}/{idQ}")
    void get(@PathParam("idT") int idT, @PathParam("idQ") int idQ, MethodCallback<TestQuestGWT> callback);

    @POST
    void add(TestQuestGWT testQuestGWT, MethodCallback<TestQuestGWT> callback);

    @POST
    @Path("/update")
    void update(TestQuestGWT testQuestGWT, MethodCallback<TestQuestGWT> callback);

    @DELETE
    @Path("/{idT}/{idQ}")
    void deleteById(@PathParam("idT") int idT, @PathParam("idQ") int idQ, MethodCallback<Integer> callback);

    @DELETE
    void delete(TestQuestGWT testQuestGWT, MethodCallback<Integer> callback);

    @GET
    @Path("/getQuestions/{id}")
    void getQuestions(@PathParam("id")int id, MethodCallback<List<QuestionGWT>> callback);

    @DELETE
    @Path("/deleteQuestions/{id}")
    void deleteQuestions(@PathParam("id")int id, MethodCallback callback);

    @GET
    @Path("getTestTime/{id}")
    void getTestTime(@PathParam("id") int id, MethodCallback<Integer> callback);
}
