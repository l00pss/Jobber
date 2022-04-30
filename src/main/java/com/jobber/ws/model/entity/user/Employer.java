package com.jobber.ws.model.entity.user;


import com.jobber.ws.model.entity.company.Company;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "EMPLOYER")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public  class Employer extends User  {

    @Column(name = "ROLE",updatable = false,insertable = false,nullable = false)
    private static final String ROLE = Role.ROLE_EMPLOYER.get();

    @OneToOne
    private Company company;


}
