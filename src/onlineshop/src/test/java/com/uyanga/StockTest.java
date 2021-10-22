package com.uyanga;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StockTest {
    @Test
    public void ctrThrowsExceptionWhenAddressNull()
    {
        Assertions.assertThrows(NullPointerException.class, () -> new Stock("id1", null));

    }

    @Test
    public void ctrThrowsExceptionWhenIdEmpty()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () ->  new Stock("id1", ""));

    }

    @Test
    public void ctrCreatesInstance()
    {
        Stock stock = new Stock("id1", "address1");

        Assertions.assertNotNull(stock);
        Assertions.assertEquals("id1", stock.getId());
        Assertions.assertEquals("address1", stock.getAddress());

    }

}