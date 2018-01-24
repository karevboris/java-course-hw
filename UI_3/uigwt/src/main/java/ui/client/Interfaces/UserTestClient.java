package ui.client.Interfaces;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;
import ui.shared.UserTestGWT;

import javax.ws.rs.*;
import java.util.List;

@Path("/api/userTest")
public interface UserTestClient extends RestService {
    @GET
    void getAll(MethodCallback<List<UserTestGWT>> callback);

    @GET
    @Path("/{id}")
    void get(@PathParam("id") int id, MethodCallback<UserTestGWT> callback);

    @POST
    void add(UserTestGWT userTestGWT, MethodCallback callback);

    @POST
    @Path("/update")
    void update(UserTestGWT userTestGWT, MethodCallback<Boolean> callback);

    @DELETE
    @Path("/{id}")
    void deleteById(@PathParam("id") int id, MethodCallback<Integer> callback);

    @DELETE
    void delete(UserTestGWT userTestGWT, MethodCallback<Integer> callback);
}
