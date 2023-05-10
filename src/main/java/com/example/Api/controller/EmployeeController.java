/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Api.controller;

import com.example.Api.model.Employee;
import com.example.Api.service.EmployeeService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lenah
 */
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;
    
    public EmployeeController(EmployeeService employeeService){
    super();
    this.employeeService = employeeService;
    }
    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee),HttpStatus.CREATED);
    }
    @GetMapping
    public List<Employee> getAllEmployees(){
     List<Employee> employees = employeeService.getAllEmployees();
        return employees;
    }
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id")long employeeId){
        return new ResponseEntity<Employee>(employeeService.getEmployeeById( employeeId),HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<Employee>updateEmployee(@PathVariable("id")long id,@RequestBody Employee employee){
           return new ResponseEntity<Employee>(employeeService.updateEmployee( employee,id),HttpStatus.OK); 
    }
        @DeleteMapping("{id}")
    public ResponseEntity<String>deleteEmployee(@PathVariable("id")long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<String>("Employee deleted successfully",HttpStatus.OK);
    }
    
}
