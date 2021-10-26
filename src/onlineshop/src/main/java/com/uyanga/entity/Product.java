package com.uyanga.entity;

import org.apache.commons.lang3.Validate;

public class Product extends Entity{
    private final String name;
    private String description;
    private final double price;

    public Product(String id, String name, double price) {
        super(id);
        this.name = Validate.notBlank(name);
        if (price < 0)
        {
          throw new IllegalArgumentException("Negative price is not allowed!") ;
        }

        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
