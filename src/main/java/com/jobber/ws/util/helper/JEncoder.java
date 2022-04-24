package com.jobber.ws.util.helper;

import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class JEncoder {
    public enum Strategy {
        BASIC,
        WITHOUT_PADDING
    }

    public String encode(String input,Strategy strategy){
        if (strategy.equals(Strategy.BASIC))
            return this.basicBase64Encoding(input);
        else return this.withoutPaddingEncoding(input);
    };


    public String encode(String input){
        return this.basicBase64Encoding(input);
    };

    public String decode(String input){
        return new String(Base64.getDecoder().decode(input));
    };


    private String basicBase64Encoding(String input){
        return Base64.getEncoder().encodeToString(input.getBytes());
    }

    private String withoutPaddingEncoding(String input){
        return Base64.getEncoder().withoutPadding().encodeToString(input.getBytes());
    }
}
