package Commands;

import javax.swing.text.Document;

public class AddCommand implements Command {
    public void add(Document doc) {
        documents.add(doc);
    }
    @Override
    public void execute() {

    }
}
}
