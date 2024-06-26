package com.bnta.chocolate.services;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.ChocolateDTO;
import com.bnta.chocolate.models.CocoaOrder;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import com.bnta.chocolate.repositories.CocoaOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChocolateService {

    @Autowired
    ChocolateRepository chocolateRepository;

    @Autowired
    CocoaOrderRepository cocoaOrderRepository;

    public void saveChocolate(Chocolate chocolate){
        chocolateRepository.save(chocolate);
    }

    public List<Chocolate> getAllChocolates(){
        return chocolateRepository.findAll();
    }

    public List<Chocolate> getChoclatesWithCocoaPercentageGreaterThan(int cocoaPercentage){
        return chocolateRepository.findByCocoaPercentageGreaterThan(cocoaPercentage);
    }

    public Optional<Chocolate> findSingleChocolate(Long id){
        return chocolateRepository.findById(id);
    }

    public Chocolate updateChocolate(ChocolateDTO chocolateDTO, long chocolateId){
        Chocolate chocolateToUpdate = findSingleChocolate(chocolateId).get();
        chocolateToUpdate.setName(chocolateDTO.getName());
        chocolateToUpdate.setCocoaPercentage(chocolateDTO.getCocoaPercentage());
        chocolateToUpdate.setCocoaOrders(new ArrayList<>());
        for (long cocoaOrderId : chocolateDTO.getCocoaOrderIds()){
            CocoaOrder cocoaOrder = cocoaOrderRepository.findById(cocoaOrderId).get();
            chocolateToUpdate.addCocoaOrder(cocoaOrder);
        }
        chocolateRepository.save(chocolateToUpdate);
        return chocolateToUpdate;
    }

    public void deleteChocolate(long chocolateId){
        Chocolate chocolate = findSingleChocolate(chocolateId).get();
        for (CocoaOrder cocoaOrder : chocolate.getCocoaOrders()){
            cocoaOrderRepository.deleteById(cocoaOrder.getId());
        }
        chocolateRepository.deleteById(chocolateId);
    }

}
