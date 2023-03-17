import java.util.*;

public class Student implements Comparable<Student> {
    private String name;
    private List<Project> admissibleProjects;

    public Student(String name) {
        this.name = name;
        this.admissibleProjects = new ArrayList<Project>();
    }
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.getName());
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", admissibleProjects=" + admissibleProjects +
                '}';
    }
}
