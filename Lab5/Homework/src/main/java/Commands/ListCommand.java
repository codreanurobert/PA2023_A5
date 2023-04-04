package Commands;

import org.w3c.dom.Document;

import java.util.*;

public class ListCommand implements Command {
    List<Document> documents;

    public ListCommand(List<Document> documents) {
        this.documents = documents;
    }

    @Override
    public void execute() {
        for (Document doc : documents) {
            System.out.println(doc);
        }
    }
}

