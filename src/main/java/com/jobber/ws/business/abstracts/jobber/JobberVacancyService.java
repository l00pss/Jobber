package com.jobber.ws.business.abstracts.jobber;

import com.jobber.ws.core.response.Response;

public interface JobberVacancyService {

    Response deleteHard(Long vacancyId);
    Response deleteSimple(Long vacancyId);

}
