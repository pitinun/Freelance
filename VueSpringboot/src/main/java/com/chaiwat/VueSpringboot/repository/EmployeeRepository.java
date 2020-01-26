package com.chaiwat.VueSpringboot.repository;

import java.util.Optional;

import com.chaiwat.VueSpringboot.entity.Employee;
import com.chaiwat.VueSpringboot.entity.Job;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * EmployeeRepository
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

    Employee findByName(String name);
    Optional<Employee> findByJobId(Job id);
}