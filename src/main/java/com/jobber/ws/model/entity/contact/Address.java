package com.jobber.ws.model.entity.contact;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESSES")
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="contact_id", nullable=false)
    private Contact contact;

    @Column(name = "COUNTRY")
    private String country = "Azerbaijan";

    @Column(name = "CITY", nullable = false)
    private String city;

    @Column(name = "STREET_AND_FLOOR")
    private String streetAndFloor;

}