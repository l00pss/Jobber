package com.jobber.ws.config.auditor.audit.concretes;

import com.jobber.ws.config.auditor.audit.abstracts.Auditable;
import com.jobber.ws.config.auditor.listener.abstracts.AuditListener;
import com.jobber.ws.config.auditor.listener.concretes.UserAuditListener;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@EntityListeners(value = {UserAuditListener.class})
public abstract class UserAuditable extends Auditable {

    @CreatedDate
    private Date createDate;

}
