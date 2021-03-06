package com.exchangehelper.dao.Impl;

import com.exchangehelper.dao.UserDao;
import com.exchangehelper.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public void addUser(User user) {
        hibernateTemplate.save(user);
    }

    @Override
    public void deleteUser(User user) {
        hibernateTemplate.delete(user);
    }

    @Override
    public User getUserById(long id) {
        return hibernateTemplate.get(User.class, id);
    }

    @Override
    public List getAllUsers() {
        return hibernateTemplate.loadAll(User.class);
    }

    @Override
    public List getGamesOfUser(User user) {
        return hibernateTemplate.find("select game from UserGame game " +
                "where game.user.id=?", user.getId());
    }

    @Override
    public void updateUser(User user) {
        hibernateTemplate.update(user);
    }

    @Override
    public User getUserByEmail(String email) {
        List result = hibernateTemplate.find("select user from User user where user.email=?", email);
        if (result.size() > 0) {
            return (User) result.get(0);
        } else {
            return null;
        }
    }
}
