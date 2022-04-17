package com.jobber.ws.model.entity.curriculum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CERTIFICATES")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Certificate {
    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curriculum_id")
    private Curriculum curriculum;

    @Column(name = "NAME_OF_INSTITUTION")
    private String nameOfInstitution;

    @Column(name = "NAME_OF_CERTIFICATE")
    private String nameOfCertificate;

    @Column(name = "CONTEXT")
    private String context;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_OF_CERTIFICATE")
    private Date dateOfCertificate;

}