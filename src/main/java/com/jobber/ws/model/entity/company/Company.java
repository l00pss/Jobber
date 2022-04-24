package com.jobber.ws.model.entity.company;

import com.jobber.ws.model.entity.abstracts.FunctionVisibility;
import com.jobber.ws.model.entity.contact.Contact;
import com.jobber.ws.model.entity.other.Visibility;
import com.jobber.ws.model.entity.user.Worker;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "COMPANY")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public final class Company implements FunctionVisibility {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "IS_APPROVED",nullable = false)
    private boolean isApproved = false;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CONTEXT")
    private String context;

    @Column(name = "PROFILE_IMAGE")
    private String logo;

    @Column(name = "COVER_IMAGE")
    private String coverImage;

    @OneToMany(mappedBy = "company")
    List<Vacancy> vacancies;

    @OneToOne
    private Contact contact;

    @OneToOne
    private Visibility visibility = Visibility.ACTIVE;

    @ManyToMany
    private Set<Worker> referenced;

    @Override
    public boolean isAppropriate(){
        return this.visibility.isAppropriate();
    }
}
