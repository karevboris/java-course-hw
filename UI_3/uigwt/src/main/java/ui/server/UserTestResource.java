package ui.server;

import com.netcracker.Entities.UserTest;
import com.netcracker.Service.UserTestService.UserTestService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ui.shared.UserTestGWT;

import javax.ws.rs.*;
import java.util.LinkedList;
import java.util.List;

@Path("userTest")
public class UserTestResource {
    private ApplicationContext context = new ClassPathXmlApplicationContext("ui/context.xml");
    private UserTestService userTestService = (UserTestService)context.getBean("userTestBean");

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
    public void add(UserTestGWT userTestGWT){
        userTestService.add(new UserTest(userTestGWT.getUserId(), userTestGWT.getTestId()));
    }

    @POST
    @Path("/update")
    @Consumes("application/json")
    public Boolean update(UserTestGWT userTestGWT){
        if(userTestService.readById(userTestGWT.getId())==null) return false;
        UserTest userTest = new UserTest(userTestGWT.getUserId(), userTestGWT.getTestId());
        userTest.setId(userTestGWT.getId());
        userTestService.update(userTest);
        return true;
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
}
