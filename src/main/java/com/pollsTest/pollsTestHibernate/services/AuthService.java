/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pollsTest.pollsTestHibernate.services;

import com.pollsTest.pollsTestHibernate.dao.UserDAO.UserDAOImpl;
import com.pollsTest.pollsTestHibernate.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Julian Olarte Torres
 */
@Service
public class AuthService {
    
    @Autowired
    private UserDAOImpl userDaoImpl;

    
    public User login(String username, String password) {
        return this.userDaoImpl.findOne(username, password);
    }
    
    public void logout() {
        
    }
    
}
