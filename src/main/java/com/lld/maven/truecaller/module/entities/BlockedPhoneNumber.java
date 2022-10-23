package com.lld.maven.truecaller.module.entities;

public class BlockedPhoneNumber {
    private String id;
    private String userId;
    private String phoneNumber;

    public BlockedPhoneNumber(String userId, String phoneNumber) {
        this.userId = userId;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
