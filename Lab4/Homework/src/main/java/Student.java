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

    public void addAdmissibleProject(Project project) {
        this.admissibleProjects.add(project);
    }

    public List<Project> getAdmissibleProjects() {
        return this.admissibleProjects;
    }

//    @Override
//    public int compareTo(Student other) {
//        return this.name.compareTo(other.getName());
//    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(admissibleProjects.size(), other.admissibleProjects.size());
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", admissibleProjects=" + admissibleProjects +
                '}';
    }

}