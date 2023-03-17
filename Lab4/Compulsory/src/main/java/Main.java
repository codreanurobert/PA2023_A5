import java.util.stream.IntStream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.LinkedList;


public class Main {
    public static void main(String args[]) {

        List<Student> students = new LinkedList<>();
        TreeSet<Project> projects = new TreeSet<>();

        var studentsInput = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Student("Student_" + i))
                .toArray(Student[]::new);

        var projectInput = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Project("Project" + i))
                .toArray(Project[]::new);

        for (Student s : studentsInput) {
            students.add(s);
        }
        for (Project p : projectInput) {
            projects.add(p);
        }
        students.add(new Student("Abc"));
        projects.add(new Project("Cde"));

        Collections.sort(students, (Student a, Student b) -> a.getName().compareTo(b.getName()));

        System.out.println("Students:");
        for (Student s : students) {
            System.out.println(s);
        }

        System.out.println("Projects:");
        for (Project p : projects) {
            System.out.println(p);
        }


    }


}



