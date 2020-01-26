package com.chaiwat.VueSpringboot.controller;

import java.util.Collection;
import java.util.Optional;

import com.chaiwat.VueSpringboot.entity.Job;
import com.chaiwat.VueSpringboot.service.JobServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * JobController
 */
@RequestMapping("/api")
@RestController
public class JobController {

    @Autowired
    private JobServiceImp jobServiceImp;
    
    public JobController(JobServiceImp jobServiceImp){
        this.jobServiceImp = jobServiceImp;
    }

    @GetMapping("/jobs")
    Collection<Job> getAllJob(){
        return jobServiceImp.findAll();
    }

    @GetMapping("/job/findById/{jobId}")
    Optional<Job> getDescription(@PathVariable Long jobId){
        return jobServiceImp.findById(jobId);
    }


}