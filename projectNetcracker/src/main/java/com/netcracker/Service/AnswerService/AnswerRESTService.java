package com.netcracker.Service.AnswerService;

import com.netcracker.Entities.Answer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnswerRESTService {
    private AnswerService answerService;

    public void setAnswerService(AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping(value = "/answer",produces ="application/json" )
    public ResponseEntity<List<Answer>> getAllBuyers(){
        List<Answer> buyers = answerService.getAll();

        if (buyers.isEmpty())
            return new ResponseEntity<List<Answer>>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<Answer>>(buyers, HttpStatus.OK);
    }

    @GetMapping(value = "/answer/{id}")
    public ResponseEntity<Answer> getBuyerById(@PathVariable("id") int id){
        Answer buyer = answerService.readById(id);

        if (buyer == null)
            return new ResponseEntity<Answer>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<Answer>(buyer, HttpStatus.OK);

    }

    @PostMapping(value = "/answer/",consumes = "application/json")
    public ResponseEntity<Answer> addNewBuyer(@RequestBody Answer buyer){
        answerService.add(buyer);
        return new ResponseEntity<Answer>(buyer, HttpStatus.CREATED);
    }

    @DeleteMapping(value="/answer/{id}")
    public void deleteBuyer(@PathVariable("id") int id) {
        answerService.deleteById(id);
    }
}
