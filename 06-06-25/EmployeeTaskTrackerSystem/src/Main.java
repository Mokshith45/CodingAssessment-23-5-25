
import com.company.tasktracker.model.Employee;
import com.company.tasktracker.model.Task;
import com.company.tasktracker.service.TaskManager;
import com.company.tasktracker.util.TaskMonitor;
import com.company.tasktracker.exception.TaskNotFoundException;

import java.time.LocalDate;
import java.util.List;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or


public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

//      creating employees
        Employee e1 = new Employee(1, "Arjun", "Engineering");
        Employee e2 = new Employee(2, "Shruti", "Recruiting");
        Employee e3 = new Employee(3, "Manas", "Development");

//      creating tasks
        Task t1 = new Task(101, "Design Module", "Pending", LocalDate.now().plusDays(1), 1);
        Task t2 = new Task(102, "Write Report", "Pending", LocalDate.now().minusDays(1), 2);
        Task t3 = new Task(103, "Test feature", "Pending", LocalDate.now(), 3);
        Task t4 = new Task(104, "Fix Bugs", "Pending", LocalDate.now().plusDays(1), 2);

//      assigning tasks
        taskManager.assignTask(e1,t1);
        taskManager.assignTask(e1,t2);
        taskManager.assignTask(e1,t3);
        taskManager.assignTask(e1,t4);
        taskManager.assignTask(e2, new Task(105, "Launch campaign", "Pending", LocalDate.now().plusDays(2),1));

//      starts background monitoring
        TaskMonitor monitor = new TaskMonitor(taskManager);
        monitor.start();  // this runs in background

//      shows sorted tasks by priority
        System.out.println("\n Sorted tasks by priority (Employee : Arjun)");
        List<Task> sortedByPriority = taskManager.sortByPriority(e1);
        sortedByPriority.forEach(System.out::println);

//      searches tasks with keyword
        System.out.println("\n Searching for keyword design (Employee : Arjun)");
        List<Task> searchResult = taskManager.searchTasks(e1, "Design");
        searchResult.forEach(System.out::println);

//      shows tasks due tomorrow
        System.out.println("\n Tasks due tomorrow:");
        taskManager.getTasksDueTomorrow().forEach(System.out::println);

//      show overloaded employees
        System.out.println("\n employees with more than 3 pending tasks:");
        taskManager.getOverloadedEmployees().forEach(System.out::println);

//      len the monitor run for a while and then stop
        try{
            Thread.sleep(120000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        monitor.stopMonitoring();
        System.out.println("Monitor Stopped, Application ending...");
    }
}