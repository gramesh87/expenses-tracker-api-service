package com.home.expenses.controller;

import com.home.expenses.entity.Category;
import com.home.expenses.exceptions.DataNotFoundException;
import com.home.expenses.exceptions.InvalidDataException;
import com.home.expenses.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    public CategoryService service;

    @GetMapping(value = "/fetch/all")
    public List<Category> getCategories() {
        return service.fetchCategories();
    }

    @GetMapping(value = "/fetch/{id}")
    public Category getCategory(@PathVariable int id) throws DataNotFoundException {
        return service.fetchCategory(id);
    }

    @PostMapping(value = "/save")
    public Category saveCategory(@RequestBody Category category) throws InvalidDataException {
        return service.saveCategory(category);
    }

    @PutMapping(value = "/update/{id}")
    public Category updateCategory(@PathVariable int id, @RequestBody Category category) throws DataNotFoundException, InvalidDataException {
        return service.updateCategory(id, category);
    }
}
