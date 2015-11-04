package com.exchangehelper.service.Impl;

import com.exchangehelper.dao.UserGameDao;
import com.exchangehelper.model.UserGame;
import com.exchangehelper.service.UserGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userGameService")
public class UserGameServiceImpl implements UserGameService {

    @Autowired
    private UserGameDao userGameDao;

    @Transactional
    @Override
    public void addUserGame(UserGame userGame) {
        userGameDao.addUserGame(userGame);
    }

    @Transactional
    @Override
    public void updateUserGame(UserGame userGame) {
        userGameDao.updateUserGame(userGame);
    }

    @Transactional
    @Override
    public void deleteUserGame(UserGame userGame) {
        userGameDao.deleteUserGame(userGame);
    }

    @Override
    public UserGame getUserGameById(long id) {
        return userGameDao.getUserGameById(id);
    }

    @Override
    public List getRecommendations(UserGame userGame) {
        return userGameDao.getRecommendations(userGame);
    }
}
