package ui.server;

import com.netcracker.Entities.Question;
import com.netcracker.Service.QuestionService.QuestionService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ui.shared.QuestionGWT;

import javax.ws.rs.*;
import java.util.LinkedList;
import java.util.List;

@Path("question")
public class QuestionResource {
    private ApplicationContext context = new ClassPathXmlApplicationContext("ui/context.xml");
    private QuestionService questionService = (QuestionService)context.getBean("questionBean");

    @GET
    @Produces("application/json")
    public List<QuestionGWT> getAll(){
        List<QuestionGWT> questionGWTS = new LinkedList<>();
        for(Question question:questionService.getAll()){
            questionGWTS.add(new QuestionGWT(question.getId(),question.getText(), question.getTime(), question.getPoints()));
        }
        return questionGWTS;
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public QuestionGWT get(@PathParam("id") int id){
        Question question = questionService.readById(id);
        return new QuestionGWT(question.getId(),question.getText(), question.getTime(), question.getPoints());
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public QuestionGWT add(QuestionGWT questionGWT){
        Question question = questionService.add(new Question(questionGWT.getText(), questionGWT.getTime(), questionGWT.getPoints()));
        return new QuestionGWT(question.getId(), question.getText(), question.getTime(), question.getPoints());
    }

    @POST
    @Path("/update")
    @Consumes("application/json")
    @Produces("application/json")
    public QuestionGWT update(QuestionGWT questionGWT) {
        Question question = new Question(questionGWT.getText(), questionGWT.getTime(), questionGWT.getPoints());
        question.setId(questionGWT.getId());
        question = questionService.update(question);
        return new QuestionGWT(question.getId(), question.getText(), question.getTime(), question.getPoints());
    }

    @DELETE
    @Path("/{id}")
    public Integer deleteById(@PathParam("id") int id){
        Question question = questionService.readById(id);
        if(question==null) return 1;
        questionService.deleteById(id);
        if(questionService.readById(id)!=null) return 2;
        return 0;
    }

    @DELETE
    @Consumes("application/json")
    public Integer delete(QuestionGWT questionGWT){
        Question question = questionService.readById(questionGWT.getId());
        if(question==null) return 1;
        question = new Question(questionGWT.getText(), questionGWT.getTime(), questionGWT.getPoints());
        question.setId(questionGWT.getId());
        questionService.delete(question);
        if(questionService.readById(questionGWT.getId())!=null) return 2;
        return 0;
    }
}
