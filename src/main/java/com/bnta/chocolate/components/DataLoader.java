package com.bnta.chocolate.components;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.CocoaOrder;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.CocoaOrderRepository;
import com.bnta.chocolate.services.ChocolateService;
import com.bnta.chocolate.services.CocoaOrderService;
import com.bnta.chocolate.services.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    ChocolateService chocolateService;

    @Autowired
    EstateService estateService;

    @Autowired
    CocoaOrderRepository cocoaOrderRepository;

    public DataLoader(){

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // RABOT ESTATE
        Estate rabotEstate = new Estate("Rabot Estate", "St Lucia");
        estateService.saveEstate(rabotEstate);

        Chocolate saltedDark = new Chocolate("Salted Dark", 70);
        chocolateService.saveChocolate(saltedDark);

        CocoaOrder cocoaOrder1 = new CocoaOrder(saltedDark, rabotEstate, "RE254", 47.50);
        cocoaOrderRepository.save(cocoaOrder1);

        Chocolate supermilkHazelnut = new Chocolate("Supermilk Hazelnut", 40);
        chocolateService.saveChocolate(supermilkHazelnut);

        CocoaOrder cocoaOrder2 = new CocoaOrder(supermilkHazelnut, rabotEstate, "RE255", 50.50);
        cocoaOrderRepository.save(cocoaOrder2);


//      HACIENDA ZOLITA
        Estate haciendaZolita = new Estate("Hacienda Zolita", "Ecuador");
        estateService.saveEstate(haciendaZolita);

        Chocolate ecuadorDark = new Chocolate("Ecuador Dark", 72);
        chocolateService.saveChocolate(ecuadorDark);

        CocoaOrder cocoaOrder3 = new CocoaOrder(ecuadorDark, haciendaZolita, "HZ641", 50.10);
        cocoaOrderRepository.save(cocoaOrder3);

        Chocolate mintyLove = new Chocolate("Minty Love", 72);
        chocolateService.saveChocolate(mintyLove);

        CocoaOrder cocoaOrder4 = new CocoaOrder(mintyLove, haciendaZolita, "HZ954", 42.00);
        cocoaOrderRepository.save(cocoaOrder4);

//      KUAPA KOKOO
        Estate kuapaKokoo = new Estate("Kuapa Kokoo", "Ghana");
        estateService.saveEstate(kuapaKokoo);

        Chocolate pinkSalt = new Chocolate("Dark Pink Himalayan Salt", 60);
        chocolateService.saveChocolate(pinkSalt);

        CocoaOrder cocoaOrder5 = new CocoaOrder(pinkSalt, kuapaKokoo, "KA274", 55.20);
        cocoaOrderRepository.save(cocoaOrder5);

//      MIXED ORIGIN CHOCOLATE
        Chocolate toffeeTruffle = new Chocolate("Toffee Truffle", 55);
        chocolateService.saveChocolate(toffeeTruffle);

        CocoaOrder cocoaOrder6 = new CocoaOrder(toffeeTruffle, rabotEstate, "RE274", 47.50);
        cocoaOrderRepository.save(cocoaOrder6);

        CocoaOrder cocoaOrder7 = new CocoaOrder(toffeeTruffle, haciendaZolita, "HZ204", 39.70);
        cocoaOrderRepository.save(cocoaOrder7);

    }


}
