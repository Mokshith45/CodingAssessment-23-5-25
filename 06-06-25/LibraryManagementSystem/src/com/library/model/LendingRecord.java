package com.library.model;
import java.time.LocalDate;
public class LendingRecord {
    private String recordId;
    private Book book;
    private Member member;
    private LocalDate issueDate;
    private LocalDate dueDate;
    private LocalDate returnDate;

    public LendingRecord(String recordId, Book book, Member member, LocalDate issueDate, LocalDate dueDate) {
        this.recordId = recordId;
        this.book = book;
        this.member = member;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
    }

    public String getRecordId() { return recordId; }
    public Book getBook() { return book; }
    public Member getMember() { return member; }
    public LocalDate getIssueDate() { return issueDate; }
    public LocalDate getDueDate() { return dueDate; }
    public LocalDate getReturnDate() { return returnDate; }

    public void setReturnDate(LocalDate returnDate){ this.returnDate = returnDate;}

    public boolean isOverDue(){
        return returnDate == null && LocalDate.now().isAfter(dueDate);
    }

    public String toString(){
        return "[" + recordId + "] Book: " + book.getTitle() +
                " | Member : " + member.getName() +
                " | Issued : " + issueDate + ", Due: "+  dueDate +
                (returnDate != null ? ", Returned: " + returnDate : ", Not Returned");
    }
}
