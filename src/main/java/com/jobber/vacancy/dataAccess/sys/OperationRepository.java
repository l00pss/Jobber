package com.jobber.vacancy.dataAccess.sys;

import com.jobber.vacancy.model.sys.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationRepository extends JpaRepository<Operation,Long> {
}
