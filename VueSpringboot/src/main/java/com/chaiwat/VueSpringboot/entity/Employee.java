package com.chaiwat.VueSpringboot.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * Employee
 */
@Entity
@Data
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Job.class)
    @JoinColumn(name = "Job_Id", insertable = true)
    private Job jobId;
    private String description;


    public Employee(String name , Job jobId , String description){
        this.name = name;
        this.jobId = jobId;
        this.description = description;
    }
}