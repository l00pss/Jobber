package com.jobber.ws.config.auditor.listener.abstracts;

import javax.persistence.*;


public  interface AuditListener {


    void prePersist(Object object);


    void preUpdate(Object object);


    void preRemove(Object object);


}