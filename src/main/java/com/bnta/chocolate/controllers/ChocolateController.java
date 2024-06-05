package com.bnta.chocolate.controllers;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.ChocolateDTO;
import com.bnta.chocolate.services.ChocolateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/chocolates")
public class ChocolateController {

    @Autowired
    ChocolateService chocolateService;

//    Handles following:
//    * INDEX: GET /chocolates
//    * GET /chocolates?cocoaPercentage=69
    @GetMapping
    public ResponseEntity<List<Chocolate>> getAllChocolatesAndFilters(
            @RequestParam(required = false, name = "cocoaPercentage") Integer cocoaPercentage
    ){
//        GET /chocolates?cocoaPercentage=69
        if(cocoaPercentage != null){
            return new ResponseEntity<>(chocolateService.getChoclatesWithCocoaPercentageGreaterThan(cocoaPercentage), HttpStatus.OK);
        }
//        GET /chocolates
        return new ResponseEntity<>(chocolateService.getAllChocolates(), HttpStatus.OK);
    }

//  SHOW: GET localhost:8080/chocolates/id
    @GetMapping(value = "/{id}")
    public ResponseEntity<Chocolate> getChocolate(@PathVariable Long id){
        Optional<Chocolate> chocolate = chocolateService.findSingleChocolate(id);
        if (chocolate.isPresent()){
            return new ResponseEntity<>(chocolate.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

//    CREATE: POST localhost:8080/chocolates
    @PostMapping
    public ResponseEntity<Chocolate> postChocolate(@RequestBody Chocolate chocolate){
        chocolateService.saveChocolate(chocolate);
        return new ResponseEntity<>(chocolate, HttpStatus.CREATED);
    }

//    UPDATE: PUT localhost:8080/chocolates/4
    @PutMapping(value = "/{id}")
    public ResponseEntity<Chocolate> updateChocolate(@RequestBody ChocolateDTO chocolateDTO, @PathVariable long id){
        Optional<Chocolate> chocolate = chocolateService.findSingleChocolate(id);
        if (chocolate.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else{
            Chocolate updatedChocolate = chocolateService.updateChocolate(chocolateDTO, id);
            return new ResponseEntity<>(updatedChocolate, HttpStatus.OK);
        }
    }
//    DELETE: DELETE localhost:8080/chocolates/3
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteChocolate(@PathVariable long id){
        chocolateService.deleteChocolate(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
