import java.util.TreeSet;

public class Project implements Comparable<Project> {
    private String name;

    public Project(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public int compareTo(Project other){
        return this.name.compareTo(other.getName());
    }
    @Override
    public String toString() {
        return this.name;
    }
}
