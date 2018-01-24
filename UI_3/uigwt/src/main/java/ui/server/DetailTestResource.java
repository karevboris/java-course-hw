package ui.server;

import com.netcracker.Entities.DetailTest;
import com.netcracker.Service.DetailTestService.DetailTestService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ui.shared.DetailTestGWT;

import javax.ws.rs.*;
import java.util.LinkedList;
import java.util.List;

@Path("detailTest")
public class DetailTestResource {
    private ApplicationContext context = new ClassPathXmlApplicationContext("ui/context.xml");
    private DetailTestService detailTestService = (DetailTestService)context.getBean("detailTestBean");

    @GET
    @Produces("application/json")
    public List<DetailTestGWT> getAll(){
        List<DetailTestGWT> detailTestGWTS = new LinkedList<>();
        for(DetailTest detailTest:detailTestService.getAll()){
            detailTestGWTS.add(new DetailTestGWT(detailTest.getId(),detailTest.getCountPassed(), detailTest.getCountFailed(), detailTest.getResult()));
        }
        return detailTestGWTS;
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public DetailTestGWT get(@PathParam("id") int id){
        DetailTest detailTest = detailTestService.readById(id);
        return new DetailTestGWT(detailTest.getId(), detailTest.getCountPassed(), detailTest.getCountFailed(), detailTest.getResult());
    }

    @POST
    @Consumes("application/json")
    public void add(DetailTestGWT detailTestGWT){
        detailTestService.add(new DetailTest(detailTestGWT.getCountPassed(), detailTestGWT.getCountFailed(), detailTestGWT.getResult()));
    }

    @POST
    @Path("/update")
    @Consumes("application/json")
    public Boolean update(DetailTestGWT detailTestGWT){
        if(detailTestService.readById(detailTestGWT.getId())==null) return false;
        DetailTest detailTest = new DetailTest(detailTestGWT.getCountPassed(), detailTestGWT.getCountFailed(), detailTestGWT.getResult());
        detailTest.setId(detailTestGWT.getId());
        detailTestService.update(detailTest);
        return true;
    }

    @DELETE
    @Path("/{id}")
    public Integer deleteById(@PathParam("id") int id){
        DetailTest detailTest = detailTestService.readById(id);
        if(detailTest==null) return 1;
        detailTestService.deleteById(id);
        if(detailTestService.readById(id)!=null) return 2;
        return 0;
    }

    @DELETE
    @Consumes("application/json")
    public Integer delete(DetailTestGWT detailTestGWT){
        DetailTest detailTest = detailTestService.readById(detailTestGWT.getId());
        if(detailTest==null) return 1;
        detailTest = new DetailTest(detailTestGWT.getCountPassed(), detailTestGWT.getCountFailed(), detailTestGWT.getResult());
        detailTest.setId(detailTestGWT.getId());
        detailTestService.delete(detailTest);
        if(detailTestService.readById(detailTestGWT.getId())!=null) return 2;
        return 0;
    }
}
