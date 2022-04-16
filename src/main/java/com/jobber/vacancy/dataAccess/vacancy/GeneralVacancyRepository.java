package com.jobber.vacancy.dataAccess.vacancy;

import com.jobber.vacancy.model.entity.company.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneralVacancyRepository extends JpaRepository<Vacancy,Long> , JpaSpecificationExecutor<Vacancy>
{
    Vacancy  getById(Long id);

    @Query(
            "SELECT v from Vacancy v " +
                    "where v.id =: id " +
                    "and v.isDeleted=false " +
                    "and v.isActive = true"
    )
    Vacancy getByIdAndDeletedFalseAndActiveTrue(@Param("id") Long id);




}
