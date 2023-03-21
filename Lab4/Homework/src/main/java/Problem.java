import java.util.stream.Collectors;
import java.util.*;
import java.util.List;
import java.util.TreeSet;

public class Problem {
    private List<Student> studentList;
    private TreeSet<Project> projectList;

    public Problem(List<Student> studentList, TreeSet<Project> projectList) {
        this.studentList = studentList;
        this.projectList = projectList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public TreeSet<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(TreeSet<Project> projectList) {
        this.projectList = projectList;
    }

    public double getAverageOfAdmissibleProjects() {
        return getStudentList().stream().mapToInt(student -> student.getAdmissibleProjects().size()).average().orElse(0.0);
    }

    public List<Student> getStudentsWithLessAdmissibleProjectsThanAverage() {
        return getStudentList().stream().filter(student -> student.getAdmissibleProjects().size() < getAverageOfAdmissibleProjects()).collect(Collectors.toList());
    }

    public String problemSolver() {

        TreeSet<Project> projectSet = new TreeSet<>(projectList);
        List<Student> studentSet = new ArrayList<>(studentList);

        Map<String, Project> solution = new HashMap<>();


        Iterator<Student> studentIterator = studentSet.iterator();
        while (studentIterator.hasNext()) {
            Student student = studentIterator.next();
            Iterator<Project> projectIterator = student.getAdmissibleProjects().iterator();
            while (projectIterator.hasNext()) {
                Project project = projectIterator.next();
                if (projectSet.contains(project)) {
                    solution.put(student.getName(), project);
                    projectIterator.remove();
                    projectSet.remove(project);
                    studentIterator.remove();
                    studentSet.remove(student);
                    break;
                }
            }
        }
        for (Student student : studentSet) {
            if (!solution.containsKey(student)) {
                return "No solution";
            }
        }
        String solutionString = solution.entrySet().stream().map(entry -> entry.getKey() + ": " + entry.getValue()).collect(Collectors.joining("\n"));

        return solutionString;
    }
}



