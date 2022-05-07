package com.jobber.ws.dataAccess.sys;

import com.jobber.ws.util.model.Log;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.concurrent.CompletableFuture;

@Repository
public interface LogRepository extends CrudRepository<Log,Long> {

    @Override
    @Async
    <S extends Log> @NotNull S save(S entity);
}
