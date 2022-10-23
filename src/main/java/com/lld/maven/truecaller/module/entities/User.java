package com.lld.maven.truecaller.module.entities;

public class User {
    private String id;
    private String name;
    private String phoneNumber;
    private String email;
    private boolean isPremium;
    private boolean isPublic;
    private boolean isSpamBlocked;

    public User(String name, String phoneNumber, String email, boolean isPremium, boolean isPublic, boolean isSpamBlocked) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.isPremium = isPremium;
        this.isPublic = isPublic;
        this.isSpamBlocked = isSpamBlocked;
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

    public void setPremium(boolean premium) {
        isPremium = premium;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public void setSpamBlocked(boolean spamBlocked) {
        isSpamBlocked = spamBlocked;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public String getEmail() {
        return email;
    }

    public boolean isSpamBlocked() {
        return isSpamBlocked;
    }

    public boolean isPremium() {
        return isPremium;
    }
}
