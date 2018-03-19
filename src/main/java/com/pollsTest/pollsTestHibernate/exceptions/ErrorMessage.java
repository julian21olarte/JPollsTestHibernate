/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pollsTest.pollsTestHibernate.exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.xml.ws.http.HTTPException;

/**
 *
 * @author Julian Olarte Torres
 */
public class ErrorMessage {
    
   @JsonProperty("message")
   private final String message;
   @JsonProperty("status_code")
   private final int statusCode;
   @JsonProperty("uri")
   private final String uriRequested;
 
   public ErrorMessage(HTTPException exception, String uriRequested) {
       this.message = exception.getMessage();
       this.statusCode = exception.getStatusCode();
       this.uriRequested = uriRequested;
   }
 
   public ErrorMessage(int statusCode, String message, String uriRequested) {
       this.message = message;
       this.statusCode = statusCode;
       this.uriRequested = uriRequested;
   }
 
   public String getMessage() {
       return message;
   }
 
   public int getStatusCode() {
       return statusCode;
   }
 
   public String getUriRequested() {
       return uriRequested;
   }
}
