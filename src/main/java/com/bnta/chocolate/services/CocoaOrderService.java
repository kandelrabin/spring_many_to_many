package com.bnta.chocolate.services;

import com.bnta.chocolate.repositories.CocoaOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CocoaOrderService {

    @Autowired
    CocoaOrderRepository cocoaOrderRepository;



}
