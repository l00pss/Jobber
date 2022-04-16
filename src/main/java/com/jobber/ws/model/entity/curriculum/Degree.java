package com.jobber.ws.model.entity.curriculum;

import javax.persistence.*;

@Entity
@Table(name = "DEGREES")
public class Degree {

    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "education_id")
    private Education education;

    @Column(name = "TYPE")
    private String typeOfDegree;
}