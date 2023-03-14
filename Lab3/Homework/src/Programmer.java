import java.time.LocalDate;

public class Programmer extends Person{
    private String language;
    private String editor;
    private String os;

    public Programmer(String name, int id, Node employer, LocalDate birthdate, String language, String editor, String os) {
        super(name, id, employer,birthdate);
        this.language = language;
        this.editor = editor;
        this.os = os;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }
}