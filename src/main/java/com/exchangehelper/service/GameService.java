package com.exchangehelper.service;

import com.exchangehelper.model.Game;
import com.exchangehelper.model.Platform;

import java.util.List;

public interface GameService {

    void addGame(Game game);
    void updateGame(Game game);
    Game getGameById(long id);
    List getAllGames();
    void deleteGame(Game game);
    List getWantedList(Game game);
    List getGamesByPartialTitle(String partialTitle);
    List getGamesOnPlatform(Platform platform);
}
