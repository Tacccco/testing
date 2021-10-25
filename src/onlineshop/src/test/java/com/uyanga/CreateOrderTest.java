package com.uyanga;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CreateOrderTest {

    @Test
    public void ctrThrowsExceptionWhenProductNull()
    {
        Assertions.assertThrows(NullPointerException.class, () ->
                new CreateOrder(null,5.5));
    }

    @Test
    public void ctrThrowsExceptionWhenQuantityNegative()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new CreateOrder(new Product("pid1", "productName", 55), -11.0));
    }

    @Test
    public void ctrThrowsExceptionWhenQuantityEquals0()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new CreateOrder(new Product("pid1", "productName", 55), 0.0));
    }

    @Test
    public void ctrCreatesInstance()
    {
        Product product = new Product("pid1", "productName", 55);
        CreateOrder createOrder = new CreateOrder(product, 2.0);

        Assertions.assertNotNull(createOrder);
        Assertions.assertNotNull(createOrder.getProduct());
        Assertions.assertEquals(product, createOrder.getProduct());
        Assertions.assertEquals("pid1", createOrder.getProduct().getId());
        Assertions.assertEquals("productName", createOrder.getProduct().getName());
        Assertions.assertEquals(55, createOrder.getProduct().getPrice());
        Assertions.assertEquals(2.0, createOrder.getQuantity());

    }

}