package com.jobber.ws.model.entity.contact;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CONTACT")
public class Contact {
    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "contact"
    )
    Set<PhoneNumber> phoneNumbers;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "contact"
    )
    Set<Email> emails;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "contact"
    )
    Set<Address> addresses;
}
