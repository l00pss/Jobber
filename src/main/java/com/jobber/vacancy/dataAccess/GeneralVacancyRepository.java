package com.jobber.vacancy.dataAccess;

import com.jobber.vacancy.model.entity.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeneralVacancyRepository extends JpaRepository<Vacancy,Long>
{
    Vacancy  getById(Long id);

    Vacancy getByIdAndDeletedFalseAndActiveTrue(Long id);

    List<Vacancy> getAllByDeletedFalseAndActiveTrue();


}
