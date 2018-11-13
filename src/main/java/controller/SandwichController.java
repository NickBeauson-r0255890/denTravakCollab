package controller;

import db.SandwichRepository;
import model.Sandwich;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
public class SandwichController {


    SandwichRepository repository;

    @Autowired
    public SandwichController(SandwichRepository repository){
        this.repository = repository;
    }

    @RequestMapping(value = "/sandwich", method = RequestMethod.POST)
    public Sandwich sandwich(@RequestParam(value = "name") String name, @RequestParam(value = "price") String price, @RequestParam(value = "ingredients") String ingredients) {
        BigDecimal priceDecimal = new BigDecimal(price).setScale(2, BigDecimal.ROUND_HALF_UP);
        return Sandwich.aSandwich()
                .withName(name)
                .withPrice(priceDecimal)
                .withIngredients(ingredients)
                .build();
    }

    @RequestMapping(value = "/getSandwiches", method = RequestMethod.GET)
    public List<Sandwich> getSandwiches() {

        List<Sandwich> sandwiches = repository.findAll();
        return sandwiches;

    }

}
