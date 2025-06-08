package com.library.model;

import java.lang.Comparable;

public class Book implements Comparable<Book>{
    private String bookId;
    private String title;
    private String author;
    private boolean isIssued;

    public Book(String bookId, String title, String author, boolean isIssued) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isIssued = isIssued;
    }

    public String getBookId(){return bookId;}
    public String getTitle(){return title;}
    public String getAuthor(){return author;}
    public boolean isIssued(){return isIssued;}
    public void setIssued(boolean issued){isIssued = issued;}

    public int compareTo(Book other){
        return this.title.compareToIgnoreCase(other.title);
    }

    public String toString(){
        return "[" + bookId + "]" + title + " by " + author + " | Issued: " + isIssued;
    }
}
