package application;

import db.OrderRepository;
import db.SandwichRepository;
import model.BreadType;
import model.Sandwich;
import model.TravakOrder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.math.BigDecimal;

import static model.BreadType.TURKISH_BREAD;

@Configuration
@ComponentScan("controller")
@SpringBootApplication
@EnableJpaRepositories("db")
@EntityScan("model")
public class Application {
    public static void main(String[]args){
        SpringApplication.run(Application.class, args);
    }


    @Bean
    public CommandLineRunner demo(SandwichRepository sandwichRepository, OrderRepository orderRepository){
        return (args) -> {
           /*Sandwich smosKaas = Sandwich.aSandwich().withName("Smos kaas").withPrice("3.20").withIngredients("kaas, sla, mayo, ei, tomaat").build();
            Sandwich smosHesp = Sandwich.aSandwich().withName("Smos hesp").withPrice("3.20").withIngredients("hesp, sla, mayo, ei, tomaat").build();
            Sandwich smosKaasHesp = Sandwich.aSandwich().withName("Smos kaas hesp").withPrice("4.50").withIngredients("kaas, hesp, sla, mayo, ei, tomaat").build();
            sandwichRepository.save(smosKaas);
            sandwichRepository.save(smosHesp);
            sandwichRepository.save(smosKaasHesp);
            TravakOrder wrapGezond = TravakOrder.anOrder().withBreadtype("wrap").withSandwichName("Wrap gezond").withSandwichPrice("4.00").withTel("0476593025").build();
            */TravakOrder turksKip = TravakOrder.anOrder().withBreadType("Turkish_bread").withName("Turkish Kip").withPrice(new BigDecimal(3.2)).withMobilePhoneNumber("0496205960").build();
            //orderRepository.save(wrapGezond);
            orderRepository.save(turksKip);
           Sandwich gezond = Sandwich.aSandwich().withName("Gezond").withIngredients("Groentjes").withPrice(new BigDecimal(4.00)).build();
            sandwichRepository.save(gezond);
        };
    }


}
