import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;

import static java.lang.System.*;

public class Main {
    public static void main(String[] args) {
        Company company1 = new Company("Microsoft");
        Company company2 = new Company("Google");
        Person person1 = new Person("John", 1, company1, LocalDate.of(1990, 1, 1));
      Person person2 = new Programmer("Jane", 2, company2, LocalDate.of(1992, 4, 12), "Java", "IntelliJ", "Windows");
      Person person3 = new Designer("Jack", 3, company2, LocalDate.of(1995, 6, 21), "Adobe", "Windows");

          person1.addRelationship(company1);
          person2.addRelationship(company1);
          person2.addRelationship(company2);
          person3.addRelationship(company2);

//        Relationship relationship1 = new Relationship(person1, company1, RelationshipType.PERSON_TO_COMPANY);
//        Relationship relationship2 = new Relationship(person1, person2, RelationshipType.PERSON_TO_PERSON);
//        Relationship relationship3 = new Relationship(person1, person3, RelationshipType.PERSON_TO_PERSON);

        Network network = new Network();
        network.addNode(company1);
        network.addNode(person1);
        network.addNode(person2);
        network.addNode(person3);

//        System.out.println(person1.getRelationship(person2));
//      
        Comparator<Node> byImportance = Comparator.comparing(Node::getImportance);
        Collections.sort(network.getNodes(), byImportance);
        out.println(network.getNodes());
    }
}

/*
* Fiecare instanta Person/Company/Bla bla are un map numit Relationships :
* Mapa arata in felul urmator :  {Obiectul cu are are relatia :  Tipul de relatie }
*
* functia de comparable compara doua obiecte dupa conditia : toCompare(obj1, obj2) {
*                                                                       return obj1.getMap().getKeyset.size()< obj2.getMap().getKeyset.size()}
*
* trebuie sa am o functie  addRelathionship( obj, RelationshipType) {
*                                           relationships.put(obj,relationshipType)     }
*
*
*
*
*
*
* */