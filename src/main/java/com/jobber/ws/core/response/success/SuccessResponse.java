package com.jobber.ws.core.response.success;

import com.jobber.ws.core.response.Response;

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