package com.jobber.ws.dataAccess.vacancy;

import com.jobber.ws.model.entity.company.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobberVacancyRepository extends JpaRepository<Vacancy,Long>
{
}
