/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pollsTest.pollsTestHibernate.dao.PollDAO;

import com.pollsTest.pollsTestHibernate.dao.AbstractDAO;
import com.pollsTest.pollsTestHibernate.entities.Poll;
import com.pollsTest.pollsTestHibernate.entities.Question;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
    public Poll findById(Integer id) {
       return (Poll) super.findByKey(id);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        super.deleteByKey(id);
    }

    @Override
    @Transactional
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
    @Transactional
    public Poll update(Poll poll) {
        super.update(poll);
        return (Poll) super.findByKey(poll.getId());
    }

    @Override
    public Poll findLast() {
        return (Poll) super.findLast();
    }
    
}
