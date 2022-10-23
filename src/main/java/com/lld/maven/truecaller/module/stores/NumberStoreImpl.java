package com.lld.maven.truecaller.module.stores;

import com.lld.maven.truecaller.module.entities.PhoneNumber;
import com.lld.maven.truecaller.module.stores.interfaces.NumberStore;

import java.util.HashMap;
import java.util.Map;

public class NumberStoreImpl implements NumberStore {
    Map<String, Integer> phoneNumberMap;

    public NumberStoreImpl() {
        this.phoneNumberMap = new HashMap<>();
    }

    @Override
    public void addNumber(PhoneNumber phoneNumber) {
        phoneNumberMap.putIfAbsent(phoneNumber.getNumber(), phoneNumber.getSpamCount());
    }

    @Override
    public void incrementSpamCount(String number) {
        phoneNumberMap.put(number, phoneNumberMap.get(number)+1);
    }

    @Override
    public int getSpamCount(String number) {
        return phoneNumberMap.get(number);
    }

    @Override
    public boolean hasNumber(String number) {
        return phoneNumberMap.containsKey(number);
    }
}
