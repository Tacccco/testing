package com.uyanga.useCase;

import com.uyanga.ProductListItem;
import com.uyanga.entity.Customer;
import com.uyanga.entity.Order;
import com.uyanga.entity.Product;
import com.uyanga.entity.Stock;
import com.uyanga.repository.CustomerRepository;
import com.uyanga.repository.ProductRepository;
import com.uyanga.repository.StockRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

class CreateOrderTest {

    CustomerRepository customerRepository = Mockito.mock(CustomerRepository.class);
    ProductRepository productRepository = Mockito.mock(ProductRepository.class);
    StockRepository stockRepository = Mockito.mock(StockRepository.class);

    @Test
    public void ordcrtThrowsExceptionWhenCustomerRepositoryNull()
    {
        Assertions.assertThrows(NullPointerException.class, () ->
                new CreateOrder(null, productRepository, stockRepository));
    }

    @Test
    public void ordcrtThrowsExceptionWhenProductRepositoryNull()
    {
        Assertions.assertThrows(NullPointerException.class, () ->
                new CreateOrder(customerRepository, null, stockRepository));
    }

    @Test
    public void ordcrtThrowsExceptionWhenStockRepositoryNull()
    {
        Assertions.assertThrows(NullPointerException.class, () ->
                new CreateOrder(customerRepository, productRepository, null));
    }

    @Test
    public void ordcrtThrowsExceptionWhenCustomerIdNull()
    {
        Assertions.assertThrows(NullPointerException.class, () ->{
            List<ProductListItem> productList = new ArrayList<>();
            productList.add(new ProductListItem("pid1", 2.0));
            new CreateOrder(customerRepository, productRepository, stockRepository).execute(null, productList);
        });
    }

    @Test
    public void ordcrtThrowsExceptionWhenCustomerIdEmpty()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            List<ProductListItem> productList = new ArrayList<>();
            productList.add(new ProductListItem("pid1", 2.0));
            new CreateOrder(customerRepository, productRepository, stockRepository).execute("", productList);
        });
    }

    @Test
    public void ordcrtThrowsExceptionWhenCustomerIdNotValid()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            Mockito.when(productRepository.findById("pId1")).thenReturn(new Product("pId1", "product_name", 8.8));
            Mockito.when(customerRepository.findById("cId1")).thenReturn(new Customer("cId1", "customerName", "99999999"));
            Mockito.when(stockRepository.findById("sId1")).thenReturn(new Stock("sId1", "address_test"));

            List<ProductListItem> productList = new ArrayList<>();
            productList.add(new ProductListItem("pId1", 2.0));
            new CreateOrder(customerRepository, productRepository, stockRepository).execute("cId2", productList);
        });
    }

    @Test
    public void ordcrtThrowsExceptionWhenProductIdNotValid()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            Mockito.when(productRepository.findById("pId1")).thenReturn(new Product("pId1", "product_name", 8.8));
            Mockito.when(customerRepository.findById("cId1")).thenReturn(new Customer("cId1", "customerName", "99999999"));
            Mockito.when(stockRepository.findById("sId1")).thenReturn(new Stock("sId1", "address_test"));

            List<ProductListItem> productList = new ArrayList<>();
            productList.add(new ProductListItem("pId2", 2.0));
            new CreateOrder(customerRepository, productRepository, stockRepository).execute("cId1", productList);
        });
    }

    @Test
    public void ordcrtThrowsExceptionWhenProductAmountNotValid()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            Mockito.when(productRepository.findById("pId1")).thenReturn(new Product("pId1", "product_name", 8.8));
            Mockito.when(customerRepository.findById("cId1")).thenReturn(new Customer("cId1", "customerName", "99999999"));
            Mockito.when(stockRepository.findById("sId1")).thenReturn(new Stock("sId1", "address_test"));

            Stock stock = stockRepository.findById("sId1");
            stock.addToProductList(new ProductListItem("pId1", 1.5));
            List<ProductListItem> productList = new ArrayList<>();
            productList.add(new ProductListItem("pId1", 2.0));
            new CreateOrder(customerRepository, productRepository, stockRepository).execute("cId1", productList);
        });
    }

    @Test
    public void ordcrtThrowsExceptionWhenOrderedProductListIdNull()
    {
        Assertions.assertThrows(NullPointerException.class, () ->
                new CreateOrder(customerRepository, productRepository, stockRepository).execute("cID", null));
    }

    @Test
    public void ordcrtThrowsExceptionWhenOrderedProductListIdEmpty()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            List<ProductListItem> productList = new ArrayList<>();
            new CreateOrder(customerRepository, productRepository, stockRepository).execute("cID", productList);
        });
    }

    @Test
    public void ordcrtCreatesInstance()
    {
        Mockito.when(productRepository.findById("pId1")).thenReturn(new Product("pId1", "product_name", 8.8));
        Mockito.when(customerRepository.findById("cId1")).thenReturn(new Customer("cId1", "customerName", "99999999"));
        Mockito.when(stockRepository.findById("sId1")).thenReturn(new Stock("sId1", "address_test"));

        Stock stock = stockRepository.findById("sId1");
        stock.addToProductList(new ProductListItem("pId1", 15));

        List<ProductListItem> productList = new ArrayList<>();
        productList.add(new ProductListItem("pId1", 2.0));

        Order order =  new CreateOrder(customerRepository, productRepository, stockRepository).execute("cId1", productList);

        Assertions.assertNotNull(order);
        Assertions.assertNotNull(order.getId());

        Assertions.assertEquals("cId1", order.getCustomerID());
        Assertions.assertEquals(productList, order.getOrders());
        Assertions.assertEquals("pId1", order.getOrders().get(0).getProductID());
        Assertions.assertEquals(2, order.getOrders().get(0).getAmount());
        Assertions.assertEquals(17.6, order.getTotal());

    }

}