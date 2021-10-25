package com.uyanga;

import org.apache.commons.lang3.Validate;

public class ProductListItem {
    protected final Product product;
    protected double amount;

    public ProductListItem(Product product, double amount) {
        this.product = Validate.notNull(product);
        if(amount < 0)
        {
            throw new IllegalArgumentException("Amount can not be negative");
        }
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
