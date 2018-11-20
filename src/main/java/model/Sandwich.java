package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class Sandwich {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private BigDecimal price;       //TODO:  Bigdecimal -> JSON serialize  2 decimals
                                    //https://stackoverflow.com/questions/48662635/how-to-display-bigdecimal-number-with-trailing-zero-in-a-json-not-as-string
    private String ingredients;

    public Sandwich(){
    }

    public static SandwichBuilder aSandwich(){
        return new SandwichBuilder();
    }

    public UUID getId(){
        return this.id;
    }

    protected void setId(UUID id){
        this.id= id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }


    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }



    public static class SandwichBuilder{

        private UUID id;
        private String name;
        private BigDecimal price;
        private String ingredients;

        private SandwichBuilder(){
        }

        public SandwichBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public SandwichBuilder withPrice(BigDecimal price) {
            this.price = price.setScale(2,BigDecimal.ROUND_HALF_UP);
            return this;
        }

        public SandwichBuilder withIngredients(String ingredients) {
            this.ingredients = ingredients;
            return this;
        }

        public Sandwich build(){
            Sandwich sandwich = new Sandwich();
            sandwich.name = this.name;
            sandwich.price = this.price;
            sandwich.ingredients = this.ingredients;
            return sandwich;
        }

    }


}


