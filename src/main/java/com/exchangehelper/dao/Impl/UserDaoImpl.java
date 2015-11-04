package com.exchangehelper.dao.Impl;

import com.exchangehelper.dao.UserDao;
import com.exchangehelper.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

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
    public void updateUser(User user) {
        hibernateTemplate.update(user);
    }
}
