package com.jobber.ws.model.entity.user;

import com.jobber.ws.model.entity.company.Company;
import com.jobber.ws.model.entity.company.Vacancy;
import com.jobber.ws.model.entity.company.Views;
import com.jobber.ws.model.entity.curriculum.Curriculum;
import com.jobber.ws.model.entity.other.Enroll;
import com.jobber.ws.model.entity.other.Mark;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "WORKER")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public final class Worker extends User implements Comparable<Worker> {

    @Column(name = "ROLE",updatable = false,insertable = false,nullable = false)
    private static final String ROLE = "WORKER";

    @Column(name = "IS_APPROVED",nullable = false)
    private boolean isApproved = false;

    @OneToOne
    private Curriculum curriculum;

    @OneToMany(mappedBy = "enrolledWorker")
    private Set<Enroll> enrolls;

    @OneToMany(mappedBy = "worker")
    private Set<Mark> marks;

    @OneToMany
    private List<Views> views;

    @ManyToMany
    private Set<Company> references;



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    } //WORKER

    @Override
    //TODO Implementasiya yazilmalidir
    public int compareTo(@NotNull Worker o) {
        return 0;
    }
}
