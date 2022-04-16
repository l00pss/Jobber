package com.jobber.vacancy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.jobber.vacancy.dataAccess")
public class JobberApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobberApplication.class, args);
    }

}
