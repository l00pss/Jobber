package com.jobber.ws.dataAccess.user.admin;


import com.jobber.ws.model.entity.other.Visibility;
import com.jobber.ws.model.entity.user.Employer;
import com.jobber.ws.model.entity.user.User;
import com.jobber.ws.model.entity.user.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<Worker,Long> {
    Worker findByUsername(@Param("username") String username);
    Worker findByUsernameAndVisibility(@Param("username") String username, @Param("visibility") Visibility visibility);
}
