package com.company.tasktracker.service;

import com.company.tasktracker.model.Employee;
import com.company.tasktracker.model.Task;
import com.company.tasktracker.exception.TaskNotFoundException;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

// core service to manage assigning and tracking the tasks for employees
public class TaskManager {
//    maps each employee to their list of assigned tasks
    private Map<Employee, List<Task>> employeeTasks = new HashMap<>();

//  assigns a task to an employee
    public void assignTask(Employee employee ,Task task){
        employeeTasks.computeIfAbsent(employee, k -> new ArrayList<>()).add(task);
    }

//    updates the status of a task by taskId for a specific employee
    public void updateTaskStatus(Employee employee, int taskId, String newStatus) throws TaskNotFoundException{
        List<Task> tasks = employeeTasks.get(employee);
        if(tasks == null) throw new TaskNotFoundException("No task assigned to this employee");

        boolean found = false;
        for(Task task : tasks){
            if(task.getId() == taskId){
                task.setStatus(newStatus);
                found = true;
                break;
            }
        }
        if (!found) throw new TaskNotFoundException("Task ID" + taskId + " not found for employee");
    }

//    get all tasks assigned to a specific employee
    public List<Task> getTasks(Employee employee){
        return employeeTasks.getOrDefault(employee, new ArrayList<>());
    }

//    searches for the task with a keyword in the description
    public List<Task> searchTasks(Employee employee, String keyword){
        return getTasks(employee).stream()
                .filter(task -> task.getDescription().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

//    sorts an employee's tasks by a priority (lower number = higher priority)
    public List<Task> sortByPriority(Employee employee){
        return getTasks(employee).stream()
                .sorted()
                .collect(Collectors.toList());
    }

//    sorts tasks by due date
    public List<Task> sortByDueDate(Employee employee){
        return getTasks(employee).stream()
                .sorted(Comparator.comparing(Task::getDueDate))
                .collect(Collectors.toList());
    }

//    gets all overdue tasks across all employees
    public List<Task> getOverdueTasks(){
        LocalDate today = LocalDate.now();
        return employeeTasks.values().stream()
                .flatMap(List::stream)
                .filter(task -> task.getDueDate().isBefore(today) && !task.getStatus().equalsIgnoreCase("Completed"))
                .collect(Collectors.toList());
    }

//    finds employees with more than 3 tasks
    public List<Employee> getOverloadedEmployees(){
        return employeeTasks.entrySet().stream()
                .filter(entry -> entry.getValue().stream()
                        .filter(task -> task.getStatus().equalsIgnoreCase("Pending"))
                        .count() > 3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

//    gets all tasks due tomorrow
    public List<Task> getTasksDueTomorrow(){
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        return employeeTasks.values().stream()
                .flatMap(List::stream)
                .filter(task -> task.getDueDate().equals(tomorrow))
                .collect(Collectors.toList());
    }
}
