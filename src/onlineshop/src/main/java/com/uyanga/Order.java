package com.uyanga;

import org.apache.commons.lang3.Validate;
import java.util.List;

public class Order extends Entity{
    private final String customerID;
    private final List<Product> products;
    private double total;



    public Order(String id, String customerID, List<Product> products)
    {
        super(id);
        this.customerID = Validate.notBlank(customerID);
        this.products = Validate.notEmpty(products);
        this.total = calculateTotal();
    }

    private double calculateTotal()
    {
        double total = 0;
        for(Product p : products)
        {
            total += p.getPrice();
        }
        return total;
    }

    public String getCustomerID() {
        return customerID;
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getTotal() {
        return total;
    }
}
