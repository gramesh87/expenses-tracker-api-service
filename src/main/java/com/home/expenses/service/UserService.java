package com.home.expenses.service;

import com.home.expenses.entity.User;
import com.home.expenses.exceptions.InvalidUserException;
import com.home.expenses.exceptions.UserNotFoundException;
import com.home.expenses.repository.UserRepository;
import com.home.expenses.utils.CommonHelper;
import com.home.expenses.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User createUser(User user) {
        repository.save(user);
        return user;
    }

    public User getUser(Long userId) throws UserNotFoundException {
        return repository.findById(userId).orElseThrow(UserNotFoundException::new);
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User updateUser(User updatedUser) throws UserNotFoundException, InvalidUserException {

        if (updatedUser.getId() == null) {
            throw new UserNotFoundException("No user id is available");
        }
        Optional<User> user = repository.findById(updatedUser.getId());

        if (user.isPresent()) {
            User dbObject = CommonHelper.updateUserData(user.get(), updatedUser);
            if (dbObject != null) {
                repository.save(dbObject);
                return dbObject;
            } else {
                throw new InvalidUserException("Invalid User");
            }
        }
        else {
            throw new UserNotFoundException("No user available with id "+ updatedUser.getId());
        }
    }
}
