package com.uyanga.entity;

import com.uyanga.ProductListItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StockTest {
    @Test
    public void sttThrowsExceptionWhenAddressNull()
    {
        Assertions.assertThrows(NullPointerException.class, () -> new Stock("id1", null));

    }

    @Test
    public void sttThrowsExceptionWhenAddressEmpty()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () ->  new Stock("id1", ""));

    }

    @Test
    public void sttCreatesInstance()
    {
        ProductListItem productListItem = new ProductListItem("productId1", 4.5);
        Stock stock = new Stock("id1", "address1");
        stock.addToProductList(productListItem);

        Assertions.assertNotNull(stock);
        Assertions.assertEquals("id1", stock.getId());
        Assertions.assertEquals("address1", stock.getAddress());
        Assertions.assertNotNull(stock.getAvailableProducts());
        Assertions.assertEquals("productId1", stock.getAvailableProducts().get(0).getProductID());

    }

}