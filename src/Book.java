import java.util.List;

public class Book {
    private String title;
    private List<Author> authors;
    private int year;
    private List<String> keywords;

    public Book(String title, List<Author> authors, int year, List<String> keywords) {
        this.title = title;
        this.authors = authors;
        this.year = year;
        this.keywords = keywords;
    }

    public String getTitle() {
        return title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public int getYear() {
        return year;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    @Override
    public String toString() {
        return "Titulo: " + title + ", Autores: " + authors + ", Año: " + year + ", Palabras clave: " + keywords;
    }
}
