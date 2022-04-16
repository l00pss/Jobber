package com.jobber.vacancy.model.entity.other;

import com.jobber.vacancy.model.entity.company.Vacancy;

import javax.persistence.*;
import java.util.Date;

//Muraciet
@Entity
@Table(name = "ENROLL")
public class Enroll {
    @Id
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationDate;

    @ManyToOne
    private Vacancy ownVacancy;

    @Temporal(TemporalType.TIMESTAMP)
    private Date enrollDate = new Date();

    private boolean isActive = true;

    private boolean isDeleted = false;
}
