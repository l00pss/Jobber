package com.jobber.ws.model.entity.user;


import com.jobber.ws.model.entity.company.Company;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Collection;

@Entity
@Table(name = "EMPLOYER")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public  class Employer extends User  {

//    @Column(name = "ROLE",updatable = false,insertable = false,nullable = false)
//    private static final String ROLE = "EMPLOYER";

    @OneToOne
    private Company company;

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
    }
}
