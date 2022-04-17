package com.jobber.ws.model.entity.company;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "RESPONSIBILITY")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Responsibility {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vacancy_id")
    private Vacancy vacancy;

    @Column(name = "PUNKT",nullable = false)
    @Size(min = 0,max = 350)
    private String punkt;
}
