package model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;

@Entity
public class TravakOrder {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;
    private UUID sandwichId;
    private String name;
    private BreadType breadType;
    @Temporal(TemporalType.DATE) //Date Only
    //@Temporal(TemporalType.TIMESTAMP) //Date + Time
    @JsonFormat(pattern="yyyy-MM-dd'T'hh:mm:ss.SSS")
    public Date creationDate;  //LocalDate!
    private BigDecimal price;
    private String mobilePhoneNumber;

    public TravakOrder(){

    }

   @PrePersist
    void createdAt(){
       this.creationDate = new Date();
    }

    public String getCreationDate(){
        return this.creationDate.toString();
    }

    public static OrderBuilder anOrder(){
        return new OrderBuilder();
    }

    public UUID getId(){
        return this.id;
    }

    protected void setId(UUID id){
        this.id=id;
    }

    public UUID getSandwichId(){ return this.sandwichId;}

    protected void setSandwichId(UUID sandwichId){
        this.sandwichId=sandwichId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public BreadType getBreadType(){
        return this.breadType;
    }

    public void setBreadType(BreadType breadType) {
        this.breadType=breadType;
    }

    public static class OrderBuilder{
        private UUID OrderId;
        private UUID sandwichId;
        private BreadType breadType;
        private String name;
        private BigDecimal price;
        private String mobilePhoneNumber;

        private OrderBuilder(){}

        public OrderBuilder withSandwichId(UUID sandwichId){
            this.sandwichId = sandwichId; return this;
        }

        public OrderBuilder withBreadType(String breadType) {
            String breadtypeUpper = breadType.toUpperCase();
            for(BreadType t : BreadType.class.getEnumConstants()){
                if(t.name().equals(breadtypeUpper)){

                   this.breadType = BreadType.valueOf(breadtypeUpper);
                    return this;
                }
            }
            throw new ModelException("Invalid breadType");
        }

        public OrderBuilder withName(String name) {
            this.name = name; return this;
        }

        public OrderBuilder withPrice(BigDecimal price) {
            this.price = price.setScale(2,BigDecimal.ROUND_HALF_UP);
            return this;
        }

        public OrderBuilder withMobilePhoneNumber(String mobilePhoneNumber) {
            this.mobilePhoneNumber = mobilePhoneNumber; return this;
        }

        public TravakOrder build(){
            TravakOrder order = new TravakOrder();
            order.sandwichId = this.sandwichId;
            order.breadType = this.breadType;
            order.name = this.name;
            order.price = this.price;
            order.mobilePhoneNumber = this.mobilePhoneNumber;
            return order;
        }

    }
}
