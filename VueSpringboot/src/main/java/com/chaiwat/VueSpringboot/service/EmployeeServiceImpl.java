package com.chaiwat.VueSpringboot.service;

import java.util.Collection;
import java.util.Optional;

import com.chaiwat.VueSpringboot.entity.Employee;
import com.chaiwat.VueSpringboot.entity.Job;
import com.chaiwat.VueSpringboot.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * EmployeeServiceImpl
 */
@Component
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Collection<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Collection<Employee> findByJobId(Job id) {
        return employeeRepository.findByJobId(id);
    }

    @Override
    public Employee findByName(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public Boolean save(Employee employee) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean update(Employee employee) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean delete(Employee employee) {
        // TODO Auto-generated method stub
        return null;
    }

    

    
}