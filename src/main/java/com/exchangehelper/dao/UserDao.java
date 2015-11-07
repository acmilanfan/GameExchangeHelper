package com.exchangehelper.dao;

import com.exchangehelper.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);
    void deleteUser(User user);
    User getUserById(long id);
    List getAllUsers();
    List getGamesOfUser(User user);
    void updateUser(User user);
    User getUserByEmail(String email);
}
