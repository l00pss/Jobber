package com.jobber.ws.model.statics;

import com.jobber.ws.model.entity.curriculum.position.SupPosition;

import javax.persistence.*;

@Entity
@Table(name = "DEFAULT_POSITION")
public class DefaultPosition extends SupPosition {

    @Id
    @GeneratedValue
    private Long id;
}