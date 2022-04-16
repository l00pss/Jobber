package com.jobber.ws.model.entity.curriculum;

import com.jobber.ws.model.entity.company.Vacancy;
import com.jobber.ws.model.entity.company.Company;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "CURRICULUM_VITAE")
public class Curriculum {
    @Id
    private Long id;

    @ManyToMany
    private Set<Vacancy> enrolledVacancy;

    @OneToMany
    private Set<Company> references;

    @Column(name = "ABOUT") @Lob
    private String about;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "curriculum")
    private Set<Skill> skills;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "curriculum")
    private List<Experience> experienceList;

    @OneToMany
    private List<Education> educations;

    @OneToMany
    private List<Certificate> certificates;

    @OneToMany
    private Set<Hobby> hobbies;

}
