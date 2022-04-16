package com.jobber.vacancy.dataAccess.vacancy;

import com.jobber.vacancy.model.entity.company.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobberVacancyRepository extends JpaRepository<Vacancy,Long>
{
}
