package com.jobber.ws.util.response.message;

import lombok.Getter;

@Getter
class MessageParam {

    private final String type;
    private final String messageCode;

    private MessageParam(String messageCode){
        if(messageCode.length()>=10){
            String[] param = messageCode.split("_");
            this.type = param[0];
            this.messageCode = param[1];
        }else {
            this.type = "500";
            this.messageCode = "000001";
        }
    }

    public static MessageParam factory(String messageCode){
        return new MessageParam(messageCode);
    }

    @Override
    public String toString() {
        return this.getType().concat("_").concat(this.getMessageCode());
    }
}
