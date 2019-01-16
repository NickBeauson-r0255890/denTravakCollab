package be.ucll.da.dentravak;

import be.ucll.da.dentravak.db.OrderRepository;
import be.ucll.da.dentravak.db.SandwichRepository;
import be.ucll.da.dentravak.model.Sandwich;
import be.ucll.da.dentravak.model.SandwichOrder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

//import static model.SandwichTestBuilder.aDefaultSandwich;


@SpringBootApplication
@EnableDiscoveryClient
//@EnableJpaRepositories(basePackageClasses = SandwichRepository.class)
//@EntityScan(basePackageClasses=Sandwich.class)
public class Application {


    private static final Logger log = LoggerFactory.getLogger(Application.class);


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


   @Bean
    public CommandLineRunner demo(SandwichRepository sandwichRepository, OrderRepository orderRepository) {

        return (args) -> {
            //Sandwich kaas = Sandwich.aDefaultSandwich()
            //.withName("Kaas")
            //.withPrice(New BigDecimal("3.50"))
            //.withIngredients("Kaas")
            Sandwich hesp = new Sandwich();
            hesp.setName("Smos hesp");
            hesp.setIngredients("hesp, tomaat, sla, ei, mayonnaise");
            hesp.setPrice(new BigDecimal("3.50"));

            Sandwich smoske = new Sandwich();
            smoske.setName("Smoske");
            smoske.setIngredients("kaas, hesp, tomaat, sla, ei, mayonnaise");
            smoske.setPrice(new BigDecimal("4.00"));

            Sandwich martino = new Sandwich();
            martino.setName("Martino");
            martino.setIngredients("martino, ui");
            martino.setPrice(new BigDecimal("3.50"));

           // sandwichRepository.save(kaas);
            sandwichRepository.save(hesp);
            sandwichRepository.save(smoske);
            sandwichRepository.save(martino);


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

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    @Configuration
    public class WebConfig implements WebMvcConfigurer {
        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**");
        }
    }


}
