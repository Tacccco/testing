package com.uyanga;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductTest {

    @Test
    public void ctrThrowsExceptionWhenNameNull()
    {
        Assertions.assertThrows(NullPointerException.class, () ->
                new Product("id1", null, 55));
    }

    @Test
    public void ctrThrowsExceptionWhenNameEmpty()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Product("id1", "", 55));

    }

    @Test
    public void ctrThrowsExceptionWhenPriceNegative()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Product("id1", "null", -55));
    }

    @Test
    public void ctrCreatesInstance()
    {
        Product product = new Product("id1", "ProductName", 55);

        Assertions.assertNotNull(product);
        Assertions.assertEquals("id1", product.getId());
        Assertions.assertEquals("ProductName", product.getName());
        Assertions.assertEquals(55, product.getPrice());

    }
}