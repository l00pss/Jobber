package com.jobber.ws.config;

import com.jobber.ws.config.audit.UserAuditor;
import com.jobber.ws.model.entity.user.JUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories
@EnableJpaAuditing(auditorAwareRef="auditorProvider")
public class PersistenceConfig {
    @Bean
    AuditorAware<JUser> auditorProvider() {
        return new UserAuditor();
    }
}
