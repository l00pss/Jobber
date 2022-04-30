package com.jobber.ws.modul.scheduler.concretes;

import com.jobber.ws.modul.scheduler.abstracts.SchedulService;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
@EnableAsync
public class VacancyDueDateSchedulManager implements SchedulService {

    @Async
    @Scheduled(cron = "@daily")
    @Override
    public void execute() {
        System.out.println(
                "midnight - " + System.currentTimeMillis() / 1000);

    }

}
