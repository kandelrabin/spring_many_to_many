package com.bnta.chocolate.services;

import com.bnta.chocolate.models.CocoaOrder;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.models.EstateDTO;
import com.bnta.chocolate.repositories.CocoaOrderRepository;
import com.bnta.chocolate.repositories.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EstateService {

    @Autowired
    EstateRepository estateRepository;

    @Autowired
    CocoaOrderRepository cocoaOrderRepository;

    public void saveEstate(Estate estate){
        estateRepository.save(estate);
    }

    public List<Estate> getAllEstates(){
        return estateRepository.findAll();
    }

    public Optional<Estate> findSingleEstate(Long id){
        return estateRepository.findById(id);
    }

    public Estate updateEstate(EstateDTO estateDTO, Long id){   // ADDED
        Estate estateToUpdate = estateRepository.findById(id).get();
        estateToUpdate.setName(estateDTO.getName());
        estateToUpdate.setCountry(estateDTO.getCountry());
        estateToUpdate.setCocoaOrders(new ArrayList<>());

        for (Long cocoaOrderId : estateDTO.getCocoaOrderIds()){
            CocoaOrder cocoaOrder = cocoaOrderRepository.findById(cocoaOrderId).get();
            estateToUpdate.addCocoaOrder(cocoaOrder);
        }

        estateRepository.save(estateToUpdate);
        return estateToUpdate;
    }

    public void deleteEstate(Long estateId){ // ADDED
//        find estate
        Estate estate = findSingleEstate(estateId).get();
//        delete associated cocoaOrders
        for (CocoaOrder cocoaOrder : estate.getCocoaOrders()){
            cocoaOrderRepository.deleteById(cocoaOrder.getId());
        }
        estateRepository.deleteById(estateId);
    }

}
