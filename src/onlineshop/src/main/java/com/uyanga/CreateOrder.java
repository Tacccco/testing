package com.uyanga;

import org.apache.commons.lang3.Validate;

import java.awt.color.ProfileDataException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateOrder {
    private final Order order;
    private final Customer customer;
    private List<Product> productList;

    public CreateOrder(String orderId, Customer customer)
    {
        this.customer = Validate.notNull(customer);
        createProductList();
        order = new Order(Validate.notBlank(orderId), customer.getId(), productList);
    }

    public Order getOrder() {
        return order;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Product> getProductList() {
        return productList;
    }

    private void createProductList()
    {
        productList = new ArrayList<>();
        String state = "";
        Scanner sc = new Scanner(System.in);

        Product product;
        String productID;

        while (state != "done")
        {
            productID =
            product = new Product()
            state = sc.nextLine();
        }
    }
}
