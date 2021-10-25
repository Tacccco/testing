package com.uyanga;

import org.apache.commons.lang3.Validate;
import java.util.List;

public class Order extends Entity{
    private final String customerID;
    private final List<ProductListItem> orders;
    private double total;

    public Order(String id, String customerID, List<ProductListItem> orders)
    {
        super(id);
        this.customerID = Validate.notBlank(customerID);
        this.orders = Validate.notEmpty(orders);
        this.total = calculateTotal();
    }

    private double calculateTotal()
    {
        double total = 0;
        for(ProductListItem p : orders)
        {
            total += p.getProduct().getPrice() * p.getAmount();
        }
        return total;
    }

    public String getCustomerID() {
        return customerID;
    }

    public List<ProductListItem> getOrders() {
        return orders;
    }

    public double getTotal() {
        return total;
    }
}
