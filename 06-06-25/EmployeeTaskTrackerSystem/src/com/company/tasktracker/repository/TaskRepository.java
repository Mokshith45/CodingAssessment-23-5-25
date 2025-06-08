package com.company.tasktracker.repository;

import java.util.List;
import java.util.ArrayList;

// generic repository for storing tasks of any type
public class TaskRepository<T> {
    private List<T> taskList = new ArrayList<>();

    public void addTask(T task){
        taskList.add(task);
    }

    public void remove(T task){
        taskList.remove(task);
    }

    public List<T> getTaskList(){
        return taskList;
    }
}
