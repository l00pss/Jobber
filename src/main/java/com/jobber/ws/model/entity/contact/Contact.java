package com.jobber.ws.model.entity.contact;

import com.jobber.ws.model.entity.user.UserProfile;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CONTACT")
@Data
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="profile_id", nullable=false)
    private UserProfile profile;

    @OneToMany(mappedBy = "contact")
    List<PhoneNumber> phoneNumbers;

    @OneToMany(mappedBy = "contact")
    List<Email> emails;

    @OneToMany(mappedBy = "contact")
    List<Address> addresses;
}
