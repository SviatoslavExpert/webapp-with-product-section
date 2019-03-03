package com.granovskiy.service;

import com.granovskiy.model.User;

import java.util.Optional;

public class UserServiceImpl implements UserService {
    @Override
    public Optional<User> authorize(User user) {
        user.setFirstName("Anton");
        return Optional.empty();
    }
}
