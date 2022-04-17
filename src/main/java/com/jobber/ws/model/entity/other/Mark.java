package com.jobber.ws.model.entity.other;


import com.jobber.ws.model.entity.company.Vacancy;
import com.jobber.ws.model.entity.user.Worker;

import javax.persistence.*;

@Entity
@Table(name = "MARKS")
public class Mark {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "worker_id")
    private Worker worker;

    @ManyToOne
    @JoinColumn(name = "vacancy_id")
    private Vacancy vacancy;
}
