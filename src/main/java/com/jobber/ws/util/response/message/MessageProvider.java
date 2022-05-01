package com.jobber.ws.util.response.message;

import com.google.gson.stream.JsonReader;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Component
class MessageProvider {

    private static final Map<String,String> INFORMATION_MESSAGES = new HashMap<>();
    private static final Map<String,String> SUCCESS_MESSAGES = new HashMap<>();
    private static final Map<String,String> REDIRECTION_MESSAGES = new HashMap<>();
    private static final Map<String,String> CLIENT_ERROR_MESSAGES = new HashMap<>();
    private static final Map<String,String> SERVER_ERROR_MESSAGES = new HashMap<>();

    private static final Map<String,Map<String,String>> MESSAGES_MAP_LIST = new HashMap<>();

    static {
        MESSAGES_MAP_LIST.putIfAbsent(ResponseMessage.CLIENT_ERROR.getPath(),MessageProvider.CLIENT_ERROR_MESSAGES);
        MESSAGES_MAP_LIST.putIfAbsent(ResponseMessage.INFORMATION.getPath(), MessageProvider.INFORMATION_MESSAGES);
        MESSAGES_MAP_LIST.putIfAbsent(ResponseMessage.SUCCESSFUL.getPath(), MessageProvider.SUCCESS_MESSAGES);
        MESSAGES_MAP_LIST.putIfAbsent(ResponseMessage.REDIRECTION.getPath(), MessageProvider.REDIRECTION_MESSAGES);
        MESSAGES_MAP_LIST.putIfAbsent(ResponseMessage.SERVER_ERROR.getPath(), MessageProvider.SERVER_ERROR_MESSAGES);
    }

    static {
        var keys = MESSAGES_MAP_LIST.entrySet();
        for (Map.Entry<String,Map<String,String>> entry : keys){
            InputStream inputstream = null;
            try {
                System.err.println(entry.getKey());
                File file = new File(entry.getKey());
                inputstream = new FileInputStream(file);
                readJsonStream(entry.getValue(),inputstream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private static void readJsonStream( Map<String,String> messages,InputStream in) throws IOException {
        try(JsonReader reader = new JsonReader(new InputStreamReader(in, StandardCharsets.UTF_8));) {
            readMessagesArray(messages,reader);
        }
    }

    private static void readMessagesArray( Map<String,String> messages,JsonReader reader) throws IOException {
        reader.beginArray();
        while (reader.hasNext()) {
            String code = null;
            String message = null;

            reader.beginObject();
            while (reader.hasNext()) {
                String name = reader.nextName();
                if (name.equals("code")) {
                    code = reader.nextString();
                } else if (name.equals("message")) {
                    message = reader.nextString();
                } else {
                    reader.skipValue();
                }
            }
            reader.endObject();
            messages.put(code,message);
        }
        reader.endArray();
    }


    public String getMessage(@NotNull MessageParam param) {
        String contextMessage = "Ops :( Message not found!";
        switch (param.getType()){
            case "100":
                contextMessage = INFORMATION_MESSAGES.get(param.toString());
                break;
            case "200":
                contextMessage = SUCCESS_MESSAGES.get(param.toString());
                break;
            case "300":
                contextMessage = REDIRECTION_MESSAGES.get(param.toString());
                break;
            case "400":
                contextMessage = CLIENT_ERROR_MESSAGES.get(param.toString());
                break;
            case "500":
                contextMessage = SERVER_ERROR_MESSAGES.get(param.toString());
                break;
        }
        return  contextMessage;
    }

    public String getMessage(MessageParam param,final Map<String,String> expression) {
        return  "Ops :( Message not found!";
    }
}
