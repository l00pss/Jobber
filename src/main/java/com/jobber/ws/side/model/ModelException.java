package com.jobber.ws.side.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "EXCEPTIONS")
@Getter @NoArgsConstructor @AllArgsConstructor
public class ModelException {
    @SequenceGenerator(name = "EX_GEN_SEQ",
            sequenceName = "EX_SEQ",
            allocationSize = 1
    )

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "EX_GEN_SEQ")
    private Long id;

    @Column(name = "NAME")
    private String exceptionName;

    @Column(name = "REPORTER")
    private String reporter;

    @Column(name = "STACK_TRACE") @Lob
    private String stackTrace;

    @Column(name = "LOCALIZED_MESSAGE")
    private String localizedMessage;

    @Column(name = "EXTENSION")
    private String extension;

    @Temporal(TemporalType.TIMESTAMP)
    private Date timeStamp = new Date();

    private ModelException(String exceptionName, String stackTrace,String localizedMessage,String reporter){
        this.exceptionName = exceptionName;
        this.stackTrace = stackTrace;
        this.localizedMessage = localizedMessage;
        this.reporter = reporter;
    }

    public static ModelException factory(String exceptionName, String stackTrace,String localizedMessage,String reporter){
        return new ModelException(exceptionName,stackTrace,localizedMessage,reporter);
    }

    public static ModelException factory(String exceptionName, String stackTrace,String localizedMessage){
        return new ModelException(exceptionName,stackTrace,localizedMessage,null);
    }


}
