package com.jobber.vacancy.dataAccess.company;

import com.jobber.vacancy.model.entity.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanelCompanyRepository extends JpaRepository<Company,Long> {
}
