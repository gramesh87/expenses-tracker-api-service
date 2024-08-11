package com.home.expenses.controller;

import com.home.expenses.entity.PaymentMode;
import com.home.expenses.exceptions.DataNotFoundException;
import com.home.expenses.exceptions.InvalidDataException;
import com.home.expenses.service.PaymentModeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/paymentMode")
public class PaymentModeController {

    @Autowired
    PaymentModeService service;

    @GetMapping(value = "/fetch/all")
    public List<PaymentMode> getAllPaymentMode() {
        return service.fetchAllPaymentMode();
    }

    @GetMapping(value = "/fetch/{id}")
    public PaymentMode getPaymentMode(@PathVariable int id) throws DataNotFoundException {
        return service.fetchPaymentMode(id);
    }

    @PostMapping(value = "/save")
    public PaymentMode savePaymentMode(@RequestBody PaymentMode paymentMode) throws InvalidDataException {
        return service.savePaymentMode(paymentMode);
    }

    @PutMapping(value = "/update/{id}")
    public PaymentMode updatePaymentMode(@PathVariable int id, @RequestBody PaymentMode paymentMode) throws DataNotFoundException, InvalidDataException {
        return service.updatePaymentMode(id, paymentMode);
    }
}
