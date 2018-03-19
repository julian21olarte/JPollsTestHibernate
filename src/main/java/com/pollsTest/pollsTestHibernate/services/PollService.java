/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pollsTest.pollsTestHibernate.services;

import com.pollsTest.pollsTestHibernate.dao.PollDAO.PollDAOImpl;
import com.pollsTest.pollsTestHibernate.dao.QuestionAnswerDAO.QuestionAnswerDAOImpl;
import com.pollsTest.pollsTestHibernate.entities.Poll;
import com.pollsTest.pollsTestHibernate.entities.QuestionAnswer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Julian Olarte Torres
 */
@Service
public class PollService {
    
    
    @Autowired
    private PollDAOImpl pollDaoImpl;
    
    @Autowired
    private QuestionAnswerDAOImpl questionAnswerDaoImpl;
    
    public List<Poll> findAll() {
        return this.pollDaoImpl.findAll();
    }
    
    public Poll getPollById(Integer id) {
        return this.pollDaoImpl.findById(id);
    }
    
    public List<QuestionAnswer> findResponsesByPollId(Integer id) {
        return this.questionAnswerDaoImpl.findByPollId(id);
    }
    
    public Poll findLast() {
        return this.pollDaoImpl.findLast();
    }
    
    public Poll savePoll(Poll newPoll) {
        return this.pollDaoImpl.save(newPoll);
    }

}
