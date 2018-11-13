package ui;

import model.Order;
import model.Sandwich;

import java.math.BigDecimal;
import java.util.UUID;

public class TestUI {
    public static void main(String[]args){

      /*  Sandwich buildedSandwich = new Sandwich.SandwichBuilder(UUID.randomUUID())
                .withName("cheese")
                .withPrice(new BigDecimal(3.2).setScale(2,BigDecimal.ROUND_HALF_UP))
                .withIngredients("Cheese, eggs, letuce, tomato, mayo")
                .build();

        Order order = new Order.OrderBuilder()
                .withBreadtype("wrap")
                .withSandwichName("cheese")
                .withSandwichPrice(new BigDecimal(4.15).setScale(2,BigDecimal.ROUND_HALF_UP))
                .withTel("0475694039")
                .build();

        System.out.println("You chose a " + buildedSandwich.getName() + " sandwich for " + buildedSandwich.getPrice() + " euro.");
        System.out.println("Your ordered a " + order.getSandwichName() + " " + order.getBreadtype() + " for " + order.getSandwichPrice() + " euro.");
   */
    }
}
