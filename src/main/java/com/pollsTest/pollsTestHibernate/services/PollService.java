/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pollsTest.pollsTestHibernate.services;

import com.pollsTest.pollsTestHibernate.dao.PollDAOImpl;
import com.pollsTest.pollsTestHibernate.entities.Poll;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Julian Olarte Torres
 */
public class PollService {
    
    
    @Autowired
    private PollDAOImpl pollDaoImpl;
    
    public List<Poll> findAll() {
        return this.pollDaoImpl.findAll();
    }
    
    
    public Poll findLast() {
        return this.pollDaoImpl.findLast();
    }

}
