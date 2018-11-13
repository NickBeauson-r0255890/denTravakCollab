package model;

import java.math.BigDecimal;

public class Order {

    private BreadType breadtype;
    private String sandwichName;
    private BigDecimal sandwichPrice;
    private String tel;

    private Order(){

    }

    public String getSandwichName() {
        return sandwichName;
    }

    public void setSandwichName(String sandwichName) {
        this.sandwichName = sandwichName;
    }

    public BigDecimal getSandwichPrice() {
        return sandwichPrice;
    }

    public void setSandwichPrice(BigDecimal sandwichPrice) {
        this.sandwichPrice = sandwichPrice;
    }

    public String getTelefoonnummer() {
        return tel;
    }

    public void setTelefoonnummer(String telefoonnummer) {
        this.tel = telefoonnummer;
    }

    public BreadType getBreadtype(){
        return this.breadtype;
    }

    public void setBreadtype(String breadtype) {
        String breadTypeUpper = breadtype.toUpperCase();
        if (checkBreadType(breadTypeUpper)) {
            this.breadtype = BreadType.valueOf(breadTypeUpper);
        }else{
            throw new ModelException("Invalid breadtype!");
        }
    }

    private boolean checkBreadType(String breadtype) {
        for(BreadType t : BreadType.class.getEnumConstants()){
            if(t.name().equals(breadtype)){
                return true;
            }
        }
        return false;
    }
    
    public static class OrderBuilder{
        private BreadType breadtype;
        private String sandwichName;
        private BigDecimal sandwichPrice;
        private String tel;
        
        public OrderBuilder withBreadtype(String breadtype) {
            String breadtypeUpper = breadtype.toUpperCase();
            for(BreadType t : BreadType.class.getEnumConstants()){
                if(t.name().equals(breadtypeUpper)){

                   this.breadtype = BreadType.valueOf(breadtypeUpper);
                    return this;
                }
            }
            throw new ModelException("Invalid breadType");
        }

        public OrderBuilder withSandwichName(String sandwichName) {
            this.sandwichName = sandwichName; return this;
        }

        public OrderBuilder withSandwichPrice(BigDecimal sandwichPrice) {
            this.sandwichPrice = sandwichPrice; return this;
        }

        public OrderBuilder withTel(String tel) {
            this.tel = tel; return this;
        }

        public Order build(){
            Order order = new Order();
            order.breadtype = this.breadtype;
            order.sandwichName = this.sandwichName;
            order.sandwichPrice = this.sandwichPrice;
            order.tel = this.tel;
            return order;
        }
        
    }
}
