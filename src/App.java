import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private static LibraryManager libraryManager = new LibraryManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nBiblioteca Digital");
            System.out.println("1. Agregar Libro");
            System.out.println("2. Eliminar Libro");
            System.out.println("3. Editar Libro");
            System.out.println("4. Buscar Libro");
            System.out.println("5. Listar Libros");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    editBook();
                    break;
                case 4:
                    searchBook();
                    break;
                case 5:
                    libraryManager.listBooks();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private static Book createBook() {
        System.out.print("Ingrese el título del libro: ");
        String title = scanner.nextLine();
        System.out.print("Ingrese los autores (separados por comas): ");
        String authorsInput = scanner.nextLine();
        List<Author> authors = new ArrayList<>();
        for (String name : authorsInput.split(",")) {
            authors.add(new Author(name.trim()));
        }
        System.out.print("Ingrese el año de publicación: ");
        int year = scanner.nextInt();
        scanner.nextLine();  
        System.out.print("Ingrese las palabras clave (separadas por comas): ");
        String keywordsInput = scanner.nextLine();
        List<String> keywords = List.of(keywordsInput.split(","));

        return new Book(title, authors, year, keywords);
    }

    private static void addBook() {
        Book book = createBook();
        libraryManager.addBook(book);
        System.out.println("Libro agregado exitosamente.");
    }

    private static void removeBook() {
        System.out.print("Ingrese el título del libro a eliminar: ");
        String title = scanner.nextLine();
        libraryManager.removeBook(title);
        System.out.println("Libro eliminado exitosamente.");
    }

    private static void editBook() {
        System.out.print("Ingrese el título del libro a editar: ");
        String title = scanner.nextLine();
        List<Book> books = libraryManager.searchByTitle(title);
        
        if (books.isEmpty()) {
            System.out.println("No se encontró ningún libro con el título especificado.");
            return;
        }
        
        Book newBook = createBook();
        libraryManager.editBook(title, newBook);
        System.out.println("Libro editado exitosamente.");
    }

    private static void searchBook() {
        System.out.println("Buscar por: 1.Título / 2.Autor / 3.Año / 4.Palabra clave");
        int option = scanner.nextInt();
        scanner.nextLine();  

        List<Book> results = new ArrayList<>();
        switch (option) {
            case 1:
                System.out.print("Ingrese el título: ");
                String title = scanner.nextLine();
                results = libraryManager.searchByTitle(title);
                break;
            case 2:
                System.out.print("Ingrese el autor: ");
                String author = scanner.nextLine();
                results = libraryManager.searchByAuthor(author);
                break;
            case 3:
                System.out.print("Ingrese el año: ");
                int year = scanner.nextInt();
                results = libraryManager.searchByYear(year);
                break;
            case 4:
                System.out.print("Ingrese la palabra clave: ");
                String keyword = scanner.nextLine();
                results = libraryManager.searchByKeyword(keyword);
                break;
            default:
                System.out.println("Opción inválida.");
        }

        for (Book book : results) {
            System.out.println(book);
        }
    }
}
