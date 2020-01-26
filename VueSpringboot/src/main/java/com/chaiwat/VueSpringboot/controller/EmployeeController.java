package com.chaiwat.VueSpringboot.controller;

import java.util.Collection;
import java.util.Optional;

import com.chaiwat.VueSpringboot.entity.Employee;
import com.chaiwat.VueSpringboot.entity.Job;
import com.chaiwat.VueSpringboot.service.EmployeeServiceImpl;
import com.chaiwat.VueSpringboot.service.JobServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * EmployeeController
 */
@RequestMapping("/api")
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;
    
    @Autowired
    private JobServiceImp jobServiceImp;

    public  EmployeeController(EmployeeServiceImpl employeeServiceImpl , JobServiceImp jobServiceImp){
        this.employeeServiceImpl = employeeServiceImpl;
        this.jobServiceImp = jobServiceImp;
    }

    @GetMapping("/employees")
    Collection<Employee> getAllEmployee(){
        return employeeServiceImpl.findAll();
    }

    @GetMapping("/emp/findByJobId/{jobId}")
    Collection<Employee> getEmployeeFromJob(@PathVariable Long jobId){
        Optional<Job> job = jobServiceImp.findById(jobId);
        System.out.println(job.get());
        return employeeServiceImpl.findByJobId(job.get());
    }
}