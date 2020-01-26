package com.chaiwat.VueSpringboot;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import java.util.Collections;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

import com.chaiwat.VueSpringboot.entity.Employee;
import com.chaiwat.VueSpringboot.entity.Job;

import com.chaiwat.VueSpringboot.repository.EmployeeRepository;
import com.chaiwat.VueSpringboot.repository.JobRepository;

@SpringBootApplication
public class VueSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(VueSpringbootApplication.class, args);
    }

    @Bean
    ApplicationRunner init(EmployeeRepository employeeRepository, JobRepository jobRepository) {

    return args -> {
         Stream.of("Web-dev", "Front-dev", "Backend-dev", "Fullstack", "Data-sci").forEach(description -> {
            Job job = new Job();
            job.setDescription(description);
            jobRepository.save(job);
        });
        jobRepository.findAll().forEach(System.out::println);

        Stream.of(1, 2, 3, 4, 5).forEach(jobId -> {
            Optional<Job> job = jobRepository.findById(Long.valueOf(jobId.longValue()));
            int leftLimit = 97; // letter 'a'
            int rightLimit = 122; // letter 'z'
            int targetStringLength = 10;
            Random random = new Random();
            String generatedString = random.ints(leftLimit, rightLimit + 1).limit(targetStringLength)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
            System.out.println(generatedString);

            Employee employee = new Employee(generatedString, job.get(), job.get().getDescription());
            employeeRepository.save(employee);
        });
        employeeRepository.findAll().forEach(System.out::println);

    };
    }
       

}
