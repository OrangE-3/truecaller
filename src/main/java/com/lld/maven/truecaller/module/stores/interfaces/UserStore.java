package com.lld.maven.truecaller.module.stores.interfaces;

import com.lld.maven.truecaller.module.entities.User;

import java.util.List;

public interface UserStore {
    void addUser(User user);
    void setPremium(String userId, boolean bool);
    void setIsSpamBlocked(String userId, boolean bool);
    void setIsPublic(String userId, boolean bool);
    boolean isSpamBlocked(String userId);
    boolean isPremium(String userId);
    List<User> getPublicUsers();
    User getPublicUserByNumber(String number);
    User getPublicUserByName(String name);
}
