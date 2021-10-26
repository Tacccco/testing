package com.uyanga;

import org.apache.commons.lang3.Validate;

public class ProductListItem {
    protected final String productID;
    protected double amount;

    public ProductListItem(String productID, double amount) {
        this.productID = Validate.notBlank(productID);
        if(amount < 0)
        {
            throw new IllegalArgumentException("Amount can not be negative");
        }
        this.amount = amount;
    }

    public String getProductID() {
        return productID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
