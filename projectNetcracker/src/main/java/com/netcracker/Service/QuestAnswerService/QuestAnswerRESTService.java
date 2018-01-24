package com.netcracker.Service.QuestAnswerService;

import com.netcracker.Entities.QuestAnswer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuestAnswerRESTService {
    private QuestAnswerService questAnswerService;

    public void setQuestAnswerService(QuestAnswerService questAnswerService) {
        this.questAnswerService = questAnswerService;
    }

    @GetMapping(value = "/questAnswer",produces ="application/json" )
    public ResponseEntity<List<QuestAnswer>> getAllBuyers(){
        List<QuestAnswer> buyers = questAnswerService.getAll();

        if (buyers.isEmpty())
            return new ResponseEntity<List<QuestAnswer>>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<QuestAnswer>>(buyers, HttpStatus.OK);
    }
}
