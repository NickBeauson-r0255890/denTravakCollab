package controller;

import db.SandwichRepository;
import model.Sandwich;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RestController
public class SandwichController {


    SandwichRepository repository;

    @Autowired
    public SandwichController(SandwichRepository repository){
        this.repository = repository;
    }

    @RequestMapping(value = "/sandwiches", method = RequestMethod.GET)
    public List<Sandwich> getSandwiches() {
        List<Sandwich> sandwiches = repository.findAll();
        return sandwiches;
    }

    @RequestMapping(value="/sandwiches/{id}")
    public Sandwich getSandwich(@PathVariable("id") UUID id){
        Sandwich sandwich = repository.findById(id).get();
        return sandwich;
    }

    @RequestMapping(value = "/sandwiches", method = RequestMethod.POST)
    public Sandwich addSandwich(@RequestBody Sandwich sandwich) {
        repository.save(sandwich);
        return sandwich;
    }

    @RequestMapping(value="/sandwiches/{id}",method=RequestMethod.PUT)
    public Sandwich updateSandwich(@PathVariable("id") UUID id, @RequestBody Sandwich sandwich){
        Sandwich OldSandwich = repository.findById(id).get();
            OldSandwich.setName(sandwich.getName());
            OldSandwich.setPrice(sandwich.getPrice());
            OldSandwich.setIngredients(sandwich.getIngredients());
        repository.save(OldSandwich);
        return OldSandwich;
    }

    @RequestMapping(value="/deleteSandwich/{id}", method=RequestMethod.DELETE)
    public void deleteSandwich(@PathVariable("id") UUID id){
        repository.deleteById(id);
    }



}
