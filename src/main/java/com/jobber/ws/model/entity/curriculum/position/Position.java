package com.jobber.ws.model.entity.curriculum.position;

import com.jobber.ws.model.entity.curriculum.Experience;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "POSITION")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Position {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Experience experience;

    private Long defaultPositionId = 0L;

    @Column(name = "CONTEXT")
    private String context;

    public void setContext(String context) {
        this.context = context;
        this.defaultPositionId = 0L;
    }

    public void setDefaultPositionId(Long defaultPositionId) {
        this.defaultPositionId = defaultPositionId;
        this.context  = null;
    }
}