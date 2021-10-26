package com.uyanga.useCase;

import com.uyanga.ProductListItem;
import com.uyanga.entity.Product;
import com.uyanga.entity.Stock;
import com.uyanga.repository.ProductRepository;
import com.uyanga.repository.StockRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CheckProductAmountTest {

    ProductRepository productRepository = Mockito.mock(ProductRepository.class);
    StockRepository stockRepository = Mockito.mock(StockRepository.class);

    @Test
    public void sttThrowsExceptionWhenStockRepositoryNull()
    {
        Assertions.assertThrows(NullPointerException.class, () ->
                new CheckProductAmount(null, productRepository));
    }

    @Test
    public void sttThrowsExceptionWhenProductRepositoryNull()
    {
        Assertions.assertThrows(NullPointerException.class, () ->
                new CheckProductAmount(stockRepository, null));
    }

    @Test
    public void sttThrowsExceptionWhenStockIdNull()
    {
        Assertions.assertThrows(NullPointerException.class, () ->
                new CheckProductAmount(stockRepository, productRepository).execute(null, "pId1"));
    }

    @Test
    public void sttThrowsExceptionWhenStockIdEmpty()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new CheckProductAmount(stockRepository, productRepository).execute("", "pId1"));
    }

    @Test
    public void sttThrowsExceptionWhenProductIdNull()
    {
        Assertions.assertThrows(NullPointerException.class, () ->
                new CheckProductAmount(stockRepository, productRepository).execute("sId1", null));
    }

    @Test
    public void sttThrowsExceptionWhenProductIdEmpty()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new CheckProductAmount(stockRepository, productRepository).execute("sId1", ""));
    }

    @Test
    public void sttCreatesInstance()
    {
        Mockito.when(stockRepository.findById("sId1")).thenReturn(new Stock("sId1", "test_address"));
        Mockito.when(productRepository.findById("pId1")).thenReturn(new Product("pId1", "product_name", 8.8));

        Stock stock = stockRepository.findById("sId1");
        stock.addToProductList(new ProductListItem("pId1", 100));

        double amount_test = new CheckProductAmount(stockRepository, productRepository).execute("sId1", "pId1");


        Assertions.assertNotNull(amount_test);

        Assertions.assertEquals(100, amount_test);
        Assertions.assertEquals("pId1", stock.getAvailableProducts().get(0).getProductID());
        Assertions.assertEquals(8.8, productRepository.findById(stock.getAvailableProducts().get(0).getProductID()).getPrice());
    }
}