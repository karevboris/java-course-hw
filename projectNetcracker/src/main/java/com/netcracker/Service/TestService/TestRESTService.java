package com.netcracker.Service.TestService;

import com.netcracker.Entities.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestRESTService {
    private TestService testService;

    public void setTestService(TestService testService) {
        this.testService = testService;
    }

    @GetMapping(value = "/test",produces ="application/json" )
    public ResponseEntity<List<Test>> getAllBuyers(){
        List<Test> buyers = testService.getAll();

        if (buyers.isEmpty())
            return new ResponseEntity<List<Test>>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<Test>>(buyers, HttpStatus.OK);
    }
}
