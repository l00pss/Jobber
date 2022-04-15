package com.jobber.vacancy.dataAccess;

import com.jobber.vacancy.model.entity.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobberVacancyRepository extends JpaRepository<Vacancy,Long>
{
}
