package com.jobber.ws.model.entity.user;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "GUEST")
public class Guest {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @Column(name = "VISIT_COUNT")
    private Integer visitCount = 0;

    @OneToOne
    private UserSettings userSettings;


}
