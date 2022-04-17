package com.jobber.ws.model.statics;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LOCALIZATION")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Localization {
    @Id
    private Long id;

    @Column(name = "COUNTRY_NAME")
    private String country;

    @Column(name = "CITY_NAME")
    private String city;
}
