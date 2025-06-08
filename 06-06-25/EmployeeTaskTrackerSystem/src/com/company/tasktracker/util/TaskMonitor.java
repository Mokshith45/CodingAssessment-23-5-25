package com.company.tasktracker.util;

import com.company.tasktracker.model.Task;
import com.company.tasktracker.service.TaskManager;

import java.util.List;

//this thread keep running in the background and logs overdue tasks every minute
public class TaskMonitor extends Thread{
    private TaskManager taskManager;
    private boolean running = true;

    public TaskMonitor(TaskManager taskManager){
        this.taskManager = taskManager;
    }

//  stops the thread if needed
    public void stopMonitoring(){
        running = false;
    }

    public void run(){
        while(running){
            System.out.println("Checking for overdue tasks..");

            List<Task> overdueTasks = taskManager.getOverdueTasks();

            if(overdueTasks.isEmpty()){
                System.out.println("No Overdue tasks found..");
            }else{
                System.out.println("Overdue tasks:");
                for(Task task : overdueTasks){
                    System.out.println(task);
                }
            }

            try{
                Thread.sleep(60000);
            }catch (InterruptedException e){
                System.out.println("Monitor Interrupted");
                Thread.currentThread().interrupt();
            }
        }
    }
}
