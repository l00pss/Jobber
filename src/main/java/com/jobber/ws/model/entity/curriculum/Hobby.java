package com.jobber.ws.model.entity.curriculum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "HOBBIES")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hobby {
    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curriculum_id")
    private Curriculum curriculum;

    @Column(name = "CONTEXT")
    private String context;
}