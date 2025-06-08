package com.library.exception;

// throws when a member tries to borrow a book, but they have overdue books

public class OverdueBookException extends Exception{
    public OverdueBookException(String message){
        super(message);
    }
}
