package com.jobber.ws.model.entity.user;

import com.jobber.ws.model.dto.credential.RegisterCredential;
import com.jobber.ws.model.entity.contact.Contact;
import lombok.*;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "USE_PROFILE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @LastModifiedDate
    @Column(name = "MODIFICATION_DATE")
    private long modifiedDate;

    @Column(name = "NAME",nullable = false)
    private String name;

    @Column(name = "LAST_NAME",nullable = false)
    private String lastName;

    @Column(name = "EMAIL_OF_USER",unique = true)
    private String email;

    @Column(name = "BIRTHDAY")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @OneToMany(mappedBy = "profile",cascade = CascadeType.ALL)
    private List<Contact> contacts;

    @Column(name = "PROFILE_IMAGE")
    @Lob
    private String profileImage;

    @Column(name = "COVER_IMAGE")
    @Lob
    private String coverImage;

    @OneToOne
    private UserSettings settings;

    @Column(name = "IS_PREMIUM")
    private Boolean isPremiumAccount = false;

    public UserProfile(RegisterCredential registerCredential){
        super();
        this.name = registerCredential.getName();
        this.lastName = registerCredential.getLastName();
        this.email  = registerCredential.getEmail();
    }
}
