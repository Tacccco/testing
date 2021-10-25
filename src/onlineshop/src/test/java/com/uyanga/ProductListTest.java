package com.uyanga;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductListTest {

    @Test
    public void ctrThrowsExceptionWhenProductNull()
    {
        Assertions.assertThrows(NullPointerException.class, () ->
                new ProductListItem(null,5.5));
    }

    @Test
    public void ctrThrowsExceptionWhenAmountNegative()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new CreateOrder(new Product("pid1", "productName", 55), -11.0));
    }

    @Test
    public void ctrCreatesInstance()
    {
        Product product = new Product("pid1", "productName", 55);
        ProductListItem productItem= new ProductListItem(product, 200.0);

        Assertions.assertNotNull(productItem);
        Assertions.assertNotNull(productItem.getProduct());
        Assertions.assertEquals(product, productItem.getProduct());
        Assertions.assertEquals("pid1", productItem.getProduct().getId());
        Assertions.assertEquals("productName", productItem.getProduct().getName());
        Assertions.assertEquals(55, productItem.getProduct().getPrice());
        Assertions.assertEquals(200, productItem.getAmount());

    }

}