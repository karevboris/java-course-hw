package ui.client.Interfaces;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;
import ui.shared.DetailTestGWT;
import ui.shared.TestGWT;
import ui.shared.UserGWT;
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
    void add(UserTestGWT userTestGWT, MethodCallback<UserTestGWT> callback);

    @POST
    @Path("/update")
    void update(UserTestGWT userTestGWT, MethodCallback<UserTestGWT> callback);

    @DELETE
    @Path("/{id}")
    void deleteById(@PathParam("id") int id, MethodCallback<Integer> callback);

    @DELETE
    void delete(UserTestGWT userTestGWT, MethodCallback<Integer> callback);

    @GET
    @Path("/user/{id}")
    void getUsers (@PathParam("id") int id, MethodCallback<List<UserGWT>> callback);

    @GET
    @Path("/test/{id}")
    void getTests (@PathParam("id") int id, MethodCallback<List<TestGWT>> callback);

    @GET
    @Path("/detail")
    void getDetailTest(UserTestGWT userTestGWT, MethodCallback<DetailTestGWT> callback);

    @GET
    @Path("/countTests/{id}")
    void getCountTests(@PathParam("id") int id, MethodCallback<Integer> callback);

    @GET
    @Path("/countPassedTest/{id}")
    void getCountPassedTests(@PathParam("id") int id, MethodCallback<Integer> callback);

    @GET
    @Path("/percentPassedTest/{id}")
    void getPercentPassedTests(@PathParam("id") int id, MethodCallback<Double> callback);

    @GET
    @Path("/countUsers/{id}")
    void getCountUsers(@PathParam("id") int id, MethodCallback<Integer> callback);

    @GET
    @Path("/countPassedUser/{id}")
    void getCountPassedUsers(@PathParam("id") int id, MethodCallback<Integer> callback);

    @GET
    @Path("/percentPassedUser/{id}")
    void getPercentPassedUsers(@PathParam("id") int id, MethodCallback<Double> callback);

    @DELETE
    @Path("/detailDelete/{id}")
    void deleteDetailTestByTestId(@PathParam("id") int id, MethodCallback callback);

    @DELETE
    @Path("/detailDeleteByUser/{id}")
    void deleteDetailTestByUserId(@PathParam("id") int id, MethodCallback callback);

    @DELETE
    @Path("/testDelete/{id}")
    void deleteAllTestByTestId(@PathParam("id") int id, MethodCallback callback);

    @DELETE
    @Path("/userDelete/{id}")
    void deleteAllUserByUserId(@PathParam("id") int id, MethodCallback callback);

    @GET
    @Path("/read/{userId}/{testId}/")
    void getUserTest(@PathParam("userId") int userId, @PathParam("testId") int testId, MethodCallback<UserTestGWT> callback);
}
