package com.lld.maven.truecaller.module.entities;

public class PhoneNumber {
    private String number;
    private int spamCount;

    public PhoneNumber(String number, int spamCount) {
        this.number = number;
        this.spamCount = spamCount;
    }

    public String getNumber() {
        return number;
    }

    public int getSpamCount() {
        return spamCount;
    }

}
