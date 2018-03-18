/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pollsTest.pollsTestHibernate.controllers;

import com.pollsTest.pollsTestHibernate.dao.UserDAOImpl;
import com.pollsTest.pollsTestHibernate.entities.User;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.NoResultException;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Julian Olarte Torres
 */
@RestController
public class AuthController {
    
    @Autowired
    private UserDAOImpl userDaoImpl;
    
    @RequestMapping(value = "/auth/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> login(@RequestParam Map<String, Object> request) {
        String username = (String) request.get("username");
        String password = (String) request.get("password");
        HashMap<String, Object> response = new HashMap<>();
        try {
            User user = this.userDaoImpl.findOne(username, password);
            response.put("status", 200);
            response.put("user", user);
        }
        catch(NoResultException nr) {
            response.put("status", 401);
            response.put("message", "Unauthenticated");
        }
        return response;
    }
    
    @RequestMapping(value = "/auth/logout", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String logout() {
        return "";
    }
    
}
