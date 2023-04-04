package Commands;

public class LoadCommand implements Command {
    String fileName;

    public LoadCommand(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void execute() {
        System.out.println("Loaded file " + fileName);
    }
}
