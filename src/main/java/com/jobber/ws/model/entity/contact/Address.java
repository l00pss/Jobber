package com.jobber.ws.model.entity.contact;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESSES")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @ManyToOne(targetEntity = Contact.class,fetch = FetchType.LAZY)
    @JoinColumn(name="contact_id", nullable=false)
    private Contact contact;

    @Column(name = "COUNTRY")
    private String country = "Azerbaijan";

    @Column(name = "CITY", nullable = false)
    private String city;

    @Column(name = "STREET_AND_FLOOR")
    private String streetAndFloor;

}