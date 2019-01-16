package be.ucll.da.dentravak.controller;

import be.ucll.da.dentravak.db.OrderRepository;
import be.ucll.da.dentravak.model.SandwichOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    OrderRepository repository;

    @Autowired
    public OrderController(OrderRepository repository) {
        this.repository = repository;
    }


    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public Iterable<SandwichOrder> getOrder() {
       return repository.findAll();
    }

    @RequestMapping(value = "/orders", method = RequestMethod.POST)
    public SandwichOrder addOrder(@RequestBody SandwichOrder order) {
        repository.save(order);
        return order;
    }

}
