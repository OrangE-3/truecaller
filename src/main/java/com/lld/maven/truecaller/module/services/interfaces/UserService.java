package com.lld.maven.truecaller.module.services.interfaces;

public interface UserService {
    String register(String name, String number, String email);
    void goPublic(String userId);
    void upgradeToPremium(String userId);
    void setSpamBlocked(String userId);

    void markAsSpam(String userId, String number);
    void blockNumber(String userId, String number);
    void unblockNumber(String userId, String number);

    void addContact(String userId, String name, String number);
    boolean isNumberBlocked(String userId, String number);
}
