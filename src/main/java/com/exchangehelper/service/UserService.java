package com.exchangehelper.service;

import com.exchangehelper.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);
    void deleteUser(User user);
    User getUserById(long id);
    List getAllUsers();
    void updateUser(User user);
}
