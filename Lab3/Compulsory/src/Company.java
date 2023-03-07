import java.util.*;

public class Company implements Node, Comparable<Company> {
    private String name;
    private int id;
    private List<Person> employees;

    public Company(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Person employee) {
        employees.add(employee);
    }

    public List<Person> getEmployees() {
        return employees;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Company other) {
        return this.name.compareTo(other.name);
    }
}
