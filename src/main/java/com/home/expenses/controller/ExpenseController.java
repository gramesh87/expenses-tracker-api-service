package com.home.expenses.controller;

import com.home.expenses.entity.Expense;
import com.home.expenses.io.model.UserExpense;
import com.home.expenses.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/expense")
public class ExpenseController {

    @Autowired
    private ExpenseService service;

    @GetMapping(value = "/fetch/{expenseId}")
    public List<Expense> getSpendDetails(@PathVariable(name = "expenseId") String expenseId) {
        return null;
    }

    @PostMapping(value = "/create")
    public Expense createExpense(@RequestBody UserExpense userExpense) {
        return service.createExpense(userExpense);
    }
}
