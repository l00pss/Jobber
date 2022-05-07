package com.jobber.ws.model.entity.company;

import com.jobber.ws.model.dto.request.NewVacancyDTO;
import com.jobber.ws.model.entity.abstracts.FunctionVisibility;
import com.jobber.ws.model.entity.other.Enroll;
import com.jobber.ws.model.entity.other.Mark;
import com.jobber.ws.model.entity.other.Visibility;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "VACANCY")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Vacancy implements FunctionVisibility {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;


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

    @Column(name = "IS_REMOTE",nullable = false)
    private boolean isRemote = false;

    @Column(name = "LOCALIZATION_ID",nullable = false)
    private Long localizationId = 0L;

    @OneToMany(mappedBy = "vacancy")
    @ToString.Exclude
    private Set<Enroll> enrolledWorkers;

    @OneToMany(mappedBy = "vacancy")
    private Set<Mark> marks;

    @OneToMany(mappedBy = "vacancy")
    private List<Views> views;

    @OneToOne
    private Visibility visibility;

    public Vacancy(NewVacancyDTO vacancyDTO){
        this.modificationDate = new Date();
        this.title = vacancyDTO.getTitle();
        this.opportunity = vacancyDTO.getContext();
        this.expiredDate = vacancyDTO.getDueDate();
    }

    public void delete() {
        this.visibility = Visibility.getInstance();
    }

    @Override
    public boolean isAppropriate(){
        return this.visibility.isAppropriate();
    }
}
