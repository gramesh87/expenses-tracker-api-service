package com.home.expenses.service;

import com.home.expenses.entity.PaymentMode;
import com.home.expenses.exceptions.DataNotFoundException;
import com.home.expenses.exceptions.InvalidDataException;
import com.home.expenses.repository.PaymentModeRepository;
import com.home.expenses.utils.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentModeService {

    @Autowired
    PaymentModeRepository repository;

    @Autowired
    Validator validator;

    public List<PaymentMode> fetchAllPaymentMode() {
        return repository.findAll();
    }

    public PaymentMode savePaymentMode(PaymentMode paymentMode) throws InvalidDataException {
        boolean valid = validator.paymentMode(paymentMode);
        if (valid) {
            repository.save(paymentMode);
            return paymentMode;
        } else {
            throw new InvalidDataException("Invalid data");
        }
    }

    public PaymentMode updatePaymentMode(int id, PaymentMode uPaymentMode) throws InvalidDataException, DataNotFoundException {
        PaymentMode paymentMode = fetchPaymentMode(id);
        paymentMode.setName(uPaymentMode.getName());
        paymentMode.setShortName(uPaymentMode.getShortName());
        return repository.save(paymentMode);
    }

    public PaymentMode fetchPaymentMode(int id) throws DataNotFoundException {
        Optional<PaymentMode> paymentMode =  repository.findById(id);
        if (paymentMode.isPresent()) {
            return paymentMode.get();
        } else {
            throw new DataNotFoundException();
        }
    }
}
