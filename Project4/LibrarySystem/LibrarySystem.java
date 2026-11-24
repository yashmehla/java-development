import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibrarySystem {
    private static final String FILE_NAME = "books.txt";
    private static List<Book> catalog = new ArrayList<>();

    public static void main(String[] args) {
        loadFromFile();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Library System ---");
            System.out.println("1. Add a Book");
            System.out.println("2. Search by Title");
            System.out.println("3. List All Books");
            System.out.println("4. Save & Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addBook(scanner);
                    break;
                case "2":
                    searchByTitle(scanner);
                    break;
                case "3":
                    listAllBooks();
                    break;
                case "4":
                    saveToFile();
                    System.out.println("Catalog saved. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please enter 1-4.");
            }
        }
        scanner.close();
    }

    private static void addBook(Scanner scanner) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine().trim();
        System.out.print("Enter author name: ");
        String author = scanner.nextLine().trim();

        if (title.isEmpty() || author.isEmpty()) {
            System.out.println("Title and author cannot be empty.");
            return;
        }

        catalog.add(new Book(title, author));
        saveToFile(); 
        System.out.println("Book added successfully!");
    }

    private static void searchByTitle(Scanner scanner) {
        System.out.print("Enter title keyword to search: ");
        String query = scanner.nextLine().trim().toLowerCase();
        boolean found = false;

        System.out.println("\nSearch Results:");
        for (Book book : catalog) {
            if (book.getTitle().toLowerCase().contains(query)) {
                System.out.println("- " + book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching books found.");
        }
    }

    private static void listAllBooks() {
        System.out.println("\n--- All Books in Catalog ---");
        if (catalog.isEmpty()) {
            System.out.println("The library catalog is currently empty.");
            return;
        }

        for (int i = 0; i < catalog.size(); i++) {
            System.out.println((i + 1) + ". " + catalog.get(i));
        }
    }

    private static void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Book book : catalog) {
                writer.write(book.toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving catalog: " + e.getMessage());
        }
    }

    private static void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return; 
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Book book = Book.fromFileString(line);
                if (book != null) {
                    catalog.add(book);
                }
            }
            System.out.println("Loaded " + catalog.size() + " book(s) from " + FILE_NAME + ".");
        } catch (IOException e) {
            System.out.println("Error loading catalog: " + e.getMessage());
        }
    }
}
