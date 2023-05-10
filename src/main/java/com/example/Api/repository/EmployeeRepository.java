/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Api.repository;

import com.example.Api.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author lenah
 */
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    
}
