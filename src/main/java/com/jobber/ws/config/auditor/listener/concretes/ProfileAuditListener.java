package com.jobber.ws.config.auditor.listener.concretes;

import com.jobber.ws.config.auditor.listener.abstracts.AuditListener;
import com.jobber.ws.model.entity.user.UserProfile;

import javax.persistence.*;


public class ProfileAuditListener implements AuditListener {

    @PrePersist
    @Override
    public void prePersist(Object object) {
        UserProfile profile = (UserProfile) object;
        System.out.println("Profile Pre Persistence  ".concat(profile.getFirstname()));
    }

    @PreUpdate
    @Override
    public void preUpdate(Object object) {
        System.out.println("Profile Pre Update  ".concat(object.toString()));
    }

    @PreRemove
    @Override
    public void preRemove(Object object) {
        System.out.println("Profile Remove  ".concat(object.toString()));
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
