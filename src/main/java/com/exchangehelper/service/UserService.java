package com.exchangehelper.service;

import com.exchangehelper.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);
    void deleteUser(User user);
    User getUserById(long id);
    List getAllUsers();
    List getGamesOfUser(User user);
    void updateUser(User user);
}
