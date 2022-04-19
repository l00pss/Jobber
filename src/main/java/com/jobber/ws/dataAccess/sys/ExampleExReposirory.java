package com.jobber.ws.dataAccess.sys;

import com.jobber.ws.core.model.ModelException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExampleExReposirory extends JpaRepository<ModelException,Long> {
}
