/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pollsTest.pollsTestHibernate.dao.UserDAO;

import com.pollsTest.pollsTestHibernate.entities.User;
import java.util.List;

/**
 *
 * @author Julian Olarte Torres
 */
public interface UserDAO {
    
    List<User> findAll();
    
    User findById(Long id);
    
    User findOne(String username, String password);
    
}
