import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Person implements Node, Comparable<Person> {
    private String name;
    private int id;
    private int importance;
    private Company employer;
    private LocalDate birth_date;
    private Map<Node, RelationshipType> relationships;

    public Person(String name, int id, Company employer, LocalDate birth_date) {
        this.name = name;
        this.id = id;
        this.employer = employer;
        this.birth_date = birth_date;
        this.relationships = new HashMap<>();
        this.importance = 0;
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

    public int getImportance() {
        return this.importance;
    }


    public void decreaseImportance() {
        this.importance--;
    }


    public void increaseImportance() {
        this.importance++;
    }

    public Company getEmployer() {
        return employer;
    }

    public void setEmployer(Company employer) {
        this.employer = employer;
    }


    public void addRelationship(Node node){
        if(node instanceof  Company){
            relationships.put(node,RelationshipType.PERSON_TO_COMPANY);
        } else {
            relationships.put(node,RelationshipType.PERSON_TO_PERSON);
        }
        importance++;
    }
    public void removeRelationship(Node node){
        relationships.remove(node);
        importance--;
    }


    public void addRelationship(Company company, RelationshipType relationshipType) {
        relationships.put(company, relationshipType);
    }
    public void addRelationship(Person person, RelationshipType relationshipType) {
        relationships.put(person, relationshipType);
    }
    public RelationshipType getRelationship(Node node) {
        return relationships.get(node);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Person other) {
        return Integer.compare(this.importance,other.importance);
        //what if the name is null?
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", employer=" + this.employer.getName() +
                ", birth_date=" + birth_date +
                ", relationships=" + relationships +
                '}';
    }
}