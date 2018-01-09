package com.netcracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class BuyerRESTService {
    BuyerService buyerService;

    public void setBuyerService(BuyerService buyerService) {
        this.buyerService = buyerService;
    }

    @GetMapping(value = "/buyer",produces ="application/json" )
    public ResponseEntity<List<Buyer>> getAllBuyers(){
        List<Buyer> buyers = buyerService.getAll();

        if (buyers.isEmpty())
            return new ResponseEntity<List<Buyer>>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<Buyer>>(buyers, HttpStatus.OK);

    }

    @GetMapping(value = "/buyer/{id}")
    public ResponseEntity<Buyer> getBuyerById(@PathVariable("id") int id){
        Buyer buyer = buyerService.getById(id);

        if (buyer == null)
            return new ResponseEntity<Buyer>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<Buyer>(buyer, HttpStatus.OK);

    }

    @PostMapping(value = "/buyer/",consumes = "application/json")
    public ResponseEntity<Buyer> addNewBuyer(@RequestBody Buyer buyer){
        buyerService.create(buyer);
        return new ResponseEntity<Buyer>(buyer, HttpStatus.CREATED);
    }

    @DeleteMapping(value="/buyer/{id}")
    public ResponseEntity deleteBuyer(@PathVariable("id") int id) {
        if(buyerService.deleteById(id)) return new ResponseEntity(HttpStatus.OK);
        else return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value="/buyer/")
    public ResponseEntity deleteAllBuyer() {
        if (buyerService.deleteAll())return new ResponseEntity(HttpStatus.OK);
        else return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}

