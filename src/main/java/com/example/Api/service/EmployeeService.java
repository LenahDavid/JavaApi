/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Api.service;

import com.example.Api.model.Employee;
import java.util.List;

/**
 *
 * @author lenah
 */
public interface EmployeeService {
     Employee saveEmployee(Employee employee);
      List<Employee> getAllEmployees();
      Employee getEmployeeById(long id);
      Employee updateEmployee(Employee employee, long id);
      void deleteEmployee(long id);
}
