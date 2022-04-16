package com.jobber.ws.model.entity.curriculum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DEGREES")
public class Degree {

    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "TYPE")
    private String typeOfDegree;
}