package com.jobber.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableJpaRepositories("com.jobber.ws.dataAccess")
@PropertySource("classpath:application-${spring.profiles.active:default}.properties")
public class JobberApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobberApplication.class, args);
    }

}
