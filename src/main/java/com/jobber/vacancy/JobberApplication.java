package com.jobber.vacancy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.jobber.vacancy.dataAccess")
@PropertySource("classpath:application-${spring.profiles.active:prod}.properties")
public class JobberApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobberApplication.class, args);
    }

}
