package com.lld.maven.truecaller.module.stores;

import com.lld.maven.truecaller.module.entities.Contact;
import com.lld.maven.truecaller.module.stores.interfaces.ContactStore;

import java.util.*;

public class ContactStoreImpl implements ContactStore {
    Map<String, Contact> contactMap;

    public ContactStoreImpl() {
        this.contactMap = new HashMap<>();
    }

    @Override
    public void addContact(Contact contact) {
        contact.setId(generateUniqueId(contact));
        contactMap.putIfAbsent(contact.getId(), contact);
    }

    @Override
    public Contact getContactByName(String userId, String name) {
        for(Contact contact : contactMap.values()){
            if(Objects.equals(contact.getName(), name) && Objects.equals(contact.getUserId(), userId))return contact;
        }
        return null;
    }

    @Override
    public Contact getContactByNumber(String userId, String number) {
        for(Contact contact : contactMap.values()){
            if(Objects.equals(contact.getPhoneNumber(), number) && Objects.equals(contact.getUserId(), userId))return contact;
        }
        return null;
    }

    @Override
    public List<Contact> getLocalContacts(String userId) {
        List<Contact> result = new ArrayList<>();
        for(Contact contact : contactMap.values()){
            if(Objects.equals(contact.getUserId(), userId))result.add(contact);
        }
        return result;
    }

    private String generateUniqueId(Contact contact){
        for(Contact u : contactMap.values()){
            if(Objects.equals(u.getName(), contact.getName()) && Objects.equals(u.getPhoneNumber(), contact.getPhoneNumber()) && Objects.equals(u.getUserId(), contact.getUserId()))return u.getId();
        }
        return String.valueOf(contactMap.size());
    }
}
