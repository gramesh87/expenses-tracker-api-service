package com.home.expenses.utils;

import com.home.expenses.entity.Category;
import com.home.expenses.entity.PaymentMode;
import com.home.expenses.entity.User;
import com.home.expenses.exceptions.InvalidDataException;
import org.springframework.stereotype.Component;

@Component
public class Validator {

    public static final String EMAIL_VALIDATION_PATTERN = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

    public boolean paymentMode(PaymentMode paymentMode) {
        return !Utils.emptyString(paymentMode.getName()) && !Utils.emptyString(paymentMode.getShortName());
    }

    public void userData(User user) throws InvalidDataException {

        if (Utils.emptyString(user.getFirstName())) {
            throw new InvalidDataException("firstName is null");
        }

        if (!Utils.emptyString(user.getEmailId())) {
            if (!Utils.patternMatches(user.getEmailId(), EMAIL_VALIDATION_PATTERN)) {
                throw new InvalidDataException("Invalid emailId");
            }
        } else {
            throw new InvalidDataException("emailId is null");
        }
    }

    public void category(Category category) throws InvalidDataException {

        if (Utils.emptyString(category.getName())) {
            throw new InvalidDataException("Name is null");
        }
    }
}
