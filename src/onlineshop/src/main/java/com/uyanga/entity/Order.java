package com.uyanga.entity;

import com.uyanga.ProductListItem;
import org.apache.commons.lang3.Validate;
import java.util.List;

public class Order extends Entity{
    private final String customerID;
    private final List<ProductListItem> orders;
    private double total;

    public Order(String id, String customerID, List<ProductListItem> orders, double total)
    {
        super(id);
        this.customerID = Validate.notBlank(customerID);
        this.orders = Validate.notEmpty(orders);
        Validate.notNull(total);
        if (total < 0)
        {
            throw new IllegalArgumentException("Total can not be Negative!");
        }
        this.total = total;
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
