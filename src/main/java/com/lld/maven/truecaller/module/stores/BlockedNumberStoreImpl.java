package com.lld.maven.truecaller.module.stores;

import com.lld.maven.truecaller.module.entities.BlockedPhoneNumber;
import com.lld.maven.truecaller.module.stores.interfaces.BlockedNumberStore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BlockedNumberStoreImpl implements BlockedNumberStore {
    Map<String, BlockedPhoneNumber> blockedPhoneNumberMap;

    public BlockedNumberStoreImpl() {
        this.blockedPhoneNumberMap = new HashMap<>();
    }

    @Override
    public void addBlockedNumber(BlockedPhoneNumber blockedPhoneNumber) {
        blockedPhoneNumber.setId(generateUniqueId(blockedPhoneNumber));
        blockedPhoneNumberMap.putIfAbsent(blockedPhoneNumber.getId(), blockedPhoneNumber);
    }

    @Override
    public void removeBlockedNumber(String userId, String phoneNumber) {
        for(Map.Entry<String, BlockedPhoneNumber> u : blockedPhoneNumberMap.entrySet()){
            if(Objects.equals(u.getValue().getPhoneNumber(), phoneNumber) && Objects.equals(u.getValue().getUserId(), userId)){
                blockedPhoneNumberMap.remove(u.getKey());
                break;
            }
        }
    }

    @Override
    public boolean isBlocked(String userId, String phoneNumber) {
        for(Map.Entry<String, BlockedPhoneNumber> u : blockedPhoneNumberMap.entrySet()){
            if(Objects.equals(u.getValue().getPhoneNumber(), phoneNumber) && Objects.equals(u.getValue().getUserId(), userId)){
                return true;
            }
        }
        return false;
    }

    private String generateUniqueId(BlockedPhoneNumber blockedPhoneNumber){
        for(BlockedPhoneNumber u : blockedPhoneNumberMap.values()){
            if(Objects.equals(u.getPhoneNumber(), blockedPhoneNumber.getPhoneNumber()) && Objects.equals(u.getUserId(), blockedPhoneNumber.getUserId()))return u.getId();
        }
        return String.valueOf(blockedPhoneNumberMap.size());
    }
}
