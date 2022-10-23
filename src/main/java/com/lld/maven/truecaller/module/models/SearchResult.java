package com.lld.maven.truecaller.module.models;

public class SearchResult {
    private String name;
    private String number;
    private int spamCount;

    public SearchResult(String name, String number, int spamCount) {
        this.name = name;
        this.number = number;
        this.spamCount = spamCount;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public int getSpamCount() {
        return spamCount;
    }
}
