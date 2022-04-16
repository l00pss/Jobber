package com.jobber.ws.model.entity.curriculum.position;

import javax.persistence.*;

@Entity(name = "POSITION")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class OtherPosition extends SupPosition {
    @Id
    @Column(name = "ID", nullable = false)
    private Long id;



    @Column(name = "POSITION_NAME",nullable = false)
    private String name;


}