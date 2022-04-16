package com.jobber.vacancy.model.entity.company;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "COMPANY")
public final class Company {
    @Id
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CONTEXT")
    private String context;

    @Column(name = "PROFILE_IMAGE")
    private String logo;

    @Column(name = "COVER_IMAGE")
    private String coverImage;

    @OneToMany
    List<Vacancy> vacancies;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;
}
