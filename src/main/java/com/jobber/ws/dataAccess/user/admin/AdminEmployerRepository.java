package com.jobber.ws.dataAccess.user.admin;

import com.jobber.ws.model.entity.other.Visibility;
import com.jobber.ws.model.entity.user.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import java.util.UUID;

@Repository
public interface AdminEmployerRepository extends JpaRepository<Employer, UUID> {

    @Lock(LockModeType.READ)
    Employer findByUsername(@Param("username") String username);

    Employer findByUsernameAndVisibility(@Param("username") String username, @Param("visibility") Visibility visibility);
}
