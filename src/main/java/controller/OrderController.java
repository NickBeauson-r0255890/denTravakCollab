package controller;

import db.OrderRepository;
import model.TravakOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
@RestController
public class OrderController {

    OrderRepository repository;

    @Autowired
    public OrderController(OrderRepository repository) {
        this.repository = repository;
    }


    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public Iterable<TravakOrder> getOrder() {
       return repository.findAll();
    }

    @RequestMapping(value = "/orders", method = RequestMethod.POST)
    public TravakOrder addOrder(@RequestBody TravakOrder order) {
        repository.save(order);
        return order;
    }

}
