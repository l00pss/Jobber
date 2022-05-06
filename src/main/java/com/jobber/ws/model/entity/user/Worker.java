package com.jobber.ws.model.entity.user;

import com.jobber.ws.model.entity.company.Company;
import com.jobber.ws.model.entity.company.Views;
import com.jobber.ws.model.entity.curriculum.Curriculum;
import com.jobber.ws.model.entity.other.Enroll;
import com.jobber.ws.model.entity.other.Mark;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "WORKER")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public final class Worker extends JUser implements Comparable<Worker> {

    @Column(name = "ROLE",updatable = false,length = 12)
    @Enumerated(EnumType.ORDINAL)
    private  Role role = Role.WORKER;

    @Column(name = "IS_APPROVED",nullable = false)
    private boolean isApproved = false;

    @OneToOne
    private Curriculum curriculum;

    @OneToMany(mappedBy = "enrolledWorker")
    private Set<Enroll> enrolls;

    @OneToMany(mappedBy = "worker")
    private Set<Mark> marks;

    @OneToMany(mappedBy = "worker")
    private List<Views> views;

    @ManyToMany
    private Set<Company> references;


    @Override
    //TODO Implementasiya yazilmalidir
    public int compareTo(@NotNull Worker o) {
        return 0;
    }

}
