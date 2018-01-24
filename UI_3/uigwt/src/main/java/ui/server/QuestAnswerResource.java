package ui.server;

import com.netcracker.Entities.PrimaryKey.QuestAnswerKey;
import com.netcracker.Entities.QuestAnswer;
import com.netcracker.Service.QuestAnswerService.QuestAnswerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ui.shared.QuestAnswerGWT;

import javax.ws.rs.*;
import java.util.LinkedList;
import java.util.List;

@Path("questAnswer")
public class QuestAnswerResource {
    private ApplicationContext context = new ClassPathXmlApplicationContext("ui/context.xml");
    private QuestAnswerService questAnswerService = (QuestAnswerService)context.getBean("questAnswerBean");

    @GET
    @Produces("application/json")
    public List<QuestAnswerGWT> getAll(){
        List<QuestAnswerGWT> questAnswerGWTS = new LinkedList<>();
        for(QuestAnswer questAnswer:questAnswerService.getAll()){
            questAnswerGWTS.add(new QuestAnswerGWT(questAnswer.getCorrect(), questAnswer.getId().getQuestId(), questAnswer.getId().getAnswerId()));
        }
        return questAnswerGWTS;
    }

    @GET
    @Path("/{idQ}/{idA}")
    @Produces("application/json")
    public QuestAnswerGWT get(@PathParam("idQ") int idQ, @PathParam("idA") int idA){
        QuestAnswerKey questAnswerKey = new QuestAnswerKey(idQ, idA);
        QuestAnswer questAnswer = questAnswerService.readById(questAnswerKey);
        return new QuestAnswerGWT(questAnswer.getCorrect(), questAnswer.getId().getQuestId(), questAnswer.getId().getAnswerId());
    }

    @POST
    @Consumes("application/json")
    public void add(QuestAnswerGWT questAnswerGWT){
        questAnswerService.add(new QuestAnswer(questAnswerGWT.getCorrect()));
    }

    @POST
    @Path("/update")
    @Consumes("application/json")
    public Boolean update(QuestAnswerGWT questAnswerGWT){
        QuestAnswerKey questAnswerKey = new QuestAnswerKey(questAnswerGWT.getQuestId(), questAnswerGWT.getAnswerId());
        if(questAnswerService.readById(questAnswerKey)==null) return false;
        QuestAnswer questAnswer = new QuestAnswer(questAnswerGWT.getCorrect());
        questAnswer.setId(questAnswerKey);
        questAnswerService.update(questAnswer);
        return true;
    }

    @DELETE
    @Path("/{idQ}/{idA}")
    public Integer deleteById(@PathParam("idQ") int idQ, @PathParam("idA") int idA){
        QuestAnswerKey questAnswerKey = new QuestAnswerKey(idQ, idA);
        QuestAnswer questAnswer = questAnswerService.readById(questAnswerKey);
        if(questAnswer==null) return 1;
        questAnswerService.deleteById(questAnswerKey);
        if(questAnswerService.readById(questAnswerKey)!=null) return 2;
        return 0;
    }

    @DELETE
    @Consumes("application/json")
    public Integer delete(QuestAnswerGWT questAnswerGWT){
        QuestAnswerKey questAnswerKey = new QuestAnswerKey(questAnswerGWT.getQuestId(), questAnswerGWT.getAnswerId());
        QuestAnswer questAnswer = questAnswerService.readById(questAnswerKey);
        if(questAnswer==null) return 1;
        questAnswer = new QuestAnswer(questAnswerGWT.getCorrect());
        questAnswer.setId(questAnswerKey);
        questAnswerService.delete(questAnswer);
        if(questAnswerService.readById(questAnswerKey)!=null) return 2;
        return 0;
    }
}
