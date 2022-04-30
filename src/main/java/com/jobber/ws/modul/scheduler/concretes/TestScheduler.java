package com.jobber.ws.modul.scheduler.concretes;


import com.jobber.ws.modul.scheduler.abstracts.SchedulService;
import com.jobber.ws.util.response.message.ResponseMessage;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
@EnableAsync
public class TestScheduler implements SchedulService {

    @Async
    @Scheduled(fixedDelay = 1000)
    @Override
    public void execute() {
        System.out.println(ResponseMessage.SUCCESSFUL.get("200_100001"));
    }

}
