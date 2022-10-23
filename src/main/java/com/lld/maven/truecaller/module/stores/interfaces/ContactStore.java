package com.lld.maven.truecaller.module.stores.interfaces;

import com.lld.maven.truecaller.module.entities.Contact;

import java.util.List;

public interface ContactStore {
    void addContact(Contact contact);
    Contact getContactByName(String userId, String name);
    Contact getContactByNumber(String userId, String number);
    List<Contact> getLocalContacts(String userId);
}
