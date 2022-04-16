package com.jobber.vacancy.model.sys;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@MappedSuperclass
public class Operation {
    @Id
    private BigInteger id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date timeStamp;

    @Lob
    private String operationName;
}
