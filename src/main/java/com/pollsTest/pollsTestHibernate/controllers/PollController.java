/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pollsTest.pollsTestHibernate.controllers;

import com.pollsTest.pollsTestHibernate.entities.Poll;
import com.pollsTest.pollsTestHibernate.entities.QuestionAnswer;
import com.pollsTest.pollsTestHibernate.services.PollService;
import java.util.List;
import javax.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
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
    private PollService pollService;
    
    @RequestMapping(value = "/poll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Poll> getPolls() {
        List<Poll> polls = this.pollService.findAll();
        return polls;
    }
    
    @RequestMapping(value = "/poll/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Poll getPollById(@PathVariable("id") Integer id) {
        Poll poll = this.pollService.getPollById(id);
        if(poll == null) {
            throw new NoResultException("Not exist poll identified by id: " + id);
        }
        return poll;
    }
    
    @RequestMapping(value = "/poll/responses/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<QuestionAnswer> getResponses(@PathVariable("id") Integer id) {
        return this.pollService.findResponsesByPollId(id);
    }
    
    
    /*@RequestMapping(value = "/poll/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String savePoll(@RequestBody Map<String, Object> request) {
        Poll newPoll;
        Gson gsonResponse = new Gson();
        String response;
        try {
            newPoll = this.pollService.savePoll(request);
            response = gsonResponse.toJson(newPoll);
        } catch (Exception ex) {
            Map<String, Object> exception = new HashMap<>();
            exception.put("status", 500);
            exception.put("message", "Poll could not be saved");
            exception.put("error", ex.toString());
            response = gsonResponse.toJson(exception);
        }
        return response;
    }*/
    
    @RequestMapping(value = "/poll/last", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Poll getLastPoll() {
        return this.pollService.findLast();
    }
    
}
