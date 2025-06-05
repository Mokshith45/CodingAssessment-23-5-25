import java.util.*;
import java.util.stream.*;

class Student {
    String name;
    String gender;

    Student(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }
}

public class AddPrefix {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Bhavana", "Female"),
                new Student("Vivek", "Male"),
                new Student("Bhavya", "Female"),
                new Student("Srikar", "Male")
        );

        List<String> titledNames = students.stream()
                .map(student -> {
                    String prefix = student.getGender().equalsIgnoreCase("Male") ? "Mr. " : "Ms. ";
                    return prefix + student.getName();
                })
                .collect(Collectors.toList());

        System.out.println("Prefixed Names:");
        titledNames.forEach(System.out::println);
    }
}
