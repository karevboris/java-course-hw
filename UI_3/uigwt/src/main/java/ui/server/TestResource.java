package ui.server;

import com.netcracker.Entities.Test;
import com.netcracker.Service.TestService.TestService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ui.shared.TestGWT;

import javax.ws.rs.*;
import java.util.LinkedList;
import java.util.List;

@Path("test")
public class TestResource {
    private ApplicationContext context = new ClassPathXmlApplicationContext("ui/context.xml");
    private TestService testService = (TestService)context.getBean("testBean");

    @GET
    @Produces("application/json")
    public List<TestGWT> getAll(){
        List<TestGWT> testGWTS = new LinkedList<>();
        for(Test test:testService.getAll()){
            testGWTS.add(new TestGWT(test.getId(),test.getName(), test.getUserId()));
        }
        return testGWTS;
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public TestGWT get(@PathParam("id") int id){
        Test test = testService.readById(id);
        return new TestGWT(test.getId(), test.getName(),test.getUserId());
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public TestGWT add(TestGWT testGWT){
        Test test = testService.add(new Test(testGWT.getName(), testGWT.getUserId()));
        return new TestGWT(test.getId(), test.getName(), test.getUserId());
    }

    @POST
    @Path("/update")
    @Consumes("application/json")
    @Produces("application/json")
    public TestGWT update(TestGWT testGWT){
        Test test = new Test(testGWT.getName(), testGWT.getUserId());
        test.setId(testGWT.getId());
        test = testService.update(test);
        return new TestGWT(test.getId(), test.getName(), test.getUserId());
    }

    @DELETE
    @Path("/{id}")
    public Integer deleteById(@PathParam("id") int id){
        Test test = testService.readById(id);
        if(test==null) return 1;
        testService.deleteById(id);
        if(testService.readById(id)!=null) return 2;
        return 0;
    }

    @DELETE
    @Consumes("application/json")
    public Integer delete(TestGWT testGWT){
        Test test = testService.readById(testGWT.getId());
        if(test==null) return 1;
        test = new Test(testGWT.getName(),testGWT.getUserId());
        test.setId(testGWT.getId());
        testService.delete(test);
        if(testService.readById(testGWT.getId())!=null) return 2;
        return 0;
    }

    @GET
    @Path("/getLastTest/{id}")
    @Produces("application/json")
    public TestGWT getLastTest(@PathParam("id") int id){
        Test test = testService.getLastTest(id);
        return new TestGWT(test.getId(), test.getName(), test.getUserId());
    }
}
