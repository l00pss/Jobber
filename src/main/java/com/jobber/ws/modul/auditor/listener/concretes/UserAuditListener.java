package com.jobber.ws.modul.auditor.listener.concretes;

import com.jobber.ws.modul.auditor.listener.abstracts.AuditListener;

import javax.persistence.*;

public class UserAuditListener  implements AuditListener {


    @PrePersist
    @Override
    public void prePersist(Object object) {
        System.out.println("User Pre Persistence  ".concat(object.toString()));
    }

    @PreUpdate
    @Override
    public void preUpdate(Object object) {
        System.out.println("User Pre Update  ".concat(object.toString()));
    }

    @PreRemove
    @Override
    public void preRemove(Object object) {
        System.out.println("Pre Remove  ".concat(object.toString()));
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

        System.out.println("User post Persistence  ".concat(o.toString()));
    }
}
