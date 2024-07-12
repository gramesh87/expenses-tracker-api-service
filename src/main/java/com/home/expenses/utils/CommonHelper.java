package com.home.expenses.utils;

import com.home.expenses.entity.User;

public class CommonHelper {


    public static User updateUserData(User dbObject, User user) {

        if (user.getId().equals(dbObject.getId())) {

            if (!user.getFirstName().equals(dbObject.getFirstName())) {
                dbObject.setFirstName(user.getFirstName());
            }

            if (!user.getLastName().equals(dbObject.getLastName())) {
                dbObject.setLastName(user.getLastName());
            }

            if (!user.getEmailId().equals(dbObject.getEmailId())) {
                dbObject.setEmailId(user.getEmailId());
            }

            return dbObject;
        }
        return null;
    }

}
