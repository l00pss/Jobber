package com.jobber.ws.dataAccess.sys;

import com.jobber.ws.model.sys.SessionKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository<SessionKey,Long> {
}
