package com.bnta.chocolate.controllers;

import com.bnta.chocolate.services.CocoaOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cocoa-orders")
public class CocoaOrderController {

    @Autowired
    CocoaOrderService cocoaOrderService;


}
