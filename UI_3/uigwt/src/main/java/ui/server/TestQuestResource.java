package ui.server;

import com.netcracker.Entities.PrimaryKey.TestQuestKey;
import com.netcracker.Entities.Question;
import com.netcracker.Entities.TestQuest;
import com.netcracker.Service.TestQuestService.TestQuestService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ui.shared.QuestionGWT;
import ui.shared.TestQuestGWT;

import javax.ws.rs.*;
import java.util.LinkedList;
import java.util.List;

@Path("testQuest")
public class TestQuestResource {
    private ApplicationContext context = new ClassPathXmlApplicationContext("ui/context.xml");
    private TestQuestService testQuestService = (TestQuestService)context.getBean("testQuestBean");

    @GET
    @Produces("application/json")
    public List<TestQuestGWT> getAll(){
        List<TestQuestGWT> testQuestGWTS = new LinkedList<>();
        for(TestQuest testQuest:testQuestService.getAll()){
            testQuestGWTS.add(new TestQuestGWT(testQuest.getId().getQuestId(), testQuest.getId().getTestId()));
        }
        return testQuestGWTS;
    }

    @GET
    @Path("/{idT}/{idQ}")
    @Produces("application/json")
    public TestQuestGWT get(@PathParam("idT") int idT, @PathParam("idQ") int idQ){
        TestQuestKey testQuestKey = new TestQuestKey(idQ, idT);
        TestQuest testQuest = testQuestService.readById(testQuestKey);
        return new TestQuestGWT(testQuest.getId().getQuestId(), testQuest.getId().getTestId());
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public TestQuestGWT add(TestQuestGWT testQuestGWT){
        TestQuestKey testQuestKey = new TestQuestKey(testQuestGWT.getQuestId(), testQuestGWT.getTestId());
        TestQuest testQuest = new TestQuest();
        testQuest.setId(testQuestKey);
        testQuest = testQuestService.add(testQuest);
        return new TestQuestGWT(testQuest.getId().getQuestId(), testQuest.getId().getTestId());
    }

    @POST
    @Path("/update")
    @Consumes("application/json")
    @Produces("application/json")
    public TestQuestGWT update(TestQuestGWT testQuestGWT){
        TestQuestKey testQuestKey = new TestQuestKey(testQuestGWT.getQuestId(), testQuestGWT.getTestId());
        TestQuest testQuest = new TestQuest();
        testQuest.setId(testQuestKey);
        testQuest = testQuestService.update(testQuest);
        return new TestQuestGWT(testQuest.getId().getQuestId(), testQuest.getId().getTestId());
    }

    @DELETE
    @Path("/{idT}/{idQ}")
    public Integer deleteById(@PathParam("idT") int idT, @PathParam("idQ") int idQ){
        TestQuestKey testQuestKey = new TestQuestKey(idQ, idT);
        TestQuest testQuest = testQuestService.readById(testQuestKey);
        if(testQuest==null) return 1;
        testQuestService.deleteById(testQuestKey);
        if(testQuestService.readById(testQuestKey)!=null) return 2;
        return 0;
    }

    @DELETE
    @Consumes("application/json")
    public Integer delete(TestQuestGWT testQuestGWT){
        TestQuestKey testQuestKey = new TestQuestKey(testQuestGWT.getQuestId(), testQuestGWT.getTestId());
        TestQuest testQuest = testQuestService.readById(testQuestKey);
        if(testQuest==null) return 1;
        testQuest = new TestQuest();
        testQuest.setId(testQuestKey);
        testQuestService.delete(testQuest);
        if(testQuestService.readById(testQuestKey)!=null) return 2;
        return 0;
    }


    @GET
    @Path("/getQuestions/{id}")
    public List<QuestionGWT> getQuestions(@PathParam("id")int id){
        List<QuestionGWT> questionGWTS = new LinkedList<>();
        for(Question question:testQuestService.getQuestions(id)){
            questionGWTS.add(new QuestionGWT(question.getId(), question.getText(), question.getTime(), question.getPoints()));
        }
        return questionGWTS;
    }

    @DELETE
    @Path("/deleteQuestions/{id}")
    public void deleteQuestions(@PathParam("id")int id){
        testQuestService.deleteQuestions(id);
    }

    @GET
    @Path("getTestTime/{id}")
    public Integer getTestTime(@PathParam("id") int id){
        return testQuestService.getTestTime(id);
    }
}
