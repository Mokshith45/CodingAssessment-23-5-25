package com.library.exception;

// throws the exception when user trying to issue a book that is already issued

public class BookNotAvailableException extends Exception {
    public BookNotAvailableException(String message){
//        passes the message to exception class
        super(message);
    }

}
