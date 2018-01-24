package com.netcracker.Service.QuestionService;

import com.netcracker.Entities.Question;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuestionRESTService {
    private QuestionService questionService;

    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping(value = "/question",produces ="application/json" )
    public ResponseEntity<List<Question>> getAllBuyers(){
        List<Question> buyers = questionService.getAll();

        if (buyers.isEmpty())
            return new ResponseEntity<List<Question>>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<Question>>(buyers, HttpStatus.OK);
    }
}
