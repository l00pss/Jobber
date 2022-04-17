package com.jobber.ws.model.entity.company;

import lombok.*;

import javax.persistence.*;

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

    @Column(name = "CONTEXT",nullable = false)
    private String context;
}
