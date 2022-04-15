package com.jobber.vacancy.side.response;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public abstract class Response {

    private final boolean success;

    private String message;

    private String reDirect;

    private LocalDateTime time;

    public Response(boolean success) { //bool Constroctor
        this.success = success;
        this.time = LocalDateTime.now();
    }
    public Response(boolean success, String message) {
        this(success); // Bool Constractoru cagiri
        this.message = message;
        this.time = LocalDateTime.now();
    }

    public Response(boolean success, String message, String reDirect) {
        this(success,message);
        this.reDirect = reDirect;
    }

    public Response(boolean success, String message, LocalDateTime localDateTime) {
        this(success); // Bool Constractoru cagiri
        this.message = message;
        this.time =localDateTime;
    }

    public Response(boolean success, String message, String reDirect, LocalDateTime localDateTime) {
        this(success, message, localDateTime);
        this.reDirect = reDirect;
    }


    public boolean isSuccess(){
        return this.success;
    }

}
