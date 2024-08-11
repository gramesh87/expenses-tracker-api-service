package com.home.expenses.service;

import com.home.expenses.entity.Category;
import com.home.expenses.exceptions.DataNotFoundException;
import com.home.expenses.exceptions.InvalidDataException;
import com.home.expenses.exceptions.UserNotFoundException;
import com.home.expenses.repository.CategoryRepository;
import com.home.expenses.utils.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Autowired
    private Validator validator;

    public List<Category> fetchCategories() {
        return repository.findAll();
    }

    public Category fetchCategory(Integer id) throws DataNotFoundException {
        return repository.findById(id).orElseThrow(DataNotFoundException::new);
    }

    public Category saveCategory(Category category) throws InvalidDataException {
        validator.category(category);
        return repository.save(category);
    }

    public Category updateCategory(int id, Category category) throws DataNotFoundException, InvalidDataException {
        Category existingCategory = fetchCategory(id);
        existingCategory.setName(category.getName());
        existingCategory.setDescription(category.getDescription());
        return saveCategory(existingCategory);
    }
}
