package com.jobber.vacancy.model.entity.curriculum;

import com.jobber.vacancy.model.entity.company.Company;
import com.jobber.vacancy.model.entity.company.Vacancy;

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

    @OneToMany
    private Set<Skill> skills;

    @OneToMany
    private List<Experience> experienceList;

    @OneToMany
    private List<Education> educations;

    @OneToMany
    private List<Certificate> certificates;

    @OneToMany
    private Set<Hobby> hobbies;

}
