package com.jobber.ws.util.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;

@Entity
@Table(name = "LOGS")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Log {
    @Id
    @Column(name = "ID")
    private Long id;

    private String operation;

    private String context;

    public Log(String operation,String context){
        this();
        this.operation= operation;
        this.context = context;
    }
}
