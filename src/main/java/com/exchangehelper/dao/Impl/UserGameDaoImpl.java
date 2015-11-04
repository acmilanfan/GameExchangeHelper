package com.exchangehelper.dao.Impl;

import com.exchangehelper.dao.UserGameDao;
import com.exchangehelper.model.UserGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userGameDao")
public class UserGameDaoImpl implements UserGameDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public void addUserGame(UserGame userGame) {
        hibernateTemplate.save(userGame);
    }

    @Override
    public void updateUserGame(UserGame userGame) {
        hibernateTemplate.update(userGame);
    }

    @Override
    public void deleteUserGame(UserGame userGame) {
        hibernateTemplate.delete(userGame);
    }

    @Override
    public UserGame getUserGameById(long id) {
        return hibernateTemplate.get(UserGame.class, id);
    }

    @Override
    public List getRecommendations(UserGame userGame) {
        return hibernateTemplate.find("select game from UserGame game inner join game.wantedGames wantedGame" +
                "where wantedGame.id = ?", userGame.getGame().getId());
    }
}
