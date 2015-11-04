package com.exchangehelper.service;

import com.exchangehelper.model.UserGame;

import java.util.List;

public interface UserGameService {

    void addUserGame(UserGame userGame);
    void updateUserGame(UserGame userGame);
    void deleteUserGame(UserGame userGame);
    UserGame getUserGameById(long id);
    List getAllUserGames();
    List getWantedGames(UserGame userGame);
    List getRecommendations(UserGame userGame);
}
