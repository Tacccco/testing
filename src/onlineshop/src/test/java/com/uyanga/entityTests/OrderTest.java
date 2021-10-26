package com.uyanga.entityTests;

import com.uyanga.ProductListItem;
import com.uyanga.entity.Order;
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
            new Order("id1", null, productList);
        });
    }

    @Test
    public void ordThrowsExceptionWhenCustomerIDEmpty()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            List<ProductListItem> productList = new ArrayList<>();
            productList.add(new ProductListItem("pid1", 2.0));
            new Order("id1", "", productList);
        });
    }

    @Test
    public void ordThrowsExceptionWhenProductListNull()
    {
        Assertions.assertThrows(NullPointerException.class, () ->
                new Order("id1", "cId1", null));
    }

    @Test
    public void ordCreatesInstance()
    {
        List<ProductListItem> productList = new ArrayList<>();
        productList.add(new ProductListItem("pid1", 10));
        Order order = new Order("id1", "cus1", productList);

        Assertions.assertNotNull(order);
        Assertions.assertEquals("id1", order.getId());
        Assertions.assertEquals("cus1", order.getCustomerID());
        Assertions.assertEquals(productList, order.getOrders());
        Assertions.assertEquals("pid1", order.getOrders().get(0).getProductID());
        Assertions.assertEquals(10, order.getOrders().get(0).getAmount());
//        Assertions.assertEquals(550.0, order.getTotal());

    }

}