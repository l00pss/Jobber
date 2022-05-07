package com.jobber.ws.modul.scheduler.concretes;

import com.jobber.ws.modul.scheduler.abstracts.SchedulService;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDate;


public class VacancyDueDateSchedulManager implements SchedulService {

    @Async
    @Scheduled(cron = "@daily")
    @Override
    public void execute() {
        System.out.println("Daily - " + LocalDate.now());
    }

}
