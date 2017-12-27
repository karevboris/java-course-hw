package ui.client;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;
import ui.shared.Hello;

@Path("/api/hellos")
public interface HelloClient extends RestService {

    @GET
    void getHellos( MethodCallback<List<Hello>> callback);

    @GET
    @Path("/{id}")
    void getHellos(@PathParam("id") String id, MethodCallback<List<Hello>> callback);
}
