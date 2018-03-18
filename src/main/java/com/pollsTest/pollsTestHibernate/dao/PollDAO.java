/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pollsTest.pollsTestHibernate.dao;

import com.pollsTest.pollsTestHibernate.entities.Poll;
import java.util.List;

/**
 *
 * @author Julian Olarte Torres
 */
public interface PollDAO {
    
    
    List<Poll> findAll();
    
    Poll findById(Long id);
            
    Poll findLast();
    
    Poll save(Poll poll);
    
    void delete(Poll poll);
    
    void deleteById(Long id);
    
    Poll update(Poll poll);
    
}
