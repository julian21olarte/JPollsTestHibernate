/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pollsTest.pollsTestHibernate.dao.QuestionAnswerDAO;

import com.pollsTest.pollsTestHibernate.dao.AbstractDAO;
import com.pollsTest.pollsTestHibernate.entities.QuestionAnswer;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Julian Olarte Torres
 */
@Repository(value = "QuestionAnswerDAO")
public class QuestionAnswerDAOImpl extends AbstractDAO implements QuestionAnswerDAO{

    
    public QuestionAnswerDAOImpl() {
        super(QuestionAnswer.class);
    }
    
    @Override
    public List<QuestionAnswer> findByPollId(Integer id) {
        return (List<QuestionAnswer>) super.findAllByProperty("pollId", id);
    }
    
}
