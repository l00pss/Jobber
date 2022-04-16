package com.jobber.vacancy.model.sys;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SESSION_KEY")
public class SessionKey {
    @Id
    private Long id;
}
