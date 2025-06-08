package com.library.util;

import java.time.LocalDate;

import java.util.List;

import com.library.model.LendingRecord;
import com.library.model.Book;
import com.library.model.Member;

import com.library.repository.Repository;


public class OverdueMonitor extends Thread {
    private Repository<LendingRecord> lendingRepo;

    // Constructor accepts the lending repository to access current lending data
    public OverdueMonitor(Repository<LendingRecord> lendingRepo) {
        this.lendingRepo = lendingRepo;
    }

    public void run(){
        while(true){
            try{
                System.out.println("\n[OverdueMonitor] Scanning for overdue books..");
                List<LendingRecord> records = lendingRepo.getAll();
                for(LendingRecord record : records){
                    if(record.getRecordId() == null && record.isOverDue()){
                        Book book = record.getBook();
                        Member member = record.getMember();

                        System.out.println("Overdue book Alert:--");
                        System.out.println("Book: " + book.getTitle() + " (ID: " + book.getBookId() + ")");
                        System.out.println("Borrowed by: " + member.getName() + " (" + member.getEmail() + ")");
                        System.out.println("Due on: " + record.getDueDate());
                    }
                }
                Thread.sleep(60000);
            }catch (InterruptedException e){
                System.out.println("Overdue Monitor was Interrupted");
                break;
            }
        }
    }
}
