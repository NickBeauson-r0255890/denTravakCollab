package application;

import db.OrderRepository;
import db.SandwichRepository;
import model.Sandwich;
import model.SandwichOrder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Configuration
@ComponentScan("controller")
@SpringBootApplication
@EnableJpaRepositories("db")
@EntityScan("model")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    public CommandLineRunner demo(SandwichRepository sandwichRepository, OrderRepository orderRepository) {
        return (args) -> {
            Sandwich sandwich = new Sandwich();
            sandwich.setName("Test Sandwich");
            sandwich.setIngredients("Test ingrediënten");
            sandwich.setPrice(new BigDecimal("5.99"));

            sandwichRepository.save(sandwich);

            SandwichOrder order = new SandwichOrder();
            order.setName("First order");
            order.setCreationDate(LocalDateTime.now());
            order.setPrice(new BigDecimal("10.99"));
            order.setId(UUID.randomUUID());
            order.setBreadType(SandwichOrder.BreadType.WRAP);
            order.setMobilePhoneNumber("123456789");


            orderRepository.save(order);

        };
    }


}
