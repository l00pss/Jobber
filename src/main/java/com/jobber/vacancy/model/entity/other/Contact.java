package com.jobber.vacancy.model.entity.other;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONTACT")
public class Contact {
    @Id
    private Long id;
}
