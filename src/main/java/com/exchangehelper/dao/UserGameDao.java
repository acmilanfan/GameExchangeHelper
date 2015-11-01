package com.exchangehelper.dao;

import com.exchangehelper.model.UserGame;

import java.util.List;

public interface UserGameDao {
    void addUserGame(UserGame userGame);
    void updateUserGame(UserGame userGame);
    void deleteUserGame(UserGame userGame);
    UserGame getUserGameById(long id);
    List getRecommendations(UserGame userGame);
}
