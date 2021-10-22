package com.uyanga;

import org.apache.commons.lang3.Validate;

public class Customer extends Entity{
    private final String name;
    private String address;
    private final String phoneNumber;

    public Customer(String id, String name, String phoneNumber) {
        super(id);
        this.name = Validate.notBlank(name);
        this.phoneNumber = Validate.notBlank(phoneNumber);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
