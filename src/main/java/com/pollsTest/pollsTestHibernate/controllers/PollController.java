/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pollsTest.pollsTestHibernate.controllers;

import com.pollsTest.pollsTestHibernate.dao.PollDAOImpl;
import com.pollsTest.pollsTestHibernate.entities.Poll;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Julian Olarte Torres
 */
@RestController
public class PollController {
    
    @Autowired
    private PollDAOImpl pollDaoImpl;
    
    @RequestMapping(value = "/poll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Poll> getPolls() {
        List<Poll> polls = this.pollDaoImpl.findAll();
        return polls;
    }
    
    @RequestMapping(value = "/last", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Poll getLastPoll() {
        return this.pollDaoImpl.findLast();
    }
    
}
