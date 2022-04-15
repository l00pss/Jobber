package com.jobber.vacancy.side.response.success;

import com.jobber.vacancy.side.response.Response;

/**
 * @author Vugar Mammadli
 */
public final class SuccessResponse extends Response {
    public SuccessResponse() {
        super(true);
    }

    public SuccessResponse(String message) {
        super(true,message);
    }
}