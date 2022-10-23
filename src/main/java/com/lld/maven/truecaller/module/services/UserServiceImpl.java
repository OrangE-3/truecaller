package com.lld.maven.truecaller.module.services;

import com.lld.maven.truecaller.module.stores.interfaces.BlockedNumberStore;
import com.lld.maven.truecaller.module.stores.interfaces.ContactStore;
import com.lld.maven.truecaller.module.stores.interfaces.NumberStore;
import com.lld.maven.truecaller.module.stores.interfaces.UserStore;
import com.lld.maven.truecaller.module.entities.BlockedPhoneNumber;
import com.lld.maven.truecaller.module.entities.Contact;
import com.lld.maven.truecaller.module.entities.PhoneNumber;
import com.lld.maven.truecaller.module.entities.User;
import com.lld.maven.truecaller.module.services.interfaces.UserService;

public class UserServiceImpl implements UserService {
    private UserStore userStore;
    private NumberStore numberStore;
    private BlockedNumberStore blockedNumberStore;
    private ContactStore contactStore;

    public UserServiceImpl(UserStore userStore,
                           NumberStore numberStore,
                           BlockedNumberStore blockedNumberStore,
                           ContactStore contactStore) {
        this.userStore = userStore;
        this.numberStore = numberStore;
        this.blockedNumberStore = blockedNumberStore;
        this.contactStore = contactStore;
    }

    @Override
    public String register(String name, String number, String email) {
        User user = new User(name,
                number,
                email,
                false,
                false,
                false);
        userStore.addUser(user);
        return user.getId();
    }

    @Override
    public void goPublic(String userId) {
        userStore.setIsPublic(userId, true);
    }

    @Override
    public void upgradeToPremium(String userId) {
        userStore.setPremium(userId, true);
    }

    @Override
    public void setSpamBlocked(String userId) {
        userStore.setIsSpamBlocked(userId, true);
    }

    @Override
    public void markAsSpam(String userId, String number) {
        if(!numberStore.hasNumber(number)){
            numberStore.addNumber(new PhoneNumber(number, 1));
        } else {
            numberStore.incrementSpamCount(number);
        }
    }

    @Override
    public void blockNumber(String userId, String number) {
        blockedNumberStore.addBlockedNumber(new BlockedPhoneNumber(userId, number));
    }

    @Override
    public void unblockNumber(String userId, String number) {
        blockedNumberStore.removeBlockedNumber(userId, number);
    }

    @Override
    public void addContact(String userId, String name, String number) {
        contactStore.addContact(new Contact(userId, name, number));
    }

    @Override
    public boolean isNumberBlocked(String userId, String number) {
        if(blockedNumberStore.isBlocked(userId, number))return true;
        else return userStore.isPremium(userId) && userStore.isSpamBlocked(userId) && numberStore.getSpamCount(number) > 2;
    }

}
