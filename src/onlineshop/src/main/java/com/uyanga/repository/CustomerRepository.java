package com.uyanga.repository;

import com.uyanga.entity.Customer;

import java.util.HashMap;
import java.util.Map;

public class CustomerRepository {
    private Map<String, Customer> customers = new HashMap<>();

    public CustomerRepository()
    {
        this.customers.put("cId1", new Customer("cId1", "CustomerName1", "99999999"));
        this.customers.put("cId2", new Customer("cId2", "CustomerName2", "88888888"));
        this.customers.put("cId3", new Customer("cId3", "CustomerName3", "77777777"));
    }

    public Customer findById(String customerId)
    {
        if (this.customers.keySet().contains(customerId))
        {
            return this.customers.get(customerId);
        }
        else
        {
            return null;
        }
    }
}
