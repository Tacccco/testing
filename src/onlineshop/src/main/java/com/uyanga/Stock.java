package com.uyanga;

import org.apache.commons.lang3.Validate;

import java.util.List;

public class Stock extends Entity{

    private String address;
//    private List<Product, Integer> availableProducts;

    public Stock(String id, String address) {
        super(id);
        this.address = Validate.notBlank(address);
    }

    public String getAddress() {
        return address;
    }

}
