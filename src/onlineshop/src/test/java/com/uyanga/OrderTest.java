package com.uyanga;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class OrderTest {

    @Test
    public void ctrThrowsExceptionWhenCustomerIDNull()
    {
        Assertions.assertThrows(NullPointerException.class, () ->{
            List<Product> productList = new ArrayList<>();
            productList.add(new Product("pid1", "productName", 55));
            new Order("id1", null, productList);
        });
    }

    @Test
    public void ctrThrowsExceptionWhenCustomerIDEmpty()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            List<Product> productList = new ArrayList<>();
            productList.add(new Product("pid1", "productName", 55));
            new Order("id1", "", productList);
        });
    }

    @Test
    public void ctrThrowsExceptionWhenProductListEmpty()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            new Order("id1", "", null);
        });
    }

    @Test
    public void ctrCreatesInstance()
    {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("pid1", "productName", 55));
        Order order = new Order("id1", "cus1", productList);

        Assertions.assertNotNull(order);
        Assertions.assertEquals("id1", order.getId());
        Assertions.assertEquals("cus1", order.getCustomerID());
        Assertions.assertEquals(productList, order.getProducts());
        Assertions.assertEquals(55, order.getTotal());

    }

}