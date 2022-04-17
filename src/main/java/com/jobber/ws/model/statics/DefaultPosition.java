package com.jobber.ws.model.statics;

import javax.persistence.*;

@Entity
@Table(name = "DEFAULT_POSITION")
public class DefaultPosition {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "CONTEXT")
    private String context;


}