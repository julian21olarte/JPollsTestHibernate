/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pollsTest.pollsTestHibernate.exceptions;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author Julian Olarte Torres
 */
@ControllerAdvice
public class ErrorHandler {
 
   @ExceptionHandler(NoResultException.class)
   public ResponseEntity<ErrorMessage> noResultException(HttpServletRequest request, Exception e) {
       ErrorMessage errorInfo = new ErrorMessage(HttpStatus.NOT_FOUND.value(), e.getMessage(), request.getRequestURI());
       return new ResponseEntity<>(errorInfo, HttpStatus.NOT_FOUND);
   }
}
