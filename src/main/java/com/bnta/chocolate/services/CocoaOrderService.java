package com.bnta.chocolate.services;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.CocoaOrder;
import com.bnta.chocolate.models.CocoaOrderDTO;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.CocoaOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CocoaOrderService {

    @Autowired
    CocoaOrderRepository cocoaOrderRepository;

    @Autowired
    ChocolateService chocolateService;

    @Autowired
    EstateService estateService;


    public List<CocoaOrder> findAllCocoaOrders(){
        return cocoaOrderRepository.findAll();
    }

    public Optional<CocoaOrder> findCocoaOrderById(long id){
        return cocoaOrderRepository.findById(id);
    }

    public void deleteCocoaOrder(long id){
        cocoaOrderRepository.deleteById(id);
    }

    public CocoaOrder saveCocoaOrder(CocoaOrderDTO cocoaOrderDTO){
        Chocolate chocolate =
                chocolateService.findSingleChocolate(cocoaOrderDTO.getChocolateId()).get();
        Estate estate =
                estateService.findSingleEstate(cocoaOrderDTO.getEstateId()).get();
        CocoaOrder cocoaOrder = new CocoaOrder(
                chocolate,
                estate,
                cocoaOrderDTO.getBatchNumber(),
                cocoaOrderDTO.getPricePaid());
        cocoaOrderRepository.save(cocoaOrder);
        return cocoaOrder;
    }

}
