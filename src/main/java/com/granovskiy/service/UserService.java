package com.granovskiy.service;

import com.granovskiy.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> authorize(User user);
}
