import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    static class Book {
        private String id;
        private String title;
        private String author;
        private boolean isAvailable;

        public Book(String id, String title, String author) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.isAvailable = true;
        }

        public String getId() { return id; }
        public String getTitle() { return title; }
        public String getAuthor() { return author; }
        public boolean isAvailable() { return isAvailable; }
        public void setAvailable(boolean available) { isAvailable = available; }

        @Override
        public String toString() {
            return String.format("ID: %s | Title: '%s' | Author: %s | Status: %s", 
                    id, title, author, (isAvailable ? "Available" : "Checked Out"));
        }
    }

    static class Library {
        private List<Book> books = new ArrayList<>();

        public void addBook(Book book) {
            books.add(book);
        }

        public void displayAllBooks() {
            if (books.isEmpty()) {
                System.out.println("The library inventory is currently empty.");
                return;
            }
            System.out.println("\n--- Current Library Inventory ---");
            books.forEach(System.out::println);
        }

        public void checkoutBook(String id) {
            Optional<Book> bookOpt = findBookById(id);
            if (bookOpt.isPresent()) {
                Book book = bookOpt.get();
                if (book.isAvailable()) {
                    book.setAvailable(false);
                    System.out.println("Success: You have checked out '" + book.getTitle() + "'.");
                } else {
                    System.out.println("Error: Book is already checked out.");
                }
            } else {
                System.out.println("Error: Book ID not found.");
            }
        }

        public void returnBook(String id) {
            Optional<Book> bookOpt = findBookById(id);
            if (bookOpt.isPresent()) {
                Book book = bookOpt.get();
                if (!book.isAvailable()) {
                    book.setAvailable(true);
                    System.out.println("Success: Book '" + book.getTitle() + "' has been returned.");
                } else {
                    System.out.println("Error: This book was not checked out.");
                }
            } else {
                System.out.println("Error: Book ID not found.");
            }
        }

        private Optional<Book> findBookById(String id) {
            return books.stream().filter(b -> b.getId().equalsIgnoreCase(id)).findFirst();
        }
    }

    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        
        library.addBook(new Book("B001", "Clean Code", "Robert C. Martin"));
        library.addBook(new Book("B002", "Effective Java", "Joshua Bloch"));
        library.addBook(new Book("B003", "Design Patterns", "Erich Gamma"));

        int choice = -1;
        while (choice != 0) {
            System.out.println("\n=== Library Management Menu ===");
            System.out.println("1. Display All Books");
            System.out.println("2. Add a New Book");
            System.out.println("3. Check Out a Book");
            System.out.println("4. Return a Book");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        library.displayAllBooks();
                        break;
                    case 2:
                        System.out.print("Enter Book ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Enter Title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter Author: ");
                        String author = scanner.nextLine();
                        library.addBook(new Book(id, title, author));
                        System.out.println("Success: Book added to inventory.");
                        break;
                    case 3:
                        System.out.print("Enter Book ID to check out: ");
                        String checkoutId = scanner.nextLine();
                        library.checkoutBook(checkoutId);
                        break;
                    case 4:
                        System.out.print("Enter Book ID to return: ");
                        String returnId = scanner.nextLine();
                        library.returnBook(returnId);
                        break;
                    case 0:
                        System.out.println("Exiting system. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid selection. Please choose between 0 and 4.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
        }
        scanner.close();
    }
}
