package com.uyanga;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductListTest {

    @Test
    public void pltThrowsExceptionWhenProductIdNull()
    {
        Assertions.assertThrows(NullPointerException.class, () ->
                new ProductListItem(null,5.5));
    }

    @Test
    public void pltThrowsExceptionWhenProductIdEmpty()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new ProductListItem("",5.5));
    }

    @Test
    public void pltThrowsExceptionWhenAmountNegative()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new ProductListItem("pid", -11.0));
    }

    @Test
    public void pltCreatesInstance()
    {
        ProductListItem productItem= new ProductListItem("pid1", 200.0);

        Assertions.assertNotNull(productItem);
        Assertions.assertNotNull(productItem.getProductID());
        Assertions.assertEquals("pid1", productItem.getProductID());
        Assertions.assertEquals(200, productItem.getAmount());

    }

}