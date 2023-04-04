package Commands;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ViewCommand implements Command {

    String fileName;

    public ViewCommand(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void execute() {
        // open the file using the native operating system application
        try {
            Desktop.getDesktop().open(new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
