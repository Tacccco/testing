package com.uyanga.entity;

import com.uyanga.ProductListItem;
import org.apache.commons.lang3.Validate;

import java.util.ArrayList;
import java.util.List;

public class Stock extends Entity{

    private String address;
    private List<ProductListItem> availableProducts = new ArrayList<>();

    public Stock(String id, String address) {
        super(id);
        this.address = Validate.notBlank(address);
    }

    public String getAddress() {
        return address;
    }

    public void addToProductList(ProductListItem productListItem){
        availableProducts.add(productListItem);
    }

    public List<ProductListItem> getAvailableProducts() {
        return availableProducts;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
