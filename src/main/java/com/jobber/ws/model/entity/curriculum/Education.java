package com.jobber.ws.model.entity.curriculum;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Education {
    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    //Ixtisasin adidir.
    @Column(name = "SUBJECT_OF_EDUCATION")
    private String subjectOfEducation;

    //Qurumun adi
    @Column(name = "NAME_OF_INSTITUTION")
    private String nameOfInstitution;

    @OneToOne
    private Degree degree;

    @Temporal(TemporalType.DATE)
    @Column(name = "EDUCATION_START_DATE")
    private Date experienceStartDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "EDUCATION_END_DATE")
    private Date experienceEndDate;

    @Column(name = "IS_DISTANT")
    private Boolean isDistant = false;
}