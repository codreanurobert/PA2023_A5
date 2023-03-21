import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String args[]) throws InvalidCatalogException, IOException {
        Main app = new Main();
        try {
            app.testCreateSave();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            app.testLoadView();
        } catch (InvalidCatalogException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private void testCreateSave() throws IOException {
        Catalog catalog = new Catalog("MyDocuments");

        var book = new Document("book1", "1", "/home");
        book.addTag("author", "John Doe");
        book.addTag("year", 1970);

        var article = new Document("article1", "2", "/home");
        article.addTag("author", "Gigi ");
        article.addTag("year", 2019);

        catalog.add(book);
        catalog.add(article);

        CatalogUtil.save(catalog, "C:\\Facultate\\Java\\PA2023_A5\\Lab5\\Compulsory\\catalog.json");
    }

    private void testLoadView() throws InvalidCatalogException, IOException {
        Catalog catalog = CatalogUtil.load("C:\\Facultate\\Java\\PA2023_A5\\Lab5\\Compulsory\\catalog.json");
        CatalogUtil.view(catalog.findById("article1"));
    }


}
