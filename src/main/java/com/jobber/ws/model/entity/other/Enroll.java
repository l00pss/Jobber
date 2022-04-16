package com.jobber.ws.model.entity.other;

import com.jobber.ws.model.entity.company.Vacancy;
import com.jobber.ws.model.entity.user.Worker;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

//Muraciet
@Entity
@Table(name = "ENROLL")
public class Enroll {
    @Id
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationDate;

    @OneToOne
    private Worker enrolledWorker;

    @ManyToOne
    private Vacancy ownVacancy;

    @Temporal(TemporalType.TIMESTAMP)
    private Date enrollDate = new Date();

    private boolean isActive = true;

    private boolean isDeleted = false;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Enroll)) return false;
        Enroll enroll = (Enroll) o;
        return id.equals(enroll.id) && enrolledWorker.equals(enroll.enrolledWorker) && ownVacancy.equals(enroll.ownVacancy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, enrolledWorker, ownVacancy);
    }
}