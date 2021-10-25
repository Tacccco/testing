package com.uyanga;

import org.apache.commons.lang3.Validate;

public class CreateOrder {
    private final Product product;
    private double quantity;

    public CreateOrder(Product product, double quantity) {
        this.product = Validate.notNull(product);
        if (quantity <= 0)
        {
            throw new IllegalArgumentException("Negative quantity is not allowed!") ;
        }
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
