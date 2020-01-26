package com.chaiwat.VueSpringboot.service;

import java.util.Collection;
import java.util.Optional;

import com.chaiwat.VueSpringboot.entity.Job;
import com.chaiwat.VueSpringboot.repository.JobRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * JobServiceImp
 */
@Component
public class JobServiceImp implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Override
    public Optional<Job> findById(Long id) {
        return jobRepository.findById(id);
    }

    @Override
    public Boolean save(Job job) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean delete(Job job) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean update(Job job) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Collection<Job> findAll() {
        
        return jobRepository.findAll();
    }

    
}