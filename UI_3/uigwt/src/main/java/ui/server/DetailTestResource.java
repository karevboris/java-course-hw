package ui.server;

import com.netcracker.Entities.DetailTest;
import com.netcracker.Service.DetailTestService.DetailTestService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ui.shared.DetailTestGWT;

import javax.ws.rs.*;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

@Path("detailTest")
public class DetailTestResource {
    private ApplicationContext context = new ClassPathXmlApplicationContext("ui/context.xml");
    private DetailTestService detailTestService = (DetailTestService)context.getBean("detailTestBean");

    @GET
    @Produces("application/json")
    public List<DetailTestGWT> getAll(){
        List<DetailTestGWT> detailTestGWTS = new LinkedList<>();
        for(DetailTest detailTest:detailTestService.getAll()){
            detailTestGWTS.add(new DetailTestGWT(detailTest.getId(),detailTest.getCountPassed(), detailTest.getCountFailed(), detailTest.getResult(), detailTest.getAttempts(), detailTest.getDate().toString()));
        }
        return detailTestGWTS;
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public DetailTestGWT get(@PathParam("id") int id){
        DetailTest detailTest = detailTestService.readById(id);
        return new DetailTestGWT(detailTest.getId(), detailTest.getCountPassed(), detailTest.getCountFailed(), detailTest.getResult(), detailTest.getAttempts(), detailTest.getDate().toString());
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public DetailTestGWT add(DetailTestGWT detailTestGWT){
        StringTokenizer stok = new StringTokenizer(detailTestGWT.getDate(),"-");
        DetailTest detailTest = detailTestService.add(new DetailTest(detailTestGWT.getCountPassed(), detailTestGWT.getCountFailed(), detailTestGWT.getResult(), detailTestGWT.getAttempts(), new Date(Integer.valueOf(stok.nextToken()), Integer.valueOf(stok.nextToken()), Integer.valueOf(stok.nextToken()))));
        return new DetailTestGWT(detailTest.getId(), detailTest.getCountPassed(),detailTest.getCountFailed(), detailTest.getResult(), detailTest.getAttempts(), detailTest.getDate().toString());
    }

    @POST
    @Path("/update")
    @Consumes("application/json")
    @Produces("application/json")
    public DetailTestGWT update(DetailTestGWT detailTestGWT){
        StringTokenizer stok = new StringTokenizer(detailTestGWT.getDate(),"-");
        DetailTest detailTest = new DetailTest(detailTestGWT.getCountPassed(), detailTestGWT.getCountFailed(), detailTestGWT.getResult(), detailTestGWT.getAttempts(), new Date(Integer.valueOf(stok.nextToken()), Integer.valueOf(stok.nextToken()), Integer.valueOf(stok.nextToken())));
        detailTest.setId(detailTestGWT.getId());
        detailTest = detailTestService.update(detailTest);
        return new DetailTestGWT(detailTest.getId(), detailTest.getCountPassed(),detailTest.getCountFailed(), detailTest.getResult(), detailTest.getAttempts(), detailTest.getDate().toString());
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
        StringTokenizer stok = new StringTokenizer(detailTestGWT.getDate(),"-");
        detailTest = new DetailTest(detailTestGWT.getCountPassed(), detailTestGWT.getCountFailed(), detailTestGWT.getResult(), detailTestGWT.getAttempts(), new Date(Integer.valueOf(stok.nextToken()), Integer.valueOf(stok.nextToken()), Integer.valueOf(stok.nextToken())));
        detailTest.setId(detailTestGWT.getId());
        detailTestService.delete(detailTest);
        if(detailTestService.readById(detailTestGWT.getId())!=null) return 2;
        return 0;
    }
}
