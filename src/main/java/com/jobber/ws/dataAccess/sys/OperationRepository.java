package com.jobber.ws.dataAccess.sys;

import com.jobber.ws.model.sys.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationRepository extends JpaRepository<Operation,Long> {
}
