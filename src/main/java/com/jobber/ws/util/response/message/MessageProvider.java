package com.jobber.ws.util.response.message;

import lombok.Getter;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
@Getter
public class MessageProvider {
    public String getMessage() {
        return  "Test Success Message";
    }

}
