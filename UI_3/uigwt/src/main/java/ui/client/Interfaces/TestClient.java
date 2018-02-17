package ui.client.Interfaces;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;
import ui.shared.TestGWT;

import javax.ws.rs.*;
import java.util.List;

@Path("/api/test")
public interface TestClient extends RestService {
    @GET
    void getAll(MethodCallback<List<TestGWT>> callback);

    @GET
    @Path("/{id}")
    void get(@PathParam("id") int id, MethodCallback<TestGWT> callback);

    @POST
    void add(TestGWT testGWT, MethodCallback<TestGWT> callback);

    @POST
    @Path("/update")
    void update(TestGWT testGWT, MethodCallback<TestGWT> callback);

    @DELETE
    @Path("/{id}")
    void deleteById(@PathParam("id") int id, MethodCallback<Integer> callback);

    @DELETE
    void delete(TestGWT testGWT, MethodCallback<Integer> callback);

    @GET
    @Path("/getLastTest/{id}")
    void getLastTest(@PathParam("id") int id, MethodCallback<TestGWT> callback);
}
