package com.library.exception;

// throws the exception when trying to find a member that doesn't exist in the repository

public class MemberNotFoundException extends Exception{
    public MemberNotFoundException(String message){
        super(message);
    }
}
