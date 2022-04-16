package com.jobber.ws.model.entity.curriculum.position;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "POSITION")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Position {
    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "POSITION_NAME",nullable = false)
    private String name;

}