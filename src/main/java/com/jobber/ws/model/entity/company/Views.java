package com.jobber.ws.model.entity.company;



import com.jobber.ws.model.entity.user.User;
import com.jobber.ws.model.entity.user.Worker;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "VACANCY")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Views {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne
    private Vacancy vacancy;

    @ManyToOne
    private Worker worker;

    @Column(name = "VIEW_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date viewDate = new Date();




}
