package com.chaiwat.VueSpringboot.service;

import java.util.Collection;
import java.util.Optional;

import com.chaiwat.VueSpringboot.entity.Job;

/**
 * JobService
 */
public interface JobService {

    Collection<Job> findAll();
    Optional<Job> findById(Long id);
    Boolean save(Job job);
    Boolean delete(Job job);
    Boolean update(Job job);
    
}