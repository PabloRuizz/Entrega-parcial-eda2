import java.util.ArrayList;
import java.util.List;

public class LibraryManager {
    private List<Book> books;

    public LibraryManager() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(String title) {
        books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
    }

    public void editBook(String title, Book newBook) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equalsIgnoreCase(title)) {
                books.set(i, newBook);
                return;
            }
        }
    }

    public List<Book> searchByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> searchByAuthor(String authorName) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            for (Author author : book.getAuthors()) {
                if (author.getName().equalsIgnoreCase(authorName)) {
                    result.add(book);
                    break;
                }
            }
        }
        return result;
    }

    public List<Book> searchByYear(int year) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getYear() == year) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> searchByKeyword(String keyword) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getKeywords().contains(keyword)) {
                result.add(book);
            }
        }
        return result;
    }

    public void listBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
