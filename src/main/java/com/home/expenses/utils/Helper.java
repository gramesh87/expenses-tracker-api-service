package com.home.expenses.utils;

import com.home.expenses.entity.User;

public class Helper {

    public static void updateUserData(User dbObject, User user) {
        dbObject.setFirstName(user.getFirstName());
        dbObject.setLastName(user.getLastName());
        dbObject.setEmailId(user.getEmailId());
    }
}
