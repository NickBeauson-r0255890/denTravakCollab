package application;

import db.SandwichRepository;
import model.Sandwich;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.math.BigDecimal;

import static model.Sandwich.aSandwich;

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
    public CommandLineRunner demo(SandwichRepository repository){
        return (args) -> {
            Sandwich smosKaas = Sandwich.aSandwich().withName("Smos kaas").withPrice(createPrice(3.2)).withIngredients("kaas, sla, mayo, ei, tomaat").build();
            Sandwich smosHesp = Sandwich.aSandwich().withName("Smos hesp").withPrice(createPrice(3.2)).withIngredients("hesp, sla, mayo, ei, tomaat").build();
            Sandwich smosKaasHesp = Sandwich.aSandwich().withName("Smos kaas hesp").withPrice(createPrice(4.5)).withIngredients("kaas, hesp, sla, mayo, ei, tomaat").build();
            repository.save(smosKaas);
            repository.save(smosHesp);
            repository.save(smosKaasHesp);
        };
    }

    public BigDecimal createPrice(double price){
        return new BigDecimal(price).setScale(2,BigDecimal.ROUND_HALF_UP);
    }

}
