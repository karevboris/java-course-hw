package com.netcracker.Service.DetailTestService;

import com.netcracker.Entities.DetailTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DetailTestRESTService {
    private DetailTestService detailTestService;

    public void setDetailTestService(DetailTestService detailTestService) {
        this.detailTestService = detailTestService;
    }

    @GetMapping(value = "/detailTest",produces ="application/json" )
    public ResponseEntity<List<DetailTest>> getAllBuyers(){
        List<DetailTest> buyers = detailTestService.getAll();

        if (buyers.isEmpty())
            return new ResponseEntity<List<DetailTest>>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<DetailTest>>(buyers, HttpStatus.OK);
    }
}
