package com.jobber.ws.modul.scheduler.abstracts;

/**
 *  0 0 * * * * kimi ifadələri təhlil etmək insanlar üçün çətindir və
 *  * Buna görə də, səhv halında da düzəltmək çətin ola bilir. Oxumağı yaxşılaşdırmaq üçün,
 *  * Spring indi tez-tez istifadə olunan ardıcıllığı təmsil edən aşağıdakı makroları dəstəkləyir.
 *  * Siz altı rəqəmli dəyər əvəzinə bu makrolardan istifadə edə bilərsiniz. <br>Nümunə:
 *  * @Scheduled(cron = "@hourly").
 * <br>
 * <blockquote>
 * <p>'@yearly (or @ annually) - once a year (0 0 0 1 1 *) <br>
 * '@monthly - once a month (0 0 0 1 * *)<br>
 * '@weekly - once a week (0 0 0 * * 0)<br>
 * '@daily (or @ midnight) - once a day (0 0 0 * * *), or<br>
 * '@hourly - once an hour, (0 0 * * * *)<br>
 * </p>
 * </blockquote>
 * @see org.springframework.scheduling.support.CronExpression
 * @author Vugar Mammadli
 */

public  interface SchedulService {

    void execute();

    /**
     * Scheduled(fixedRate = 1000) Hər saniyə üçün
     */
    default void scheduleFixedRateTask() {}

    /**
     * Scheduled(fixedDelay = 1000, initialDelay = 1000)
     */
    default   void scheduleFixedRateWithInitialDelayTask() {};

    /**
     * Scheduled(cron = "0 0 23-24 * * *")  - Hər gün gecə 11 12 üçün
     */
    default   void scheduleTaskUsingCronExpression() {} ;

    /**
     * Scheduled(cron = "0 0 0 25 12 ?")  - Ildə bir dəfə Dekabr
     */
    default   void scheduleTaskUsingWithOnceOnLastOfYear() {} ;


}
