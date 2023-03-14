import java.time.LocalDate;

public class Designer extends Person{
    private String tool;
    private String os;

    public Designer(String name, int id, Node employer,LocalDate birthdate, String tool, String os) {
        super(name, id, employer, birthdate);
        this.tool = tool;
        this.os = os;
    }

    public String getTool() {
        return tool;
    }

    public void setTool(String tool) {
        this.tool = tool;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }
}