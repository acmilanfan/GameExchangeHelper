package com.exchangehelper.dao.Impl;

import com.exchangehelper.dao.GameDao;
import com.exchangehelper.model.Game;
import com.exchangehelper.model.Platform;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("gameDao")
public class GameDaoImpl extends HibernateDaoSupport implements GameDao {

    @Override
    public void addGame(Game game) {
        getHibernateTemplate().save(game);
    }

    @Override
    public void updateGame(Game game) {
        getHibernateTemplate().update(game);
    }

    @Override
    public Game getGameById(long id) {
        return getHibernateTemplate().get(Game.class, id);
    }

    @Override
    public List getAllGames() {
        getHibernateTemplate().loadAll(Game.class);
        return null;
    }

    @Override
    public void deleteGame(Game game) {
        getHibernateTemplate().delete(game);
    }

    @Override
    public List getGamesByPartialTitle(String partialTitle) {
        return getHibernateTemplate().find("select game from Game game where lower(game.title) like ?",
                "%" + partialTitle + "%");
    }

    @Override
    public List getGamesOnPlatform(Platform platform) {
        return getHibernateTemplate().find("select game from Game game where game.platform = ?", platform);
    }
}
