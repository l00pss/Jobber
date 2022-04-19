package com.jobber.ws.business;

import com.jobber.ws.core.exception.UnknownException;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
public class TestManager {

    @SneakyThrows(UnknownException.class)
    public void test(){
        throw new UnknownException();
    }


    public void test2() throws UnknownException {
        throw new UnknownException("Anormal xeyta");
    }
}
