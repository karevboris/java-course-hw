package ui.client.Interfaces;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;
import ui.shared.DetailTestGWT;

import javax.ws.rs.*;
import java.util.List;

@Path("/api/detailTest")
public interface DetailTestClient extends RestService {
    @GET
    void getAll(MethodCallback<List<DetailTestGWT>> callback);

    @GET
    @Path("/{id}")
    void get(@PathParam("id") int id, MethodCallback<DetailTestGWT> callback);

    @POST
    void add(DetailTestGWT detailTestGWT, MethodCallback<DetailTestGWT> callback);

    @POST
    @Path("/update")
    void update(DetailTestGWT detailTestGWT, MethodCallback<DetailTestGWT> callback);

    @DELETE
    @Path("/{id}")
    void deleteById(@PathParam("id") int id, MethodCallback<Integer> callback);

    @DELETE
    void delete(DetailTestGWT detailTestGWT, MethodCallback<Integer> callback);
}
