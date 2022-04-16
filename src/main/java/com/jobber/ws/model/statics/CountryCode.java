package com.jobber.ws.model.statics;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COUNTRY_CODE")
public class CountryCode {
    @Id
    private Long id;

    @Column(name = "REGION_NAME")
    private String regionName;

    @Column(name = "REGION_CODE")
    private String regionCode;
}
