package com.uyanga.useCase;

import com.uyanga.entity.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CreateCustomerTest {

    @Test
    public void ordThrowsExceptionWhenCustomerNameNull()
    {
        Assertions.assertThrows(NullPointerException.class, () ->
                new CreateCustomer().execute(null, "8888"));
    }

    @Test
    public void ordThrowsExceptionWhenCustomerNameEmpty()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new CreateCustomer().execute("", "8888"));
    }

    @Test
    public void ordThrowsExceptionWhenCustomerPhoneNull()
    {
        Assertions.assertThrows(NullPointerException.class, () ->
                new CreateCustomer().execute("cID", null));
    }

    @Test
    public void ordThrowsExceptionWhenCustomerPhoneEmpty()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new CreateCustomer().execute("cID", ""));
    }

    @Test
    public void ordThrowsExceptionWhenCustomerPhoneNumIncludeChar()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new CreateCustomer().execute("cID", "887h"));
    }

    @Test
    public void ordThrowsExceptionWhenCustomerPhoneNumShorterThan8()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new CreateCustomer().execute("cID", "887"));
    }

    @Test
    public void ordThrowsExceptionWhenCustomerPhoneNumLongerThan8()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new CreateCustomer().execute("cID", "888888888"));
    }

    @Test
    public void ordCreatesInstance()
    {
        Customer customer = new CreateCustomer().execute("TestName", "99999999");

        Assertions.assertNotNull(customer);
        Assertions.assertNotNull(customer.getId());

        Assertions.assertEquals("TestName", customer.getName());
        Assertions.assertEquals("99999999", customer.getPhoneNumber());

    }
}