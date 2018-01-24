package ui.server;

import com.netcracker.Entities.Answer;
import com.netcracker.Service.AnswerService.AnswerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ui.shared.AnswerGWT;

import javax.ws.rs.*;
import java.util.LinkedList;
import java.util.List;

@Path("answer")
public class AnswerResource {
    private ApplicationContext context = new ClassPathXmlApplicationContext("ui/context.xml");
    private AnswerService answerService = (AnswerService)context.getBean("answerBean");

    @GET
    @Produces("application/json")
    public List<AnswerGWT> getAll(){
        List<AnswerGWT> answerClients = new LinkedList<>();
        for(Answer answer:answerService.getAll()){
            answerClients.add(new AnswerGWT(answer.getId(),answer.getText()));
        }
        return answerClients;
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public AnswerGWT get(@PathParam("id") int id){
        Answer answer = answerService.readById(id);
        return new AnswerGWT(answer.getId(), answer.getText());
    }

    @POST
    @Consumes("application/json")
    public void add(AnswerGWT answer){
        answerService.add(new Answer(answer.getText()));
    }

    @POST
    @Path("/update")
    @Consumes("application/json")
    public Boolean update(AnswerGWT answerGWT){
        if(answerService.readById(answerGWT.getId())==null) return false;
        Answer answer = new Answer(answerGWT.getText());
        answer.setId(answerGWT.getId());
        answerService.update(answer);
        return true;
    }

    @DELETE
    @Path("/{id}")
    public Integer deleteById(@PathParam("id") int id){
        Answer answer = answerService.readById(id);
        if(answer==null) return 1;
        answerService.deleteById(id);
        if(answerService.readById(id)!=null) return 2;
        return 0;
    }

    @DELETE
    @Consumes("application/json")
    public Integer delete(AnswerGWT answerGWT){
        Answer answer = answerService.readById(answerGWT.getId());
        if(answer==null) return 1;
        answer = new Answer(answerGWT.getText());
        answer.setId(answerGWT.getId());
        answerService.delete(answer);
        if(answerService.readById(answerGWT.getId())!=null) return 2;
        return 0;
    }
}
