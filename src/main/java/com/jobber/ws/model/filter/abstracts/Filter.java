package com.jobber.ws.model.filter.abstracts;

public abstract class Filter {
    public abstract boolean name(String name);
    public abstract  boolean fromVacancyCount(Integer vacancyFromCount);
    public abstract  boolean toVacancyCount(Integer vacancyFromCount);
}
