package com.jobber.ws.service.abstracts.jobber;

import com.jobber.ws.util.response.Response;

public interface JobberVacancyService {

    Response deleteHard(Long vacancyId);
    Response deleteSimple(Long vacancyId);

}
