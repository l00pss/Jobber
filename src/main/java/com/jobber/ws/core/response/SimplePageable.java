package com.jobber.ws.core.response;

import lombok.Getter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Getter
public final class SimplePageable {
    private  Integer page  = 0;
    private  Integer size = 20;

    public Pageable factory(){
        return PageRequest.of(this.page,this.size);
    }
}
