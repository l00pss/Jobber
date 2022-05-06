package com.jobber.ws.util.helper;

import java.util.regex.Pattern;

public class JPattern {
    public Pattern of(final String regex){
        return Pattern.compile(regex);
    }

    public Pattern of(){
        return null;
    }
}
