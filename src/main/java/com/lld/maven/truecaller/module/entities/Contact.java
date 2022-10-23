package com.lld.maven.truecaller.module.entities;

public class Contact {
    private String id;
    private String userId;
    private String name;
    private String phoneNumber;

    public Contact(String userId, String name, String phoneNumber) {
        this.userId = userId;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getUserId() {
        return userId;
    }
}
