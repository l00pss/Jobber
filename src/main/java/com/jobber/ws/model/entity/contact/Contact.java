package com.jobber.ws.model.entity.contact;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CONTACT")
public class Contact {
    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @JoinColumn(name = "contact_id")
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    Set<PhoneNumber> phoneNumbers;

    @JoinColumn(name = "contact_id")
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    Set<Email> emails;

    @JoinColumn(name = "contact_id")
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    Set<Address> addresses;
}
