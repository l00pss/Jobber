package com.jobber.ws.modul.auditor.audit.concretes;

import com.jobber.ws.modul.auditor.audit.abstracts.Auditable;
import com.jobber.ws.modul.auditor.listener.concretes.UserAuditListener;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@EntityListeners(value = {UserAuditListener.class})
public abstract class UserAuditable extends Auditable {

    @CreatedDate
    private Date createDate;

}
