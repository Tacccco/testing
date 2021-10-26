package com.uyanga.repository;

import com.uyanga.entity.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductRepository {
    private Map<String, Product> products = new HashMap<>();

    public ProductRepository()
    {
        this.products.put("pId1", new Product("pId1", "ProductName1", 88.8));
        this.products.put("pId2", new Product("pId2", "ProductName2", 99.9));
        this.products.put("pId3", new Product("pId3", "ProductName3", 12.5));
    }

    public Product findById(String productId)
    {
        if (this.products.keySet().contains(productId))
        {
            return this.products.get(productId);
        }
        else
        {
            return null;
        }
    }
}
