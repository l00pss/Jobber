package com.jobber.ws.util.response.message;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
@Getter
public class MessageProvider {

    private enum MessageFile {
        CLIENT_ERROR("ClientErrorResponse.json"),
        INFORMATION("InformationalResponse.json") ,
        REDIRECTION("RedirectionResponse.json"),
        SERVER_ERROR("ServerErrorResponse.json"),
        SUCCESSFUL("SuccessfulResponse.json");

        private static final String MAIN_PATH = "src/main/java/com/jobber/ws/core/response/message/context/";

        public File get(){
            return new File(MAIN_PATH + this.path);
        };

        final String path;

        MessageFile(String s) {
            this.path = s;
        }


    }

    public File get() throws IOException {
        File file = MessageFile.CLIENT_ERROR.get();
        System.out.println(file.exists());
        return  file;
    }
}
