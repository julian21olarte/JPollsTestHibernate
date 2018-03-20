/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pollsTest.pollsTestHibernate.controllers;

import com.pollsTest.pollsTestHibernate.entities.User;
import com.pollsTest.pollsTestHibernate.services.AuthService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Julian Olarte Torres
 */
@RestController
public class AuthController {
    
    @Autowired
    private AuthService authService;
    
    @RequestMapping(value = "/auth/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public User login(@RequestBody Map<String, Object> request) {
        String username = (String) request.get("username");
        String password = (String) request.get("password");        
        User user = this.authService.login(username, password);
        return user;
    }
    
    @RequestMapping(value = "/auth/logout", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void logout() {
        this.authService.logout();
    }
    
}
