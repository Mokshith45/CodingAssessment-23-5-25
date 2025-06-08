package com.company.tasktracker.model;

import java.time.LocalDate;

public class Task implements Comparable<Task>{
    private int id;
    private String description;
    private String status;  //pending, in progress, completed
    private LocalDate dueDate;
    private int priority;  //lower number = higher priority

    public Task(int id, String description, String status, LocalDate dueDate, int priority) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.dueDate = dueDate;
        this.priority = priority;
    }

    public int getId() { return id; }
    public String getDescription() { return description; }
    public String getStatus() { return status; }
    public LocalDate getDueDate() { return dueDate; }
    public int getPriority() { return priority; }

    public void setStatus(String status) {
        this.status = status;
    }

    public int compareTo(Task other) {
        return Integer.compare(this.priority, other.priority); // for sorting
    }
    public String toString() {
        return "[#" + id + "] " + description + " | " + status + " | Due: " + dueDate + " | Priority: " + priority;
    }
}
