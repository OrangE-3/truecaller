package com.lld.maven.truecaller.module.stores;

import com.lld.maven.truecaller.module.entities.User;
import com.lld.maven.truecaller.module.stores.interfaces.UserStore;

import java.util.*;

public class UserStoreImpl implements UserStore {
    Map<String, User> users;

    public UserStoreImpl() {
        this.users = new HashMap<>();
    }

    @Override
    public void addUser(User user) {
        user.setId(generateUniqueId(user));
        users.putIfAbsent(user.getId(), user);
    }

    @Override
    public void setPremium(String userId, boolean bool) {
        users.get(userId).setPremium(bool);
    }

    @Override
    public void setIsSpamBlocked(String userId, boolean bool) {
        users.get(userId).setSpamBlocked(bool);
    }

    @Override
    public void setIsPublic(String userId, boolean bool) {
        users.get(userId).setPublic(bool);
    }

    @Override
    public boolean isSpamBlocked(String userId) {
        return users.get(userId).isSpamBlocked();
    }

    @Override
    public boolean isPremium(String userId) {
        return users.get(userId).isPremium();
    }

    @Override
    public List<User> getPublicUsers() {
        List<User> result = new ArrayList<>();
        for(User user : users.values()){
            if(user.isPublic())result.add(user);
        }
        return result;
    }

    @Override
    public User getPublicUserByNumber(String number) {
        for(User user : users.values()){
            if(Objects.equals(user.getPhoneNumber(), number))return user;
        }
        return null;
    }

    @Override
    public User getPublicUserByName(String name) {
        for(User user : users.values()){
            if(Objects.equals(user.getName(), name))return user;
        }
        return null;
    }

    private String generateUniqueId(User user){
        for(User u : users.values()){
            if(Objects.equals(u.getName(), user.getName()) && Objects.equals(u.getEmail(), user.getEmail()))return u.getId();
        }
        return String.valueOf(users.size());
    }
}
