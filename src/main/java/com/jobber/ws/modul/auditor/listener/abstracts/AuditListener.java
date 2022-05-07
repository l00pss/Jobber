package com.jobber.ws.modul.auditor.listener.abstracts;


public  interface AuditListener {


    void prePersist(Object object);


    void preUpdate(Object object);


    void preRemove(Object object);


}