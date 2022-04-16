package com.jobber.vacancy.model.entity.user;

import com.jobber.vacancy.model.entity.curriculum.Curriculum;
import com.jobber.vacancy.model.entity.other.Enroll;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "WORKER")
@Getter
@AllArgsConstructor
@NoArgsConstructor

public final class Worker extends User  implements UserDetails {

    @OneToOne
    private Curriculum curriculum;

    @OneToMany
    private Set<Enroll> enrolls;

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

}
