package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@SpringBootApplication
//@EnableDiscoveryClient
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


/*    @Bean
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
    }*/

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
