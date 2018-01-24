package com.netcracker.Service.UserTestService;

import com.netcracker.Entities.UserTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserTestRESTService {
    private UserTestService userTestService;

    public void setUserTestService(UserTestService userTestService) {
        this.userTestService = userTestService;
    }

    @GetMapping(value = "/userTest",produces ="application/json" )
    public ResponseEntity<List<UserTest>> getAllBuyers(){
        List<UserTest> buyers = userTestService.getAll();

        if (buyers.isEmpty())
            return new ResponseEntity<List<UserTest>>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<UserTest>>(buyers, HttpStatus.OK);
    }
}
