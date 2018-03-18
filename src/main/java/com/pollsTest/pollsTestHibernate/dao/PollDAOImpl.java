/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pollsTest.pollsTestHibernate.dao;

import com.pollsTest.pollsTestHibernate.entities.Poll;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Julian Olarte Torres
 */
@Repository(value = "PollDAO")
public class PollDAOImpl extends AbstractDAO implements PollDAO {
    
    public PollDAOImpl() {
        super(Poll.class);
    }

    @Override
    public List<Poll> findAll() {
        return (List<Poll>) super.findAll();
    }

    @Override
    public Poll findById(Long id) {
       return (Poll) super.findByKey(id);
    }

    @Override
    public void deleteById(Long id) {
        super.findByKey(id);
    }

    @Override
    public Poll save(Poll poll) {
        super.save(poll);
        super.getEntityManager().flush();
        return (Poll) super.findByKey(poll.getId());
    }

    @Override
    public void delete(Poll poll) {
        super.delete(poll);
    }

    @Override
    public Poll update(Poll poll) {
        super.update(poll);
        super.getEntityManager().flush();
        return (Poll) super.findByKey(poll.getId());
    }

    @Override
    public Poll findLast() {
        return (Poll) super.findLast();
    }
    
}
