package com.jobber.ws.business.abstracts.jobber;

import com.jobber.ws.side.response.Response;

public interface JobberVacancyService {

    Response deleteHard(Long vacancyId);
    Response deleteSimple(Long vacancyId);

}
