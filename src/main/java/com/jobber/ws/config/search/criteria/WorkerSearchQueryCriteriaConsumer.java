package com.jobber.ws.config.search.criteria;

import com.jobber.ws.model.criteria.WorkerSearchCriteria;
import org.jetbrains.annotations.NotNull;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;
import java.util.function.Consumer;
import javax.persistence.criteria.Predicate;

public class WorkerSearchQueryCriteriaConsumer implements Consumer<WorkerSearchCriteria> {

    private final Predicate predicate;
    private final CriteriaBuilder builder;
    private final Root<WorkerSearchCriteria> r;


    public WorkerSearchQueryCriteriaConsumer(javax.persistence.criteria.Predicate predicate, CriteriaBuilder builder, Root r) {
        this.predicate = predicate;
        this.builder = builder;
        this.r = r;
    }

    @Override
    public void accept(WorkerSearchCriteria workerSearchCriteria) {

    }

    @NotNull
    @Override
    public Consumer<WorkerSearchCriteria> andThen(@NotNull Consumer<? super WorkerSearchCriteria> after) {
        return Consumer.super.andThen(after);
    }
}
