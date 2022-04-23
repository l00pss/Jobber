package com.jobber.ws.dataAccess.user.common;

import com.jobber.ws.model.entity.user.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneralWorkerRepository extends JpaRepository<Worker,Long>, JpaSpecificationExecutor<Worker> {
}
