package com.jobber.ws.model.entity.curriculum.position;

import javax.persistence.*;

@Entity(name = "POSITION")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Position {
    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    


}