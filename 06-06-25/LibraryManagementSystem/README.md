# Library Management System – Java Console App

This is a console-based Java application that simulates a **library system** for managing books, members, lending records, and overdue monitoring using **core Java concepts**.

---

## Features Implemented

### Core Functionalities
- Add, remove, and view books
- Register and remove library members
- Issue books to members
- Return books
- Track lending records

### Advanced Features
- List members who currently have borrowed books
- Generate reports of all **overdue** books
- Sort books alphabetically using `Comparable`
- Search by title, author, member name/email

### Background Overdue Monitor (Multithreading)
- A background thread (`OverdueMonitor`) runs every minute
- Automatically scans for overdue books and logs alerts
---

---

## Java Concepts Used

| Concept               | How It's Used                                                   |
|----------------------|------------------------------------------------------------------|
| OOP (Encapsulation)  | Book, Member, LendingRecord classes                             |
| Generics             | `Repository<T>` to manage any model type                        |
| Collections API      | `List`, `Set`, `HashMap` to store and manage data               |
| Custom Exceptions    | Handles real-world errors like book not available, overdue      |
| Multithreading       | `OverdueMonitor` class checks overdue records in the background |
| Comparable Interface | Allows book sorting by title                                    |
| Java Streams & Lambdas | Filters overdue books, active borrowers reports                |

---

## Sample Output (Console)

Books issued successfully.

All Books in Library:
[B001] Clean Code by Robert C. Martin | Issued: false
[B002] Java Concurrency by Brian Goetz | Issued: true

 Lending Records:
[UUID] Book: Java Concurrency | Member: Bhargav | Issued: 2025-06-08, Due: 2025-06-22, Not Returned

 Members who currently have borrowed books:
[M002] Bhargav bhargav@gmail.com

 Overdue Books Report:
[UUID] Book: Mastering OOP in Java | Member: Ishita | Due: 2025-06-01, Not Returned