package com.jobber.ws.model.entity.curriculum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "DEGREES")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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