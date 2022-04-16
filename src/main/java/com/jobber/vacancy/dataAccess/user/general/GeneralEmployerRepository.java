package com.jobber.vacancy.dataAccess.user.general;

import com.jobber.vacancy.model.entity.user.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneralEmployerRepository extends JpaRepository<Employer,Long>, JpaSpecificationExecutor<Employer> {
}
