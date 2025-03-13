import java.util.ArrayList;

// Book class
class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void display() {
        System.out.println("Book: " + title + " by " + author);
    }
}

// Library class (Aggregation)
class Library {
    private String name;
    private ArrayList<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        System.out.println("\nLibrary: " + name);
        for (int i = 0; i < books.size(); i++) {
            books.get(i).display();
        }
    }
}

// Main class to demonstrate Aggregation
public class LibrarySystem {
    public static void main(String[] args) {
        // Creating independent books
        Book b1 = new Book("Think Again", "Adam Grant");
        Book b2 = new Book("Rich Dad Poor Dad", "Robert Kiyosaki");
        Book b3 = new Book("Meditations", "Marcus Aurelius");

        // Creating libraries
        Library lib1 = new Library("Central Library");
        Library lib2 = new Library("Chitkara Library");

        // Adding books to libraries
        lib1.addBook(b1);
        lib1.addBook(b2);

        lib2.addBook(b2);
        lib2.addBook(b3);

        // Display books in each library
        lib1.displayBooks();
        lib2.displayBooks();
    }
}
