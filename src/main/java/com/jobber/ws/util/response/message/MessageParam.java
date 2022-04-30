package com.jobber.ws.util.response.message;

public class MessageParam {
    private final String messageFilePath;
    private final String messageCode;

    private MessageParam(String messageFilePath,String messageCode){
        this.messageFilePath = messageFilePath;
        this.messageCode = messageCode;
    }

    public static MessageParam factory(String messageFilePath,String messageCode){
        return new MessageParam(messageFilePath,messageCode);
    }

}
