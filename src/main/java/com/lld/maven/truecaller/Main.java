package com.lld.maven.truecaller;

import com.lld.maven.truecaller.module.stores.*;
import com.lld.maven.truecaller.module.stores.interfaces.BlockedNumberStore;
import com.lld.maven.truecaller.module.stores.interfaces.ContactStore;
import com.lld.maven.truecaller.module.stores.interfaces.NumberStore;
import com.lld.maven.truecaller.module.stores.interfaces.UserStore;
import com.lld.maven.truecaller.module.services.interfaces.SearchService;
import com.lld.maven.truecaller.module.services.SearchServiceImpl;
import com.lld.maven.truecaller.module.services.interfaces.UserService;
import com.lld.maven.truecaller.module.services.UserServiceImpl;

public class Main {
    private static UserService userService;
    private static SearchService searchService;
    public static void main(String[] args) {
        BlockedNumberStore blockedNumberStore = new BlockedNumberStoreImpl();
        ContactStore contactStore = new ContactStoreImpl();
        UserStore userStore = new UserStoreImpl();
        NumberStore numberStore = new NumberStoreImpl();
        userService = new UserServiceImpl(userStore, numberStore, blockedNumberStore, contactStore);
        searchService = new SearchServiceImpl(contactStore, userStore, numberStore);
        // Call True Caller apis.
        registerTest();
    }

    private static void registerTest(){
        String userId = userService.register("Hello", "928102", "safsaf@gmail");
        System.out.println(userId);

        String userId2 = userService.register("Hello", "928102", "safsaf@gmail");
        System.out.println(userId2);

        String userId3 = userService.register("Hellodas", "92810252345", "safsaf@gmail");
        System.out.println(userId3);

        String userId4 = userService.register("Hello4324", "9281025436", "safsaf@gmail");
        System.out.println(userId4);
    }
}
