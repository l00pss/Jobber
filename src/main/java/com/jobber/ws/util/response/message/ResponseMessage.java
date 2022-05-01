package com.jobber.ws.util.response.message;


public enum ResponseMessage {
    CLIENT_ERROR("ClientErrorResponse.json"),
    INFORMATION("InformationalResponse.json") ,
    REDIRECTION("RedirectionResponse.json"),
    SERVER_ERROR("ServerErrorResponse.json"),
    SUCCESSFUL("SuccessfulResponse.json");

    private static final String MAIN_PATH = "src/main/java/com/jobber/ws/util/response/message/context/";

    private static final MessageProvider messageProvider = new MessageProvider();

    public String get(String messageCode){
        MessageParam param = MessageParam.factory(messageCode);
        return messageProvider.getMessage(param);
    };

    public String getPath() {
        return MAIN_PATH.concat(path);
    }

    final String path;

    ResponseMessage(String s) {
        this.path = s;
    }


}