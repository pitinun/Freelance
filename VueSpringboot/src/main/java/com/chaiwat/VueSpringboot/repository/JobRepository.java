package com.chaiwat.VueSpringboot.repository;

import java.util.Optional;

import com.chaiwat.VueSpringboot.entity.Job;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * JobRepository
 */
@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

    Optional<Job> findById(Long id);

}