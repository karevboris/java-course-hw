package ui.client.Interfaces;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;
import ui.shared.QuestionGWT;

import javax.ws.rs.*;
import java.util.List;

@Path("/api/question")
public interface QuestionClient extends RestService {
    @GET
    void getAll(MethodCallback<List<QuestionGWT>> callback);

    @GET
    @Path("/{id}")
    void get(@PathParam("id") int id, MethodCallback<QuestionGWT> callback);

    @POST
    void add(QuestionGWT questionGWT, MethodCallback callback);

    @POST
    @Path("/update")
    void update(QuestionGWT questionGWT, MethodCallback<Boolean> callback);

    @DELETE
    @Path("/{id}")
    void deleteById(@PathParam("id") int id, MethodCallback<Integer> callback);

    @DELETE
    void delete(QuestionGWT questionGWT, MethodCallback<Integer> callback);
}
