import java.util.*;
public class Main {
    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<>();


        Company company1 = new Company("Company1");
        Company company2 = new Company("Company2");
        Company company3 = new Company("Company3");
        Person person1 = new Person("Person1", 1, company1);
        company1.addEmployee(person1);
        Person person2 = new Person("Person2", 2, company1);
        company1.addEmployee(person2);
        Person person3 = new Person("Person3", 3, company2);
        company2.addEmployee(person3);
        Person person4 = new Person("Person4", 4, company2);
        company3.addEmployee(person4);

        nodes.add( new Company("Company1"));
        nodes.add( new Company("Company2"));
        nodes.add(new Designer("Designer1", 1, company1, "tool1", "os1"));
        nodes.add(new Programmer("Programmer1", 1, company1, "language1", "editor1", "os1"));

        for(Node node : nodes) {
            System.out.println(node.getName());
        }

    }
}
