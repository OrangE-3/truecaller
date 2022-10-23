package com.lld.maven.truecaller.module.stores.interfaces;
import com.lld.maven.truecaller.module.entities.BlockedPhoneNumber;

public interface BlockedNumberStore {
    void addBlockedNumber(BlockedPhoneNumber blockedPhoneNumber);
    void removeBlockedNumber(String userId, String phoneNumber);
    boolean isBlocked(String userId, String phoneNumber);
}
