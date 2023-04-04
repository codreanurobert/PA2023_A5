package Commands;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReportCommand implements Command {
    String fileName;

    public ReportCommand(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void execute() {
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write("<html><body><h1>Catalog Report</h1><p>Report pentru catalog.</p></body></html>");
            writer.close();
            Desktop.getDesktop().open(new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
