package com.exchangehelper.service.Impl;

import com.exchangehelper.dao.GameDao;
import com.exchangehelper.model.Game;
import com.exchangehelper.model.Platform;
import com.exchangehelper.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("gameService")
public class GameServiceImpl implements GameService {

    @Autowired
    private GameDao gameDao;

    @Transactional
    @Override
    public void addGame(Game game) {
        gameDao.addGame(game);
    }

    @Transactional
    @Override
    public void updateGame(Game game) {
        gameDao.updateGame(game);
    }

    @Override
    public Game getGameById(long id) {
        return gameDao.getGameById(id);
    }

    @Override
    public List getAllGames() {
        return gameDao.getAllGames();
    }

    @Transactional
    @Override
    public void deleteGame(Game game) {
        gameDao.deleteGame(game);
    }

    @Override
    public List getWantedList(Game game) {
        return gameDao.getWantedList(game);
    }

    @Override
    public List getGamesByPartialTitle(String partialTitle) {
        return gameDao.getGamesByPartialTitle(partialTitle);
    }

    @Override
    public List getGamesOnPlatform(Platform platform) {
        return gameDao.getGamesOnPlatform(platform);
    }
}
