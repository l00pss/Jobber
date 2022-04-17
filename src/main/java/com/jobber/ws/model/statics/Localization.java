package com.jobber.ws.model.statics;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LOCALIZATION")
public class Localization {
    @Id
    private Long id;

    @Column(name = "COUNTRY_NAME")
    private String country;

    @Column(name = "CITY_NAME")
    private String city;
}
