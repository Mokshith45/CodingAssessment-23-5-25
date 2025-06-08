# Employee Task Tracker System

A Java-based console application that allows managers to assign tasks to employees and track their progress, deadlines, and priorities.

---

## Objective

This application was built to practice and demonstrate key **Core Java concepts** including:
- OOP (Object-Oriented Programming)
- Collections & Generics
- Custom Exceptions
- Multithreading
- Java 8+ Streams & Lambdas

---


---

## Features Implemented

| Feature | Description |
|--------|-------------|
| Task Assignment | Admin can assign tasks to any employee |
| Task Status Update | Update task status (Pending, In Progress, Completed) |
| Task Search | Filter tasks by description keyword |
| Task Sorting | Sort tasks by priority or due date |
| Overdue Monitor | Background thread checks and logs overdue tasks every minute |
| Advanced Filtering | Stream API used to filter tasks due tomorrow or overloaded employees |
| Exception Handling | Throws `TaskNotFoundException` for invalid updates |
| Generic Repository | `TaskRepository<T>` supports storing any task type |

---

## How to Compile and Run

### Compile:

Make sure you're in the root project folder. Then compile with:
    
javac com/company/tasktracker/**/*.java

### Sample Output:

 Sorted Tasks by Priority (Employee: Alice):
[#101] Design module | Pending | Due: 2025-06-09 | Priority: 1

 Searching for keyword 'Design' (Employee: Alice):
[#101] Design module | Pending | Due: 2025-06-09 | Priority: 1

 Tasks due tomorrow:
[#104] Fix bugs | Pending | Due: 2025-06-09 | Priority: 2

 Employees with more than 3 pending tasks:
1 - Alice (Engineering)

 Checking for overdue tasks...
️ Overdue Tasks:
[#102] Write report | Completed | Due: 2025-06-07 | Priority: 2




