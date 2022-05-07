package com.jobber.ws.modul.auditor.audit.abstracts;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@EntityListeners(value = {AuditingEntityListener.class})
public abstract class Auditable {

    @LastModifiedDate
    private Date modificationDate;

}
