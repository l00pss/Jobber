package com.jobber.ws.model.entity.curriculum;

import com.jobber.ws.model.entity.company.Vacancy;
import com.jobber.ws.model.entity.company.Company;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "CURRICULUM_VITAES")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
