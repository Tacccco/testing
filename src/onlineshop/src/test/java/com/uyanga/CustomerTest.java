package com.uyanga;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CustomerTest {

    @Test
    public void ctrThrowsExceptionWhenNameNull()
    {
        Assertions.assertThrows(NullPointerException.class, () ->
                new Customer("id1", null, "0555"));
    }

    @Test
    public void ctrThrowsExceptionWhenNameEmpty()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Customer("id1", "", "55"));

    }

    @Test
    public void ctrThrowsExceptionWhenPhoneNumberNull()
    {
        Assertions.assertThrows(NullPointerException.class, () ->
                new Customer("id1", "null", null));
    }

    @Test
    public void ctrThrowsExceptionWhenPhoneNumberEmpty()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Customer("id1", "name", ""));

    }

    @Test
    public void ctrCreatesInstance()
    {
        Customer customer = new Customer("id1", "name", "55");

        Assertions.assertNotNull(customer);
        Assertions.assertEquals("id1", customer.getId());
        Assertions.assertEquals("name", customer.getName());
        Assertions.assertEquals("55", customer.getPhoneNumber());

    }

}