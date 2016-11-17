package com.burritomatic.pos.model;


import java.io.Serializable;

public class Customer implements Serializable{
    private String name;
    private String contactNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
