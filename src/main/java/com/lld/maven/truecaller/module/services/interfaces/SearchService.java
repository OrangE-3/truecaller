package com.lld.maven.truecaller.module.services.interfaces;

import com.lld.maven.truecaller.module.models.SearchResult;

import java.util.List;

public interface SearchService {
    SearchResult getContactByName(String userId, String name);
    SearchResult getContactByNumber(String userId, String number);
    List<SearchResult> getUserContacts(String userId);

    List<SearchResult> getPublicContacts();
    SearchResult getPublicContactByNumber(String number);
    SearchResult getPublicUserByName(String name);
}
