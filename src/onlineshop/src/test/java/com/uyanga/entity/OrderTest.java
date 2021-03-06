package com.uyanga.entity;

import com.uyanga.ProductListItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class OrderTest {

    @Test
    public void ordThrowsExceptionWhenCustomerIDNull()
    {
        Assertions.assertThrows(NullPointerException.class, () ->{
            List<ProductListItem> productList = new ArrayList<>();
            productList.add(new ProductListItem("pid1", 2.0));
            new Order("id1", null, productList, 5.5);
        });
    }

    @Test
    public void ordThrowsExceptionWhenCustomerIDEmpty()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            List<ProductListItem> productList = new ArrayList<>();
            productList.add(new ProductListItem("pid1", 2.0));
            new Order("id1", "", productList, 5.5);
        });
    }

    @Test
    public void ordThrowsExceptionWhenProductListNull()
    {
        Assertions.assertThrows(NullPointerException.class, () ->
                new Order("id1", "cId1", null, 5.5));
    }

    @Test
    public void ordThrowsExceptionWhenProductListEmpty()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Order("id1", "cId1", new ArrayList<ProductListItem>(), 5.5));
    }

    @Test
    public void ordThrowsExceptionWhenTotalIsNegative()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            List<ProductListItem> productList = new ArrayList<>();
            productList.add(new ProductListItem("pid1", 2.0));
            new Order("id1", "cId1", productList, -55);
        });
    }

    @Test
    public void ordCreatesInstance()
    {
        List<ProductListItem> productList = new ArrayList<>();
        productList.add(new ProductListItem("pid1", 10));
        Order order = new Order("id1", "cus1", productList, 100);

        Assertions.assertNotNull(order);
        Assertions.assertEquals("id1", order.getId());
        Assertions.assertEquals("cus1", order.getCustomerID());
        Assertions.assertEquals(productList, order.getOrders());
        Assertions.assertEquals("pid1", order.getOrders().get(0).getProductID());
        Assertions.assertEquals(10, order.getOrders().get(0).getAmount());
        Assertions.assertEquals(100.0, order.getTotal());

    }

}