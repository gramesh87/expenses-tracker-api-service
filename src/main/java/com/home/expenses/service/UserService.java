package com.home.expenses.service;

import com.home.expenses.entity.User;
import com.home.expenses.exceptions.InvalidDataException;
import com.home.expenses.exceptions.InvalidUserException;
import com.home.expenses.exceptions.UserNotFoundException;
import com.home.expenses.repository.UserRepository;
import com.home.expenses.utils.Helper;
import com.home.expenses.utils.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private Validator validator;

    public User saveUser(User user) throws InvalidDataException {
        validator.userData(user);
        repository.save(user);
        return user;
    }

    public User getUser(Long userId) throws UserNotFoundException {
        return repository.findById(userId).orElseThrow(UserNotFoundException::new);
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User updateUser(long id, User updatedUser) throws UserNotFoundException, InvalidUserException, InvalidDataException {
        User user = getUser(id);
        Helper.updateUserData(user, updatedUser);
        return saveUser(user);
    }
}
