package com.jobber.ws.util.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public final class SimplePageable {
    private  Integer page  = 0;
    private  Integer size = 20;

    public Integer getPage() {
        if(this.page==0)
            return 1;
        else return ++this.page;
    }

    public Integer startIndex(){
        return this.getPage() * this.getSize() - this.getSize();
    }

    public Integer endIndex(){
        return this.getPage() * this.getSize();
    }

    public Pageable factory(){
        return PageRequest.of(this.page,this.size);
    }
}
