// Entry point for your application

// Importing models to create and manage data
import com.library.model.Book;
import com.library.model.Member;

// This is your business logic handler (the librarian's brain)
import com.library.service.LibraryService;

// Monitors overdue books every 1 minute in a separate thread
import com.library.util.OverdueMonitor;

// Handles real-world business rule violations
import com.library.exception.BookNotAvailableException;
import com.library.exception.MemberNotFoundException;
import com.library.exception.OverdueBookException;

import java.time.LocalDate;

/**
 * This class simulates how a librarian would interact with the library system.
 * It demonstrates the full flow: adding, issuing, returning, and reporting.
 */
public class Main {
    public static void main(String[] args) {
        // Create the core library service
        LibraryService service = new LibraryService();

        // Add books to the library
        Book b1 = new Book("B001", "Clean Code", "Robert C. Martin", false);
        Book b2 = new Book("B002", "Java Concurrency in Practice", "Brian Goetz", false);
        Book b3 = new Book("B003", "Think in Java", "Bruce Eckel", false);
        Book b4 = new Book("B004", "Introduction to Algorithms", "Thomas H. Cormen", false);
        Book b5 = new Book("B005", "Data Structures", "Mark Allen Weiss", false);

        service.addBook(b1);
        service.addBook(b2);
        service.addBook(b3);
        service.addBook(b4);
        service.addBook(b5);

        // Register members
        Member m1 = new Member("M001", "Arjun Reddy", "arjun@gmail.com");
        Member m2 = new Member("M002", "Bhargav Varma", "bhargav@gmail.com");
        Member m3 = new Member("M003", "Sneha Sharma", "sneha@gmail.com");
        Member m4 = new Member("M004", "Ishita Mehta", "ishita@gmail.com");

        service.addMember(m1);
        service.addMember(m2);
        service.addMember(m3);
        service.addMember(m4);

        // Issuing books to members
        try {
            service.issueBook("B001", "M001"); // Arjun borrows Clean Code
            service.issueBook("B002", "M002"); // Bhargav borrows Concurrency
            service.issueBook("B003", "M003"); // Sneha borrows Think in Java
            System.out.println("✅ Books issued successfully.");
        } catch (BookNotAvailableException | MemberNotFoundException | OverdueBookException e) {
            System.out.println("Could not issue book: " + e.getMessage());
        }

        // Simulating an overdue record manually for Ishita
        Book overdueBook = new Book("B006", "Mastering OOP in Java", "Geeta Rani", true);
        service.addBook(overdueBook);
        service.issueBookDirectlyForOverdueTest(
                overdueBook, m4,
                LocalDate.now().minusDays(20), // Issued 20 days ago
                LocalDate.now().minusDays(6)   // Due 6 days ago
        );

        // Arjun returns his book
        service.returnBook("B001");

        // Start background overdue monitor
        OverdueMonitor monitor = new OverdueMonitor(service.getLendingRepo());
        monitor.start(); // This runs every 60 seconds in background

        // Display library reports

        // List all books
        System.out.println("\n All Books in Library:");
        service.getBookRepo().getAll().forEach(System.out::println);

        // List all lending records
        System.out.println("\n Lending Records:");
        service.getLendingRepo().getAll().forEach(System.out::println);

        // List members who currently have borrowed books
        System.out.println("\n Members who currently have borrowed books:");
        service.getActiveBorrowingMembers().forEach(System.out::println);

        // Show all overdue books
        System.out.println("\n Overdue Books Report:");
        service.getOverdueRecords().forEach(System.out::println);
    }
}
