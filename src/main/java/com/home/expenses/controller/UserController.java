package com.home.expenses.controller;

import com.home.expenses.entity.User;
import com.home.expenses.exceptions.InvalidDataException;
import com.home.expenses.exceptions.InvalidUserException;
import com.home.expenses.exceptions.UserNotFoundException;
import com.home.expenses.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping(value = "/fetch/{userId}")
    public ResponseEntity<User> fetchUser(@PathVariable("userId") Long userId) throws UserNotFoundException {
        return ResponseEntity.ok(service.getUser(userId));
    }

    @GetMapping(value = "/fetch/all")
    public ResponseEntity<List<User>> fetchAllUsers() {
        return ResponseEntity.ok(service.getAllUsers());
    }

    @PostMapping(value = "/create")
    public ResponseEntity<User> createUser(@RequestBody User user) throws InvalidDataException {
        return ResponseEntity.ok(service.saveUser(user));
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id,
                                           @RequestBody User user) throws UserNotFoundException, InvalidUserException, InvalidDataException {
        return ResponseEntity.ok(service.updateUser(id, user));
    }
}
