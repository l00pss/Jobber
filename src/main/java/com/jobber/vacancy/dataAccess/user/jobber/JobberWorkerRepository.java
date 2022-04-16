package com.jobber.vacancy.dataAccess.user.jobber;

import com.jobber.vacancy.model.entity.user.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobberWorkerRepository extends JpaRepository<Worker,Long> {
}
