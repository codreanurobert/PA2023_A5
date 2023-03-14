public class Relationship {
    private Node node1;
    private Node node2;
    private RelationshipType type;

    public Relationship(Node node1, Node node2, RelationshipType type) {
        this.node1 = node1;
        this.node2 = node2;
        this.type = type;
    }

    public Node getNode1() {
        return node1;
    }

    public void setNode1(Node node1) {
        this.node1 = node1;
    }

    public Node getNode2() {
        return node2;
    }

    public void setNode2(Node node2) {
        this.node2 = node2;
    }

    public RelationshipType getType() {
        return type;
    }

    public void setType(RelationshipType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Relationship{" +
                "node1=" + node1 +
                ", node2=" + node2 +
                ", type=" + type +
                '}';
    }
}
