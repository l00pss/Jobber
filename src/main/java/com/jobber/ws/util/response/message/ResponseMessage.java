package com.jobber.ws.util.response.message;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public enum ResponseMessage {
    CLIENT_ERROR("ClientErrorResponse.json"),
    INFORMATION("InformationalResponse.json") ,
    REDIRECTION("RedirectionResponse.json"),
    SERVER_ERROR("ServerErrorResponse.json"),
    SUCCESSFUL("SuccessfulResponse.json");

    private static final String MAIN_PATH = "src/main/java/com/jobber/ws/core/response/message/context/";

    private  MessageProvider messageProvider = new MessageProvider();

    public String get(String messageCode){
        MessageParam param = MessageParam.factory(MAIN_PATH + this.path,messageCode);
        return messageProvider.getMessage();
    };

    final String path;

    ResponseMessage(String s) {
        this.path = s;
    }

}