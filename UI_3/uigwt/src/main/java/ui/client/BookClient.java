package ui.client;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;
import ui.shared.Book;

import javax.ws.rs.*;
import java.util.List;

@Path("/api/library")
public interface BookClient extends RestService {
    @GET
    void getLibrary(MethodCallback<List<Book>> callback);

    @POST
    void addBook(Book request, MethodCallback<List<Book>> callback);

    @DELETE
    @Path("/{id}")
    void deleteBook(@PathParam("id") int id, MethodCallback<List<Book>> callback);

    @DELETE
    void deleteAll(MethodCallback<List<Book>> callback);

    @GET
    @Path("/{string}")
    void sortBook(@PathParam("string") String string, MethodCallback<List<Book>> callback);
}
