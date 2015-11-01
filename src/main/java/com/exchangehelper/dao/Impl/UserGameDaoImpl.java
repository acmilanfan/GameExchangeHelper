package com.exchangehelper.dao.Impl;

import com.exchangehelper.dao.UserGameDao;
import com.exchangehelper.model.UserGame;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userGameDao")
public class UserGameDaoImpl extends HibernateDaoSupport implements UserGameDao {

    @Override
    public void addUserGame(UserGame userGame) {
        getHibernateTemplate().save(userGame);
    }

    @Override
    public void updateUserGame(UserGame userGame) {
        getHibernateTemplate().update(userGame);
    }

    @Override
    public void deleteUserGame(UserGame userGame) {
        getHibernateTemplate().delete(userGame);
    }

    @Override
    public UserGame getUserGameById(long id) {
        return getHibernateTemplate().get(UserGame.class, id);
    }

    @Override
    public List getRecommendations(UserGame userGame) {
        return getHibernateTemplate().find("select game from UserGame game inner join game.wantedGames wantedGame" +
                "where wantedGame.id = ?", userGame.getGame().getId());
    }
}
