package ui.server;

import com.netcracker.Entities.DetailTest;
import com.netcracker.Entities.Test;
import com.netcracker.Entities.User;
import com.netcracker.Entities.UserTest;
import com.netcracker.Service.TestService.TestService;
import com.netcracker.Service.UserService.UserService;
import com.netcracker.Service.UserTestService.UserTestService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ui.shared.*;

import javax.ws.rs.*;
import java.util.LinkedList;
import java.util.List;

@Path("userTest")
public class UserTestResource {
    private ApplicationContext context = new ClassPathXmlApplicationContext("ui/context.xml");
    private UserTestService userTestService = (UserTestService)context.getBean("userTestBean");
    private UserService userService = (UserService)context.getBean("userBean");
    private TestService testService = (TestService)context.getBean("testBean");

    @GET
    @Produces("application/json")
    public List<UserTestGWT> getAll(){
        List<UserTestGWT> userTestGWTS = new LinkedList<>();
        for(UserTest userTest:userTestService.getAll()){
            userTestGWTS.add(new UserTestGWT(userTest.getId(), userTest.getUserId(), userTest.getTestId()));
        }
        return userTestGWTS;
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public UserTestGWT get(@PathParam("id") int id){
        UserTest userTest = userTestService.readById(id);
        return new UserTestGWT(userTest.getId(), userTest.getUserId(), userTest.getTestId());
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public UserTestGWT add(UserTestGWT userTestGWT){
        UserTest userTest = userTestService.add(new UserTest(userTestGWT.getUserId(), userTestGWT.getTestId()));
        return new UserTestGWT(userTest.getId(),userTest.getUserId(),userTest.getTestId());
    }

    @POST
    @Path("/update")
    @Consumes("application/json")
    @Produces("application/json")
    public UserTestGWT update(UserTestGWT userTestGWT){
        UserTest userTest = new UserTest(userTestGWT.getUserId(), userTestGWT.getTestId());
        userTest.setId(userTestGWT.getId());
        userTest = userTestService.update(userTest);
        return new UserTestGWT(userTest.getId(),userTest.getUserId(),userTest.getTestId());
    }

    @DELETE
    @Path("/{id}")
    public Integer deleteById(@PathParam("id") int id){
        UserTest userTest = userTestService.readById(id);
        if(userTest==null) return 1;
        userTestService.deleteById(id);
        if(userTestService.readById(id)!=null) return 2;
        return 0;
    }

    @DELETE
    @Consumes("application/json")
    public Integer delete(UserTestGWT userTestGWT){
        UserTest userTest = userTestService.readById(userTestGWT.getId());
        if(userTest==null) return 1;
        userTest = new UserTest(userTestGWT.getUserId(), userTestGWT.getTestId());
        userTest.setId(userTestGWT.getId());
        userTestService.delete(userTest);
        if(userTestService.readById(userTestGWT.getId())!=null) return 2;
        return 0;
    }

    @GET
    @Path("/user/{id}")
    @Produces("application/json")
    public List<UserGWT> getUsers (@PathParam("id") int id){
        List<UserGWT> userGWTS = new LinkedList<>();
        for(User user:userTestService.getUsers(id)){
            userGWTS.add(new UserGWT(user.getId(), user.getLogin(), user.getPassword(), user.getAdmin()));
        }
        return userGWTS;
    }

    @GET
    @Path("/test/{id}")
    @Produces("application/json")
    public List<TestGWT> getTests (@PathParam("id") int id){
        List<TestGWT> testGWTS = new LinkedList<>();
        for(Test test:userTestService.getTests(id)){
            testGWTS.add(new TestGWT(test.getId(), test.getName(), test.getUserId()));
        }
        return testGWTS;
    }

    @GET
    @Path("/detail")
    @Consumes("application/json")
    @Produces("application/json")
    public DetailTestGWT getDetailTest(UserTestGWT userTestGWT){
        DetailTest detailTest = userTestService.getDetailTest(new UserTest(userTestGWT.getUserId(), userTestGWT.getTestId()));
        return new DetailTestGWT(detailTest.getId(), detailTest.getCountPassed(), detailTest.getCountFailed(), detailTest.getResult(), detailTest.getAttempts(), detailTest.getDate().toString());
    }

    @GET
    @Path("/countTests/{id}")
    public Integer getCountTests(@PathParam("id") int id){
        return userTestService.getCountTests(id);
    }

    @GET
    @Path("/countPassedTest/{id}")
    public Integer getCountPassedTests(@PathParam("id") int id){
        return userTestService.getCountPassedTests(id);
    }

    @GET
    @Path("/percentPassedTest/{id}")
    public Double getPercentPassedTests(@PathParam("id") int id){
        return userTestService.getPercentPassedTests(id);
    }

    @GET
    @Path("/countUsers/{id}")
    public Integer getCountUsers(@PathParam("id") int id){
        return userTestService.getCountUsers(id);
    }

    @GET
    @Path("/countPassedUser/{id}")
    public Integer getCountPassedUsers(@PathParam("id") int id){
        return userTestService.getCountPassedUsers(id);
    }

    @GET
    @Path("/percentPassedUser/{id}")
    public Double getPercentPassedUsers(@PathParam("id") int id){
        return userTestService.getPercentPassedUsers(id);
    }

    @DELETE
    @Path("/detailDelete/{id}")
    public void deleteDetailTestByTestId(@PathParam("id")int id){
        for (User user:userTestService.getUsers(id)) {
            userTestService.deleteDetailTest(new UserTest(user.getId(), id));
        }
    }

    @DELETE
    @Path("/detailDeleteByUser/{id}")
    public void deleteDetailTestByUserId(@PathParam("id") int id){
        for (Test test:userTestService.getTests(id)) {
            userTestService.deleteDetailTest(new UserTest(id, test.getId()));
        }
    }

    @DELETE
    @Path("/testDelete/{id}")
    public void deleteAllTestByTestId(@PathParam("id") int id){
        userTestService.deleteUsers(id);
    }

    @DELETE
    @Path("/userDelete/{id}")
    public void deleteAllUserByUserId(@PathParam("id") int id){
        userTestService.deleteTests(id);
    }

    @GET
    @Path("/read/{userId}/{testId}/")
    @Produces("application/json")
    public UserTestGWT getUserTest(@PathParam("userId") int userId, @PathParam("testId") int testId){
        UserTest userTest = userTestService.read(userId, testId);
        return new UserTestGWT(userTest.getId(), userTest.getUserId(), userTest.getTestId());
    }

    @GET
    @Path("/readFromAngularForUser/{username}")
    @Produces("application/json")
    public List<UserDetail> getUserDetail(@PathParam("username") String username){
        List<UserDetail> resultList = new LinkedList<>();
        User user = userService.readByUsername(username);
        List<TestGWT> testGWTList = getTests(user.getId());
        for(TestGWT test:testGWTList){
            DetailTestGWT detailTestGWT = getDetailTest(new UserTestGWT(0, user.getId(), test.getId()));
            UserDetail userDetail = new UserDetail(user.getId(), test.getId(), test.getName(), detailTestGWT.getCountPassed(), detailTestGWT.getCountFailed(), detailTestGWT.getResult(), detailTestGWT.getAttempts(), detailTestGWT.getDate());
            resultList.add(userDetail);
        }
        return resultList;
    }

    @GET
    @Path("/readFromAngularForTest/{testName}")
    @Produces("application/json")
    public List<UserDetail> getTestDetail(@PathParam("testName") String testName){
        List<UserDetail> resultList = new LinkedList<>();
        Integer testId=-1;
        for (Test test: testService.getAll()){
            if(test.getName().trim().equals(testName)){
                testId = test.getId();
                break;
            }
        }
        if(testId.equals(-1)) return resultList;
        List<UserGWT> userGWTList = getUsers(testId);
        for(UserGWT user:userGWTList){
            DetailTestGWT detailTestGWT = getDetailTest(new UserTestGWT(0, user.getId(), testId));
            UserDetail userDetail = new UserDetail(user.getId(), testId, user.getLogin(), detailTestGWT.getCountPassed(), detailTestGWT.getCountFailed(), detailTestGWT.getResult(), detailTestGWT.getAttempts(), detailTestGWT.getDate());
            resultList.add(userDetail);
        }
        return resultList;
    }
}
