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

    //Get of get?date=...
    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public List<TravakOrder> getOrder(@RequestParam(value = "date" , required = false) @DateTimeFormat(pattern="yyyy-MM-dd")  Date searchDate) throws ParseException {
        //Date date = new SimpleDateFormat("yyyy-MM-dd").parse(searchDate);
        //System.out.println(searchDate);
        if(searchDate != null){
            return repository.findAllByCreationDate(searchDate);
        }
        return repository.findAll();
    }

    @RequestMapping(value = "/orders", method = RequestMethod.POST)
    public TravakOrder addOrder(@RequestBody TravakOrder travakOrder) {
        repository.save(travakOrder);
        //System.out.println(travakOrder.getCreationDate());
        return travakOrder;
    }

}
