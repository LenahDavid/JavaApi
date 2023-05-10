/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Api.service.impl;

import com.example.Api.exception.ResourceNotFoundException;
import com.example.Api.model.Employee;
import com.example.Api.repository.EmployeeRepository;
import com.example.Api.service.EmployeeService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author lenah
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{
private EmployeeRepository employeeRepository;

public EmployeeServiceImpl(EmployeeRepository employeeRepository){
    super();
    this.employeeRepository = employeeRepository;
}
    @Override
    public Employee saveEmployee(Employee employee) {
       return employeeRepository.save(employee); 
    }

    @Override
    public List<Employee> getAllEmployees() {
       return employeeRepository.findAll();
    }
    @Override
    public Employee getEmployeeById(long id){
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()){
            return employee.get();
            
        }else{
            throw new ResourceNotFoundException("Employee","Id",id);
        }
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
    Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
    () -> new ResourceNotFoundException("Employee","id",id));
    existingEmployee.setFirstName(employee.getFirstName());
     existingEmployee.setLastName(employee.getLastName());
      existingEmployee.setEmail(employee.getEmail());
      employeeRepository.save(existingEmployee);
      return existingEmployee;
    }

    @Override
    public void deleteEmployee(long id) {
        employeeRepository.findById(id).orElseThrow(
    () -> new ResourceNotFoundException("Employee","id",id));
       employeeRepository.deleteById(id);
    }
   
    
}
