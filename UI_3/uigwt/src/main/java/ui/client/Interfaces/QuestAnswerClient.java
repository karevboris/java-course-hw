package ui.client.Interfaces;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;
import ui.shared.QuestAnswerGWT;

import javax.ws.rs.*;
import java.util.List;

@Path("/api/questAnswer")
public interface QuestAnswerClient extends RestService {
    @GET
    void getAll(MethodCallback<List<QuestAnswerGWT>> callback);

    @GET
    @Path("/{idQ}/{idA}")
    void get(@PathParam("idQ") int idQ, @PathParam("idA") int idA, MethodCallback<QuestAnswerGWT> callback);

    @POST
    void add(QuestAnswerGWT questAnswerGWT, MethodCallback callback);

    @POST
    @Path("/update")
    void update(QuestAnswerGWT questAnswerGWT, MethodCallback<Boolean> callback);

    @DELETE
    @Path("/{idQ}/{idA}")
    void deleteById(@PathParam("idQ") int idQ, @PathParam("idA") int idA, MethodCallback<Integer> callback);

    @DELETE
    void delete(QuestAnswerGWT questAnswerGWT, MethodCallback<Integer> callback);
}
