package ui.client.Interfaces;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;
import ui.shared.UserGWT;

import javax.ws.rs.*;
import java.util.List;

@Path("/api/user")
public interface UserClient extends RestService {
    @GET
    void getAll(MethodCallback<List<UserGWT>> callback);

    @GET
    @Path("/{id}")
    void get(@PathParam("id") int id, MethodCallback<UserGWT> callback);

    @POST
    void add(UserGWT userGWT, MethodCallback<UserGWT> callback);

    @POST
    @Path("/update")
    void update(UserGWT userGWT, MethodCallback<UserGWT> callback);

    @DELETE
    @Path("/{id}")
    void deleteById(@PathParam("id") int id, MethodCallback<Integer> callback);

    @DELETE
    void delete(UserGWT userGWT, MethodCallback<Integer> callback);

    @GET
    @Path("/getUsername")
    void getUserByUsername(MethodCallback<UserGWT> callback);
}
