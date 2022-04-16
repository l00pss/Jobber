package com.jobber.ws.model.dto.request;

import lombok.Getter;

import java.util.Date;


@Getter
public final class NewVacancyDTO {

    private final Date modificationDate = new Date();

    private  String title;

    private  String context;

    private  Date dueDate;


}
