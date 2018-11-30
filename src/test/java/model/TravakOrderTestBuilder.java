package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class TravakOrderTestBuilder {


    private UUID sandwichId;
    private String name;
    private LocalDateTime creationDate;
    private BigDecimal price;
    private String mobilePhoneNumber;
    private TravakOrder.BreadType breadType;

    private TravakOrderTestBuilder() {
    }

    public TravakOrderTestBuilder aDefaultSandwichOrder() {
        return new TravakOrderTestBuilder();
    }

    public TravakOrderTestBuilder forSandwich(Sandwich sandwich) {
        this.sandwichId = sandwich.getId();
        this.name = sandwich.getName();
        this.price = sandwich.getPrice();
        return this;
    }

    public TravakOrderTestBuilder withSandwichId(UUID sandwichId) {
        this.sandwichId = sandwichId;
        return this;
    }

    public TravakOrderTestBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public TravakOrderTestBuilder withBreadType(TravakOrder.BreadType breadType) {
        this.breadType = breadType;
        return this;
    }

    public TravakOrderTestBuilder withCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public TravakOrderTestBuilder withPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public TravakOrderTestBuilder withMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
        return this;
    }

    public TravakOrder build() {
        TravakOrder order = new TravakOrder();
        order.setSandwichId(sandwichId);
        order.setName(name);
        order.setBreadType(breadType);
        order.setCreationDate(creationDate);
        order.setMobilePhoneNumber(mobilePhoneNumber);
        order.setPrice(price);
        return order;
    }

}

