package com.jobber.ws.dataAccess.vacancy;

import com.jobber.ws.model.entity.company.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PanelVacancyRepository extends JpaRepository<Vacancy,Long>
{
    @Query(value =
            "SELECT v from Vacancy v " +
                    "where v.id =: id " +
                    "and v.isDeleted=false " +
                    "and v.isActive = true"
    )
    Vacancy getByIdAndDeletedFalseAndActiveTrue(@Param("id") Long id);


    @Query(value =
            "SELECT v from Vacancy v " +
                    "where v.id =: id " +
                    "and v.isDeleted=false "
    )
    Vacancy getByIdAndDeletedFalse(@Param("id") Long id);

    @Query(value =
            "SELECT v from Vacancy v " +
                    "where v.id =: id " +
                    "and v.isDeleted=false " +
                    "and v.isActive = true"
    )
    List<Vacancy> getAllByDeletedFalseAndActiveTrue();
}