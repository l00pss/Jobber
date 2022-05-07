package com.jobber.ws.config.auditor.audit.concretes;

import com.jobber.ws.config.auditor.audit.abstracts.Auditable;
import com.jobber.ws.config.auditor.listener.concretes.ProfileAuditListener;
import com.jobber.ws.config.auditor.listener.concretes.UserAuditListener;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@EntityListeners(value = {ProfileAuditListener.class})
public abstract class ProfileAuditable extends Auditable {



}