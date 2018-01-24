package com.netcracker.Service.UserService;

import com.netcracker.Entities.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserRESTService {
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/user",produces ="application/json" )
    public ResponseEntity<List<User>> getAllBuyers(){
        List<User> buyers = userService.getAll();

        if (buyers.isEmpty())
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<User>>(buyers, HttpStatus.OK);
    }
}
