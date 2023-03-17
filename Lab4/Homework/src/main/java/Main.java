import java.util.stream.IntStream;
import java.util.*;
import java.util.Collections;
import java.util.List;
import java.util.LinkedList;

import com.github.javafaker.Faker;


public class Main {
    public static void main(String args[]) {

        List<Student> students = new LinkedList<>();
        TreeSet<Project> projects = new TreeSet<>();

        Faker faker = new Faker();

        var studentsInput = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Student(faker.name().fullName()))
                .toArray(Student[]::new);

        var projectsInput = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Project(faker.company().name()))
                .toArray(Project[]::new);

        // adaugarea proiectelor admisibile pentru fiecare student
        studentsInput[0].addAdmissibleProject(projectsInput[0]);
        studentsInput[1].addAdmissibleProject(projectsInput[0]);
        studentsInput[0].addAdmissibleProject(projectsInput[1]);
        studentsInput[1].addAdmissibleProject(projectsInput[1]);
        studentsInput[1].addAdmissibleProject(projectsInput[2]);
        studentsInput[2].addAdmissibleProject(projectsInput[1]);
        studentsInput[2].addAdmissibleProject(projectsInput[2]);
        studentsInput[2].addAdmissibleProject(projectsInput[3]);
        studentsInput[3].addAdmissibleProject(projectsInput[3]);

        // adaugarea studentilor si proiectelor in lista, respectiv treeSet
        students.addAll(Arrays.asList(studentsInput));
        projects.addAll(Arrays.asList(projectsInput));


        // sortarea studentilor dupa nume
        Collections.sort(students);

        //instantierea problemei
        Problem problem1 = new Problem(students, projects);
        System.out.println("Lista studenti:");
        problem1.getStudentList().forEach(System.out::println);
        System.out.println("Lista proiecte:");
        problem1.getProjectList().forEach(System.out::println);
        System.out.println();

        //afisarea stidentilor cu numarul de proiecte admisibile mai mic decat media
        System.out.println("Studentii cu numarul de proiecte admisibile mai mic decat media:");
        problem1.getStudentsWithLessAdmissibleProjectsThanAverage().forEach(System.out::println);

        System.out.println("Studentii cu proiectele alocate:");
        System.out.println(problem1.problemSolver());
    }


}


