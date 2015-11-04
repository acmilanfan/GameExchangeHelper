package com.exchangehelper.dao.Impl;

import com.exchangehelper.dao.GameDao;
import com.exchangehelper.model.Game;
import com.exchangehelper.model.Platform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("gameDao")
public class GameDaoImpl implements GameDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public void addGame(Game game) {
        hibernateTemplate.save(game);
    }

    @Override
    public void updateGame(Game game) {
        hibernateTemplate.update(game);
    }

    @Override
    public Game getGameById(long id) {
        return hibernateTemplate.get(Game.class, id);
    }

    @Override
    public List getAllGames() {
        return hibernateTemplate.loadAll(Game.class);
    }

    @Override
    public void deleteGame(Game game) {
        hibernateTemplate.delete(game);
    }

    @Override
    public List getGamesByPartialTitle(String partialTitle) {
        return hibernateTemplate.find("select game from Game game where lower(game.title) like ?",
                "%" + partialTitle + "%");
    }

    @Override
    public List getGamesOnPlatform(Platform platform) {
        return hibernateTemplate.find("select game from Game game where game.platform = ?", platform);
    }
}
