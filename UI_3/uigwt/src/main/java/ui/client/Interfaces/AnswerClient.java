package ui.client.Interfaces;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;
import ui.shared.AnswerGWT;

import javax.ws.rs.*;
import java.util.List;

@Path("/api/answer")
public interface AnswerClient extends RestService {
    @GET
    void getAll(MethodCallback<List<AnswerGWT>> callback);

    @GET
    @Path("/{id}")
    void get(@PathParam("id") int id, MethodCallback<AnswerGWT> callback);

    @POST
    void add(AnswerGWT answerGWT, MethodCallback callback);

    @POST
    @Path("/update")
    void update(AnswerGWT answerGWT, MethodCallback<Boolean> callback);

    @DELETE
    @Path("/{id}")
    void deleteById(@PathParam("id") int id, MethodCallback<Integer> callback);

    @DELETE
    void delete(AnswerGWT answerGWT, MethodCallback<Integer> callback);
}
