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
        Student student0 = new Student("Abc");
        students.add(student0);

        Collections.sort(students, (Student a, Student b) -> a.getName().compareTo(b.getName()));

        System.out.println("Students:");
        for (Student s : students) {
            System.out.println(s);
        }

        for (Project p : projectInput) {
            projects.add(p);
        }
        Project project0 = new Project("Cde");
        projects.add(project0);

        System.out.println("Projects:");
        for (Project p : projects) {
            System.out.println(p);
        }


    }


}



