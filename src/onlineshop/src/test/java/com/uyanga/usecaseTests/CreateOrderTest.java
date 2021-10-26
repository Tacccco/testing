package com.uyanga.usecaseTests;

import com.uyanga.ProductListItem;
import com.uyanga.useCase.CreateOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CreateOrderTest {

    @Test
    public void ordThrowsExceptionWhenCustomerIdNull()
    {
        Assertions.assertThrows(NullPointerException.class, () ->{
            List<ProductListItem> productList = new ArrayList<>();
            productList.add(new ProductListItem("pid1", 2.0));
            new CreateOrder().execute(null, productList);
        });
    }

    @Test
    public void ordThrowsExceptionWhenCustomerIdEmpty()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            List<ProductListItem> productList = new ArrayList<>();
            productList.add(new ProductListItem("pid1", 2.0));
            new CreateOrder().execute("", productList);
        });
    }

    @Test
    public void ordThrowsExceptionWhenOrderedProductListIdNull()
    {
        Assertions.assertThrows(NullPointerException.class, () ->{
            new CreateOrder().execute("cID", null);
        });
    }

    @Test
    public void ordThrowsExceptionWhenOrderedProductListIdEmpty()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            List<ProductListItem> productList = new ArrayList<>();
            new CreateOrder().execute("cID", productList);
        });
    }

}