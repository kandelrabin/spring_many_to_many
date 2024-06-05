package com.bnta.chocolate.controllers;

import com.bnta.chocolate.models.CocoaOrder;
import com.bnta.chocolate.models.CocoaOrderDTO;
import com.bnta.chocolate.services.CocoaOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/cocoa-orders")
public class CocoaOrderController {

    @Autowired
    CocoaOrderService cocoaOrderService;

    //    INDEX
    @GetMapping
    public ResponseEntity<List<CocoaOrder>> getAllCocoaOrders(){
        return new ResponseEntity<>(cocoaOrderService.findAllCocoaOrders(), HttpStatus.OK);
    }

    //    CREATE
    @PostMapping
    public ResponseEntity<List<CocoaOrder>> createCocoaOrder(@RequestBody CocoaOrderDTO cocoaOrderDTO){
        cocoaOrderService.saveCocoaOrder(cocoaOrderDTO);
        return new ResponseEntity<>(cocoaOrderService.findAllCocoaOrders(), HttpStatus.CREATED);
    }

    //    DELETE
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteCocoaOrder(@PathVariable Long id){
        cocoaOrderService.deleteCocoaOrder(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    //    SHOW
    @GetMapping(value = "/{id}")
    public ResponseEntity<CocoaOrder> getChocolate(@PathVariable Long id){
        Optional<CocoaOrder> foundCocoaOrder = cocoaOrderService.findCocoaOrderById(id);
        if (foundCocoaOrder.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(foundCocoaOrder.get(), HttpStatus.OK);
        }
    }

}
