package com.lld.maven.truecaller.module.stores.interfaces;

import com.lld.maven.truecaller.module.entities.PhoneNumber;

public interface NumberStore {
    void addNumber(PhoneNumber phoneNumber);
    void incrementSpamCount(String number);
    int getSpamCount(String number);
    boolean hasNumber(String number);
}
