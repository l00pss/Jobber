package com.jobber.vacancy.model.entity.vacancy;

import com.jobber.vacancy.model.dto.request.NewVacancyDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Date;

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

    @Column(name = "MODIFICATION_DATE",nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationDate;

    @Column(name = "TITLE",nullable = false)
    private String title;

    @Column(name = "CONTEXT",nullable = false)
    private String context;

    @Column(name = "DUE_DATE",nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dueDate;

    @Column(name = "CREATE_DATE",nullable = false)
    @Temporal(TemporalType.DATE)
    private Date createDate = new Date();

    @Column(name = "IS_ACTIVE",nullable = false)
    private boolean isActive  = true;

    @Column(name = "IS_DELETED",nullable = false)
    private boolean isDeleted = false;

    public Vacancy(NewVacancyDTO vacancyDTO){
        this.modificationDate = new Date();
        this.title = vacancyDTO.getTitle();
        this.context = vacancyDTO.getContext();
        this.dueDate = vacancyDTO.getDueDate();
    }

    @Transactional
    public void delete() {
        isDeleted = true;
        isActive = false;
    }
}
