package com.uyanga.useCase;

import com.uyanga.ProductListItem;
import com.uyanga.entity.Order;
import com.uyanga.repository.CustomerRepository;
import com.uyanga.repository.ProductRepository;
import com.uyanga.repository.StockRepository;
import com.uyanga.useCase.CreateOrder;
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
    public void ordThrowsExceptionWhenCustomerIdNull()
    {
        Assertions.assertThrows(NullPointerException.class, () ->{
            List<ProductListItem> productList = new ArrayList<>();
            productList.add(new ProductListItem("pid1", 2.0));
            new CreateOrder(customerRepository, productRepository).execute(null, productList);
        });
    }

    @Test
    public void ordThrowsExceptionWhenCustomerIdEmpty()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            List<ProductListItem> productList = new ArrayList<>();
            productList.add(new ProductListItem("pid1", 2.0));
            new CreateOrder(customerRepository, productRepository).execute("", productList);
        });
    }

    @Test
    public void ordThrowsExceptionWhenOrderedProductListIdNull()
    {
        Assertions.assertThrows(NullPointerException.class, () ->{
            new CreateOrder(customerRepository, productRepository).execute("cID", null);
        });
    }

    @Test
    public void ordThrowsExceptionWhenOrderedProductListIdEmpty()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            List<ProductListItem> productList = new ArrayList<>();
            new CreateOrder(customerRepository, productRepository).execute("cID", productList);
        });
    }

    @Test
    public void ordCreatesInstance()
    {
        List<ProductListItem> productList = new ArrayList<>();
        productList.add(new ProductListItem("pid1", 10));
        Order order = new CreateOrder(customerRepository, productRepository).execute("cus1", productList);

        Assertions.assertNotNull(order);
        Assertions.assertNotNull(order.getId());

        Assertions.assertEquals("cus1", order.getCustomerID());
        Assertions.assertEquals(productList, order.getOrders());
        Assertions.assertEquals("pid1", order.getOrders().get(0).getProductID());
        Assertions.assertEquals(10, order.getOrders().get(0).getAmount());

    }

}