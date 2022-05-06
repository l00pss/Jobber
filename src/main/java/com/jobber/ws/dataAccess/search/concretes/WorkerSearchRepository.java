package com.jobber.ws.dataAccess.search.concretes;

import com.jobber.ws.config.search.criteria.WorkerSearchQueryCriteriaConsumer;
import com.jobber.ws.dataAccess.qualifier.SearchRepository;
import com.jobber.ws.dataAccess.search.abstracts.WorkerSearchDataAccess;
import com.jobber.ws.model.criteria.WorkerSearchCriteria;
import com.jobber.ws.model.entity.user.Worker;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@SearchRepository
public class WorkerSearchRepository implements WorkerSearchDataAccess {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Worker> searchUser(List<WorkerSearchCriteria> params) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Worker> query = builder.createQuery(Worker.class);
        Root r = query.from(Worker.class);

        Predicate predicate = builder.conjunction();
        WorkerSearchQueryCriteriaConsumer searchConsumer =
                new WorkerSearchQueryCriteriaConsumer(predicate, builder, r);
        params.stream().forEach(searchConsumer);
        //predicate = searchConsumer.accept();
        query.where(predicate);

        List<Worker> result = entityManager.createQuery(query).getResultList();
        return result;
    }

    @Override
    public void save(Worker worker) {

    }
}
