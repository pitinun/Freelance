package com.chaiwat.VueSpringboot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * Jop
 */
@Entity
@Data
@NoArgsConstructor
public class Job {

    @Id
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String description;


    
}