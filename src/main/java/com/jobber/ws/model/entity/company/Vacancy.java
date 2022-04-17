package com.jobber.ws.model.entity.company;

import com.jobber.ws.model.dto.request.NewVacancyDTO;
import com.jobber.ws.model.entity.other.Enroll;
import com.jobber.ws.model.entity.other.Mark;
import com.jobber.ws.model.statics.Localization;
import lombok.*;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "VACANCY")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Vacancy {
    @SequenceGenerator(name = "VACANCY_GEN_SEQ",
            sequenceName = "GENERAL_SEQ",
            allocationSize = 100,
            initialValue = 3
    )

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "VACANCY_GEN_SEQ")
    private Long id;


    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @Column(name = "MODIFICATION_DATE",nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationDate;

    @Column(name = "TITLE",nullable = false)
    private String title;

    @Column(name = "CONTEXT",nullable = false)
    private String opportunity;

    @OneToMany(mappedBy = "vacancy")
    private List<Responsibility> responsibility;

    @OneToOne(mappedBy = "vacancy")
    private Salary salary;

    @Column(name = "DUE_DATE",nullable = false)
    @Temporal(TemporalType.DATE)
    private Date expiredDate;

    @Column(name = "CREATE_DATE",nullable = false)
    @Temporal(TemporalType.DATE)
    private Date createDate = new Date();

    @Column(name = "IS_ACTIVE",nullable = false)
    private boolean isActive  = true;

    @Column(name = "IS_DELETED",nullable = false)
    private boolean isDeleted = false;

    @Column(name = "IS_REMOTE",nullable = false)
    private boolean isRemote = false;

    private Long localizationId = 0L;

    @OneToMany(mappedBy = "vacancy")
    @ToString.Exclude
    private Set<Enroll> enrolledWorkers;

    @OneToMany(mappedBy = "vacancy")
    private Set<Mark> marks;

    @OneToMany
    private List<Views> views;



    public Vacancy(NewVacancyDTO vacancyDTO){
        this.modificationDate = new Date();
        this.title = vacancyDTO.getTitle();
        this.opportunity = vacancyDTO.getContext();
        this.expiredDate = vacancyDTO.getDueDate();
    }

    @Transactional
    public void delete() {
        this.isDeleted = true;
        this.isActive = false;
    }
}
