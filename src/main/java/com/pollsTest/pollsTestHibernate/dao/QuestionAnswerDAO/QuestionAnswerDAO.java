/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pollsTest.pollsTestHibernate.dao.QuestionAnswerDAO;

import com.pollsTest.pollsTestHibernate.entities.QuestionAnswer;
import java.util.List;

/**
 *
 * @author Julian Olarte Torres
 */
public interface QuestionAnswerDAO {
    
    List<QuestionAnswer> findByPollId(Integer id);
    
}
