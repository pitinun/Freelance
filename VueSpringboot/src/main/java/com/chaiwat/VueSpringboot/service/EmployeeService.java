package com.chaiwat.VueSpringboot.service;

import java.util.Collection;
import java.util.Optional;

import com.chaiwat.VueSpringboot.entity.Employee;
import com.chaiwat.VueSpringboot.entity.Job;

/**
 * EmployeeService
 */
public interface EmployeeService {

    Collection<Employee> findAll();
    Optional<Employee> findByJobId(Job id); 
    Employee findByName(String name);
    Boolean save(Employee employee);
    Boolean update(Employee employee);
    Boolean delete(Employee employee);
   
    
}