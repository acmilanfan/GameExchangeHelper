package com.exchangehelper.dao.Impl;

import com.exchangehelper.dao.UserDao;
import com.exchangehelper.model.User;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

    @Override
    public void addUser(User user) {
        getHibernateTemplate().save(user);
    }

    @Override
    public void deleteUser(User user) {
        getHibernateTemplate().delete(user);
    }

    @Override
    public User getUserById(long id) {
        return getHibernateTemplate().get(User.class, id);
    }

    @Override
    public void updateUser(User user) {
        getHibernateTemplate().update(user);
    }
}
