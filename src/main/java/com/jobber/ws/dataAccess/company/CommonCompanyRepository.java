package com.jobber.ws.dataAccess.company;

import com.jobber.ws.model.entity.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CommonCompanyRepository extends JpaRepository<Company,Long>, JpaSpecificationExecutor<Company> {
}
