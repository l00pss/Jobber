package com.jobber.vacancy.model.dto.request;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;


@Getter
public final class NewVacancyDTO {

    private final Date modificationDate = new Date();

    private  String title;

    private  String context;

    private  Date dueDate;


}
