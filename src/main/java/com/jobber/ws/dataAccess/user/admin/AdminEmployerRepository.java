package com.jobber.ws.dataAccess.user.admin;

import com.jobber.ws.model.entity.user.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminEmployerRepository extends JpaRepository<Employer,Long> {
}
