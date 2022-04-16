package com.jobber.ws.business.search.spec;

import com.jobber.ws.model.entity.user.Worker;
import com.jobber.ws.business.search.criteria.WorkerSearchCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@RequiredArgsConstructor
public class WorkerSpecification implements Specification<Worker> {

    private final WorkerSearchCriteria criteria;

    @Override
    public Specification<Worker> and(Specification<Worker> other) {
        return Specification.super.and(other);
    }

    @Override
    public Specification<Worker> or(Specification<Worker> other) {
        return Specification.super.or(other);
    }

    @Override
    public Predicate toPredicate(Root<Worker> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return null;
    }
}
