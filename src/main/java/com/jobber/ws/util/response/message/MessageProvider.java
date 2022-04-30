package com.jobber.ws.util.response.message;

import com.google.gson.stream.JsonReader;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Component
class MessageProvider {

    private static final Map<String,String> clientErrorMessages = new HashMap<>();
    private static final Map<String,String> successMessages = new HashMap<>();
    private static final Map<String,String> informationMessages = new HashMap<>();
    private static final Map<String,String> redirectionMessages = new HashMap<>();
    private static final Map<String,String> serverErrorMessages = new HashMap<>();

    private static final Map<String,Map<String,String>> listMap = new HashMap<>();

    static {
        listMap.putIfAbsent(ResponseMessage.CLIENT_ERROR.getPath(),clientErrorMessages);
        listMap.putIfAbsent(ResponseMessage.INFORMATION.getPath(), informationMessages);
        listMap.putIfAbsent(ResponseMessage.SUCCESSFUL.getPath(), successMessages);
        listMap.putIfAbsent(ResponseMessage.REDIRECTION.getPath(), redirectionMessages);
        listMap.putIfAbsent(ResponseMessage.SERVER_ERROR.getPath(), serverErrorMessages);
    }

    static {
        var keys = listMap.entrySet();
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


    public String getMessage(MessageParam param) {
        String contextMessage = "";
        switch (param.getType()){
            case "200":
                contextMessage = successMessages.get(param.getType().concat("_").concat(param.getMessageCode()));
                break;
            case "300":

                break;
        }
        return  contextMessage;
    }

    public String getMessage(MessageParam param,final Map<String,String> expression) {
        return  "Test Success Message";
    }
}
