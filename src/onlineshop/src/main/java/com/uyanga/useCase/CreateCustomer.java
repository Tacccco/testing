package com.uyanga.useCase;

import com.uyanga.entity.Customer;
import org.apache.commons.lang3.Validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateCustomer {

    public Customer execute(String name, String phoneNumber)
    {
        Validate.notBlank(name);
        Validate.notBlank(phoneNumber);

        if(!isValid(phoneNumber))
        {
            throw new IllegalArgumentException("Phone number must include 8 digits!") ;
        }

        return new Customer("cId1", name, phoneNumber);
    }

    public static boolean isValid(String phone)
    {
        Pattern p = Pattern.compile("^\\d{8}$");
        Matcher m = p.matcher(phone);

        return (m.matches());
    }
}
