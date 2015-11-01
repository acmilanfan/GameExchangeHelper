package com.exchangehelper.dao;

import com.exchangehelper.model.User;

public interface UserDao {
    void addUser(User user);
    void deleteUser(User user);
    User getUserById(long id);
    void updateUser(User user);
}
