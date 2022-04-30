package com.jobber.ws.util.response.message;

import lombok.Getter;
import org.springframework.stereotype.Service;

@Getter
public class Message {
    private String code;
    private String message;

    public Message(String code,String message){
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                "}\n";
    }
}
