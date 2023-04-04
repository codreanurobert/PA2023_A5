import Commands.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public void main(String args[]) {
        Document document1 = new Document("document1", "1", "C:\\Users\\User\\Desktop\\document1.txt");
        Document document2 = new Document("document2", "2", "C:\\Users\\User\\Desktop\\document2.txt");
        Document document3 = new Document("document3", "3", "C:\\Users\\User\\Desktop\\document3.txt");
        List<Document> documents = new ArrayList<>();
        documents.add(document1);
        documents.add(document2);
        documents.add(document3);

        Command loadCommand = new LoadCommand("file.txt");
        Command listCommand = new ListCommand(documents);
        Command viewCommand = new ViewCommand("document1.txt");
        Command reportCommand = new ReportCommand("report.html");


        loadCommand.execute();
        listCommand.execute();
        viewCommand.execute();
        reportCommand.execute();
    }


}