public class Person implements Node, Comparable<Person> {
    private String name;
    private int id;
    private Company employer;

    public Person(String name, int id,Company employer) {
        this.name = name;
        this.id = id;
        this.employer = employer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Company getEmployer() {
        return employer;
    }

    public void setEmployer(Company employer) {
        this.employer = employer;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Person other) {
        return this.name.compareTo(other.name);
        //what if the name is null?
    }
}