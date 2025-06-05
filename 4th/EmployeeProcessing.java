import java.util.*;
import java.util.stream.*;

class Employee {
    String name;

    Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name;
    }
}

class Department {
    String name;
    List<Employee> employees;

    Department(String name, List<Employee> employees) {
        this.name = name;
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}

public class EmployeeProcessing {
    public static void main(String[] args) {
        List<Department> departments = Arrays.asList(
                new Department("Frontend", Arrays.asList(new Employee("Arjun"), new Employee("Arun"), new Employee("Bharath"))),
                new Department("Backend", Arrays.asList(new Employee("Charan"), new Employee("Dinesh"), new Employee("Abhay")))
        );

        // Merging all employees into a single list
        List<Employee> allEmployees = departments.stream()
                .flatMap(dept -> dept.getEmployees().stream())
                .collect(Collectors.toList());

        // Filtering names starting with 'A' and sort
        List<String> sortedNames = allEmployees.stream()
                .map(Employee::getName)
                .filter(name -> name.startsWith("A"))
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Sorted names starting with 'A': " + sortedNames);

        // Grouping names by starting letter
        Map<Character, List<String>> groupedByLetter = sortedNames.stream()
                .collect(Collectors.groupingBy(name -> name.charAt(0)));

        System.out.println("\nGrouped by starting letter:");
        groupedByLetter.forEach((k, v) -> System.out.println(k + " → " + v));

        //Creating 5 random sports teams
        Collections.shuffle(allEmployees);
        List<List<Employee>> sportsTeams = new ArrayList<>();
        int teamSize = allEmployees.size() / 5;
        for (int i = 0; i < 5; i++) {
            int from = i * teamSize;
            int to = (i == 4) ? allEmployees.size() : from + teamSize;
            sportsTeams.add(new ArrayList<>(allEmployees.subList(from, to)));
        }

        System.out.println("\nSports Teams:");
        for (int i = 0; i < sportsTeams.size(); i++) {
            System.out.println("Team " + (i + 1) + ": " + sportsTeams.get(i));
        }

        List<List<Employee>> divisions = Arrays.asList(
                Stream.concat(sportsTeams.get(0).stream(), sportsTeams.get(1).stream()).collect(Collectors.toList()),
                Stream.concat(sportsTeams.get(2).stream(), sportsTeams.get(3).stream()).collect(Collectors.toList()),
                sportsTeams.get(4)
        );

        System.out.println("\nDivisions:");
        for (int i = 0; i < divisions.size(); i++) {
            System.out.println("Division " + (i + 1) + ": " + divisions.get(i));
        }
    }
}
