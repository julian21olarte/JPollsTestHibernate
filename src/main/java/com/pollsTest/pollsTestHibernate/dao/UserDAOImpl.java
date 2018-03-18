/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pollsTest.pollsTestHibernate.dao;

import com.pollsTest.pollsTestHibernate.entities.User;
import java.util.List;
import javax.persistence.NoResultException;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Julian Olarte Torres
 */
@Repository(value = "UserDao")
public class UserDAOImpl extends AbstractDAO implements UserDAO {
    
    public UserDAOImpl() {
        super(User.class);
    }

    @Override
    public List<User> findAll() {
        return (List<User>) super.findAll();
    }

    @Override
    public User findById(Long id) {
        return (User) super.findByKey(id);
    }

    @Override
    public User findOne(String username, String password) throws NoResultException {
        return (User) super.getEntityManager()
            .createQuery(String.format("SELECT t FROM User t WHERE t.username = '%s' AND t.password = '%s'", username, password))
            .getSingleResult();
    }
    
}
