package com.company.tasktracker.exception;

public class TaskNotFoundException extends Exception{
    public TaskNotFoundException(String message){
        super(message);
    }
}
