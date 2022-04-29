package com.jobber.ws.modul.scheduler;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
@EnableAsync
public abstract class SchedulingService {

    @Async
    @Scheduled(fixedRate = 1000)
    public void scheduleFixedRateTask() {
        System.out.println(
                "Fixed rate task - " + System.currentTimeMillis() / 1000);
    }

    @Async
    @Scheduled(fixedDelay = 1000, initialDelay = 1000)
    public abstract void scheduleFixedRateWithInitialDelayTask() ;

    @Async
    @Scheduled(cron = "0 15 10 15 * ?")
    public abstract void scheduleTaskUsingCronExpression() ;

}
