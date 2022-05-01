package com.jobber.ws.model.entity.company;



import com.jobber.ws.model.entity.user.User;
import com.jobber.ws.model.entity.user.Worker;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "VACANCY")
@Data
public class Views {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @ManyToOne
    @JoinColumn(name="vacancy_id")
    private Vacancy vacancy;

    @ManyToOne
    @JoinColumn(name="worker_id")
    private Worker worker;

    @Column(name = "VIEW_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date viewDate = new Date();




}
