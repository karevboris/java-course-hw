package com.netcracker;

import com.netcracker.Entities.User;
import com.netcracker.Service.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    @Transactional
    public ResponseEntity getUser(@PathVariable("id") Integer id) {

        User cargo = userService.readById(id);
        if (cargo == null) {
            return new ResponseEntity("No user found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(cargo, HttpStatus.OK);
    }
}
