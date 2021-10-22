package com.uyanga;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CreateOrderTest {

    @Test
    public void ctrThrowsExceptionWhenCustomerNull()
    {
        Assertions.assertThrows(NullPointerException.class, () ->
                new CreateOrder("order1",null));
    }

    @Test
    public void ctrThrowsExceptionWhenOrderIDNull()
    {
        Assertions.assertThrows(NullPointerException.class, () ->{
            Customer customer = new Customer("cus1", "name", "2222");
            new CreateOrder(null,customer);
        });
    }

    @Test
    public void ctrThrowsExceptionWhenOrderIDEmpty()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            Customer customer = new Customer("cus1", "name", "2222");
            new CreateOrder("",customer);
        });
    }

    @Test
    public void ctrCreatesInstance()
    {
        Customer customer = new Customer("cus1", "name", "2222");
        CreateOrder createOrder = new CreateOrder("order1",customer);

        Assertions.assertNotNull(createOrder);
        Assertions.assertEquals("order1", createOrder.getOrder().getId());
        Assertions.assertEquals(customer, createOrder.getCustomer().getId());
        Assertions.assertNotNull(createOrder.getProductList());

    }

}