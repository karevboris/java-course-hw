package com.netcracker.Service.TestQuestService;

import com.netcracker.Entities.Question;
import com.netcracker.Entities.TestQuest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestQuestRESTService {
    private TestQuestService testQuestService;

    public void setTestQuestService(TestQuestService testQuestService) {
        this.testQuestService = testQuestService;
    }

    @GetMapping(value = "/testQuest",produces ="application/json" )
    public ResponseEntity<List<TestQuest>> getAllBuyers(){
        List<TestQuest> buyers = testQuestService.getAll();

        if (buyers.isEmpty())
            return new ResponseEntity<List<TestQuest>>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<TestQuest>>(buyers, HttpStatus.OK);
    }

    @GetMapping(value = "/listQuest/{testId}",produces ="application/json" )
    public ResponseEntity<List<Question>> getAllQuestions(@PathVariable("testId") int testId){
        List<Question> questions = testQuestService.getQuestions(testId);

        if (questions.isEmpty())
            return new ResponseEntity<List<Question>>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<Question>>(questions, HttpStatus.OK);
    }
}
