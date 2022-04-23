package com.jobber.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories("com.jobber.ws.dataAccess")
@EnableTransactionManagement
@EnableJpaAuditing
@PropertySource("classpath:application-${spring.profiles.active:default}.properties")
public class JobberApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobberApplication.class, args);
    }

}
