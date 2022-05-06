package com.jobber.ws.dataAccess.search.abstracts;

import com.jobber.ws.model.criteria.WorkerSearchCriteria;
import com.jobber.ws.model.entity.user.Worker;

import java.util.List;

public interface WorkerSearchDataAccess {
    List<Worker> searchUser(List<WorkerSearchCriteria> params) ;
    void save(Worker worker);
}
