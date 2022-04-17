package com.jobber.ws.model.entity.curriculum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import javax.validation.constraints.Size;

@Entity
@Table(name = "SKILLS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Skill {
    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curriculum_id")
    private Curriculum curriculum;

    @Column(name = "NAME_OF_SKILL")
    @Size(min = 3,max = 30)
    private String nameOfSkill;

    @Column(name = "RATING")
    @Size(min = 0,max = 5)
    private int rating;
}