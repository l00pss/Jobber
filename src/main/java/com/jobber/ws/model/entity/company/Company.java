package com.jobber.ws.model.entity.company;

import com.jobber.ws.model.entity.contact.Contact;
import com.jobber.ws.model.entity.user.Worker;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

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

    @OneToMany(mappedBy = "company")
    List<Vacancy> vacancies;

    @OneToOne
    private Contact contact;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

    @ManyToMany
    private Set<Worker> referenced;
}
