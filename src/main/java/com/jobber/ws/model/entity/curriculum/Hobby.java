package com.jobber.ws.model.entity.curriculum;

import javax.persistence.*;

@Entity
@Table(name = "HOBBIES")
public class Hobby {
    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curriculum_id")
    private Curriculum curriculum;

    @Column(name = "CONTEXT")
    private String context;
}