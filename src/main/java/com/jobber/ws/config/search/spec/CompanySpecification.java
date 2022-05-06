package com.jobber.ws.config.search.spec;

import com.jobber.ws.model.entity.company.Company;
import com.jobber.ws.model.criteria.CompanySearchCritieria;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@RequiredArgsConstructor
public class CompanySpecification implements Specification<Company> {

    private final CompanySearchCritieria companySearchCritieria;

    @Override
    public Specification<Company> and(Specification<Company> other) {
        return Specification.super.and(other);
    }

    @Override
    public Specification<Company> or(Specification<Company> other) {
        return Specification.super.or(other);
    }

    @Override
    public Predicate toPredicate(Root<Company> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return null;
    }
}
