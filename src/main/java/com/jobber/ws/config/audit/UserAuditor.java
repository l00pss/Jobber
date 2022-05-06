package com.jobber.ws.config.audit;

import com.jobber.ws.model.entity.user.JUser;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.*;
import java.util.Optional;

public class UserAuditor implements AuditorAware<JUser> {

    @Override
    public @NotNull Optional<JUser> getCurrentAuditor() {
        return Optional.ofNullable(SecurityContextHolder.getContext())
                .map(SecurityContext::getAuthentication)
                .filter(Authentication::isAuthenticated)
                .map(Authentication::getPrincipal)
                .map(JUser.class::cast);
    }

    @PrePersist
    public void prePersist(Object o) {

    }

    @PreUpdate
    public void preUpdate(Object o) {

    }

    @PreRemove
    public void preRemove(Object o) {

    }

    @PostLoad
    public void postLoad(Object o) {

    }

    @PostRemove
    public void postRemove(Object o) {

    }

    @PostUpdate
    public void postUpdate(Object o) {

    }

    @PostPersist
    public void postPersist(Object o) {

    }
}