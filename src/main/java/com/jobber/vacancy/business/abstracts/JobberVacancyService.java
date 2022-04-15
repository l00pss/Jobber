package com.jobber.vacancy.business.abstracts;

import com.jobber.vacancy.side.response.Response;

public interface JobberVacancyService {

    Response deleteHard(Long vacancyId);
    Response deleteSimple(Long vacancyId);

}
