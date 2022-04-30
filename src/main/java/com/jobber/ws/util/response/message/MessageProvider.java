package com.jobber.ws.util.response.message;

import lombok.Getter;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

@Component
class MessageProvider {

    static {

    }

    public String getMessage() {
        return  "Test Success Message";
    }

}
