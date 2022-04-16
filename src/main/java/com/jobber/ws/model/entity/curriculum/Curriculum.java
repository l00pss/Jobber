package com.jobber.ws.model.entity.curriculum;

import com.jobber.ws.model.entity.company.Vacancy;
import com.jobber.ws.model.entity.company.Company;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "CURRICULUM_VITAES")
public class Curriculum {
    @Id
    private Long id;

    @Column(name = "ABOUT") @Lob
    private String about;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "curriculum")
    private Set<Skill> skills;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "curriculum")
    private List<Experience> experienceList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "curriculum")
    private List<Education> educations;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "curriculum")
    private List<Certificate> certificates;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "curriculum")
    private Set<Hobby> hobbies;

}
