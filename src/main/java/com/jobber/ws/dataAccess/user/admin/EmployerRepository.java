package com.jobber.ws.dataAccess.user.admin;

import com.jobber.ws.model.entity.other.Visibility;
import com.jobber.ws.model.entity.user.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRepository extends JpaRepository<Employer,Long> {

    Employer findByUsername(@Param("username") String username);

    Employer findByUsernameAndVisibility(@Param("username") String username, @Param("visibility") Visibility visibility);
}
