package com.bnta.chocolate.controllers;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.EstateRepository;
import com.bnta.chocolate.services.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estates")
public class EstateController {

    @Autowired
    EstateService estateService;

//    INDEX
    @GetMapping
    public ResponseEntity<List<Estate>> getAllEstates(){
        return new ResponseEntity<>(estateService.getAllEstates(), HttpStatus.OK);
    }

//    SHOW: GET localhost:8080/estates/3
    @GetMapping(value = "/{id}")
    public ResponseEntity<Estate> getEstate(@PathVariable Long id){
        Optional<Estate> estate = estateService.findSingleEstate(id);
        if (estate.isPresent()){
            return new ResponseEntity<>(estate.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

//    CREATE: POST localhost:8080/estates
    @PostMapping
    public ResponseEntity<List<Estate>> postEstate(@RequestBody Estate estate){
        estateService.saveEstate(estate);
        return new ResponseEntity<>(estateService.getAllEstates(), HttpStatus.CREATED);
    }

//    TODO: UPDATE: PUT localhost:8080/estates/1

//    TODO: DELETE: DELETE localhost:8080/estates/3

}
