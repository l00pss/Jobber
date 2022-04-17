package com.jobber.ws.model.entity.company;



import com.jobber.ws.model.entity.user.Worker;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "VACANCY")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Views {
    @Id
    private Long id;

    @ManyToOne
    private Vacancy vacancy;

    @ManyToOne
    private Worker worker;

    @Column(name = "VIEW_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date viewDate = new Date();




}
