package com.exchangehelper.dao;

import com.exchangehelper.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);
    void deleteUser(User user);
    User getUserById(long id);
    List getAllUsers();
    void updateUser(User user);
}
