package com.jobber.ws.dataAccess.sys;

import com.jobber.ws.side.model.ModelException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExceptionRepository extends JpaRepository<ModelException,Long> {
}
