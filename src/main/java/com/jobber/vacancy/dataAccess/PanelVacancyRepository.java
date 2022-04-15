package com.jobber.vacancy.dataAccess;

import com.jobber.vacancy.model.entity.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PanelVacancyRepository extends JpaRepository<Vacancy,Long>
{
}
