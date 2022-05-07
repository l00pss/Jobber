package com.jobber.ws.modul.auditor.audit.concretes;

import com.jobber.ws.modul.auditor.audit.abstracts.Auditable;
import com.jobber.ws.modul.auditor.listener.concretes.ProfileAuditListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@EntityListeners(value = {ProfileAuditListener.class})
public abstract class ProfileAuditable extends Auditable {



}