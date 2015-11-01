package com.exchangehelper.service;

import com.exchangehelper.model.User;

public interface UserService {

    void addUser(User user);
    void deleteUser(User user);
    User getUserById(long id);
    void updateUser(User user);
}
