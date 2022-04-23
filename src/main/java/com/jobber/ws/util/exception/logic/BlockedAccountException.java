package com.jobber.ws.util.exception.logic;

import com.jobber.ws.util.exception.core.BaseException;

public class BlockedAccountException extends BaseException {
    public BlockedAccountException(){
        super("Hesabınız bloklanıb");
    }

    public BlockedAccountException(String message){
        super(message);
    }

    public BlockedAccountException(String message,String reporter){
        super(message,reporter);
    }

    public BlockedAccountException(String message,String reporter,String ext){
        super(message,reporter,ext);
    }
}
