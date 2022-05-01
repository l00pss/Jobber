package com.jobber.ws.model.entity.other;

import com.jobber.ws.model.entity.company.Vacancy;
import com.jobber.ws.model.entity.user.Worker;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

//Muraciet
@Entity
@Table(name = "ENROLL")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Enroll {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationDate;

    @ManyToOne
    @JoinColumn(name = "worker_id")
    private Worker enrolledWorker;

    @ManyToOne
    @JoinColumn(name = "vacancy_id")
    private Vacancy vacancy;

    @Temporal(TemporalType.TIMESTAMP)
    private Date enrollDate = new Date();

    private boolean isActive = true;

    private boolean isDeleted = false;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Enroll)) return false;
        Enroll enroll = (Enroll) o;
        return id.equals(enroll.id) && enrolledWorker.equals(enroll.enrolledWorker) && vacancy.equals(enroll.vacancy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, enrolledWorker, vacancy);
    }
}
