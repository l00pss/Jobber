package com.jobber.ws.util.response.message;

import lombok.Getter;

@Getter
class MessageParam {

    private final String type;
    private final String messageCode;

    private MessageParam(String messageCode){
        String[] param = messageCode.split("_");
        this.type = param[0];
        this.messageCode = param[1];
    }

    public static MessageParam factory(String messageCode){
        return new MessageParam(messageCode);
    }

}
