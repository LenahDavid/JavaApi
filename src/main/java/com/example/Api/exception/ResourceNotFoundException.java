/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author lenah
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private String resourceName;
    private  String fieldName;
    private Object fieldValue;
    
     public ResourceNotFoundException(String resourceName,String fieldName,Object fieldValue){
         super(String.format("%s not found with %s:'%s'",resourceName,fieldName,fieldValue));
         this.resourceName = resourceName;
         this.fieldName = fieldName;
         this.fieldValue = fieldValue;
     }
     public String getResourceName(){
         return resourceName;
     }
      public String FieldName(){
         return fieldName;
     }
       public Object getFieldName(){
         return fieldName;
     }
}
