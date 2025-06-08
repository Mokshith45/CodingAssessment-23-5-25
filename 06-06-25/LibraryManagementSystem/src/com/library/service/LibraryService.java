package com.library.service;

import com.library.model.Book;
import com.library.model.Member;
import com.library.model.LendingRecord;

import com.library.repository.Repository;

import com.library.exception.BookNotAvailableException;
import com.library.exception.MemberNotFoundException;
import com.library.exception.OverdueBookException;

// used to work with dates(issueDate, dueDate, returnDate)
import java.time.LocalDate;

// used to generate unique ID's for lending records
import java.util.UUID;

import java.util.Set;
import java.util.stream.Collectors;   // used for stream filtering and collecting

import java.util.List;


public class LibraryService {
//    repositories to manage data
    private Repository<Book> bookRepo;
    private Repository<Member> memberRepo;
    private Repository<LendingRecord> lendingRepo;

    public LibraryService(){
        this.bookRepo = new Repository<>();
        this.memberRepo = new Repository<>();
        this.lendingRepo = new Repository<>();
    }

    public void addBook(Book book){
        bookRepo.add(book);
    }
    public void removeBook(Book book){
        bookRepo.remove(book);
    }
    public Repository<Book> getBookRepo(){
        return bookRepo;
    }

    public void addMember(Member member){
        memberRepo.add(member);
    }
    public void removeMember(Member member){
        memberRepo.remove(member);
    }
    public Repository<Member> getMemberRepo(){
        return memberRepo;
    }

    /**
     *  Issues a book to a member if all condition are met
     *  Throws relevant exceptions if any rules are broken
     */

    public void issueBook(String bookId, String memberId) throws
            BookNotAvailableException, MemberNotFoundException, OverdueBookException{
        Book bookToIssue = null;
        for(Book book : bookRepo.getAll()){
            if(book.getBookId().equals(bookId)){
                bookToIssue = book;
                break;
            }
        }
        if(bookToIssue == null || bookToIssue.isIssued()){
            throw new BookNotAvailableException("Book with ID " + bookId + " is not available");
        }

        Member borrowingMember = null;
        for(Member member : memberRepo.getAll()){
            if(member.getMemberId().equals(memberId)){
                borrowingMember = member;
                break;
            }
        }
        if(borrowingMember == null){
            throw new MemberNotFoundException("Member with ID " + memberId + " not found");
        }

        for(LendingRecord record : lendingRepo.getAll()){
            if(record.getMember().getMemberId().equals(memberId) &&
            record.getReturnDate() == null &&
            record.isOverDue()){
                throw new OverdueBookException("Member has overdue books.");
            }
        }
//        Issue the book
        bookToIssue.setIssued(true);
        String recordId = UUID.randomUUID().toString();
        LocalDate issueDate = LocalDate.now();
        LocalDate dueDate = issueDate.plusDays(14); // 2 weeks due period
        LendingRecord newRecord = new LendingRecord(recordId, bookToIssue, borrowingMember, issueDate, dueDate);
        lendingRepo.add(newRecord);
    }

//    returns a book by updating its lending record and setting it as available
    public void returnBook(String bookId){
        for(LendingRecord record : lendingRepo.getAll()){
            if(record.getBook().getBookId().equals(bookId) && record.getRecordId() == null){
                record.setReturnDate(LocalDate.now());
                record.getBook().setIssued(false);
                break;
            }
        }
    }
    public Repository<LendingRecord> getLendingRepo(){
        return lendingRepo;
    }

    public Set<Member> getActiveBorrowingMembers(){
        return lendingRepo.getAll().stream()
                .filter(record -> record.getReturnDate() == null) //filters only unreturned books
                .map(record -> record.getMember())  //extract members
                .collect(Collectors.toSet());  //removing duplicates using set
    }

    /**
     * returns a list of all lending records that are overdue and not yet returned
     */
    public List<LendingRecord>getOverdueRecords(){
        return lendingRepo.getAll().stream()
                .filter(record -> record.getReturnDate() == null &&
                        record.getDueDate().isBefore(LocalDate.now()))
                .collect(Collectors.toList());
    }

    //  Only for testing: issues a book with past dates to simulate overdue
    public void issueBookDirectlyForOverdueTest(Book book, Member member, LocalDate issueDate, LocalDate dueDate) {
        book.setIssued(true);
        String recordId = java.util.UUID.randomUUID().toString();
        LendingRecord record = new LendingRecord(recordId, book, member, issueDate, dueDate);
        lendingRepo.add(record);
    }

}
