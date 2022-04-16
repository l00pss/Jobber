package com.jobber.vacancy.dataAccess.user.panel;


import com.jobber.vacancy.model.entity.user.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanelWorkerRepository extends JpaRepository<Worker,Long> {
}
