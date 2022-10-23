package com.lld.maven.truecaller.module.services;

import com.lld.maven.truecaller.module.stores.interfaces.ContactStore;
import com.lld.maven.truecaller.module.stores.interfaces.NumberStore;
import com.lld.maven.truecaller.module.stores.interfaces.UserStore;
import com.lld.maven.truecaller.module.entities.Contact;
import com.lld.maven.truecaller.module.entities.User;
import com.lld.maven.truecaller.module.models.SearchResult;
import com.lld.maven.truecaller.module.services.interfaces.SearchService;

import java.util.ArrayList;
import java.util.List;

public class SearchServiceImpl implements SearchService {
    private ContactStore contactStore;
    private UserStore userStore;
    private NumberStore numberStore;

    public SearchServiceImpl(ContactStore contactStore, UserStore userStore, NumberStore numberStore) {
        this.contactStore = contactStore;
        this.userStore = userStore;
        this.numberStore = numberStore;
    }

    @Override
    public SearchResult getContactByName(String userId, String name) {
        Contact contact = contactStore.getContactByName(userId, name);
        String number = contact.getPhoneNumber();
        return new SearchResult(name, number, numberStore.getSpamCount(number));
    }

    @Override
    public SearchResult getContactByNumber(String userId, String number) {
        Contact contact = contactStore.getContactByNumber(userId, number);
        return new SearchResult(contact.getName(), number, numberStore.getSpamCount(number));
    }

    @Override
    public List<SearchResult> getUserContacts(String userId) {
        List<SearchResult> result = new ArrayList<>();
        for(Contact contact : contactStore.getLocalContacts(userId)){
            String number = contact.getPhoneNumber();
            result.add(new SearchResult(contact.getName(), number, numberStore.getSpamCount(number)));
        }
        return result;
    }

    @Override
    public List<SearchResult> getPublicContacts() {
        List<SearchResult> result = new ArrayList<>();
        for(User user : userStore.getPublicUsers()){
            String number = user.getPhoneNumber();
            result.add(new SearchResult(user.getName(), number, numberStore.getSpamCount(number)));
        }
        return result;
    }

    @Override
    public SearchResult getPublicContactByNumber(String number) {
        User user = userStore.getPublicUserByNumber(number);
        return new SearchResult(user.getName(), number, numberStore.getSpamCount(number));
    }

    @Override
    public SearchResult getPublicUserByName(String name) {
        User user = userStore.getPublicUserByName(name);
        String number = user.getPhoneNumber();
        return new SearchResult(user.getName(),number, numberStore.getSpamCount(number));
    }
}
