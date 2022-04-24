package com.jobber.ws.model.entity.user;

import javax.persistence.*;

@Entity
@Table(name = "ROLES")
public class Role {
    enum RoleType {
        ROLE_WORKER("WORKER"),
        ROLE_EMPLOYER("EMPLOYER");

        String name;
        RoleType(String employer) {
            this.name=employer;
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE_NAME",length = 10,nullable = false,updatable = false,insertable = false)
    private RoleType name;

}
