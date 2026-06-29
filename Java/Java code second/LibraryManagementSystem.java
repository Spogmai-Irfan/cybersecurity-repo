import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int id;
    String title;
    String author;
    boolean available;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    void display() {
        System.out.println("------------------------------");
        System.out.println("Book ID   : " + id);
        System.out.println("Title     : " + title);
        System.out.println("Author    : " + author);
        System.out.println("Available : " + (available ? "Yes" : "No"));
    }
}

public class LibraryManagementSystem {

    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        books.add(new Book(id, title, author));

        System.out.println("Book Added Successfully!");
    }

    public static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (Book b : books) {
            b.display();
        }
    }

    public static void issueBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.id == id) {
                if (b.available) {
                    b.available = false;
                    System.out.println("Book Issued Successfully!");
                } else {
                    System.out.println("Book is already issued.");
                }
                return;
            }
        }

        System.out.println("Book not found.");
    }

    public static void returnBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.id == id) {
                if (!b.available) {
                    b.available = true;
                    System.out.println("Book Returned Successfully!");
                } else {
                    System.out.println("Book is already available.");
                }
                return;
            }
        }

        System.out.println("Book not found.");
    }

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addBook();
                    break;

                case 2:
                    viewBooks();
                    break;

                case 3:
                    issueBook();
                    break;

                case 4:
                    returnBook();
                    break;

                case 5:
                    System.out.println("Thank you!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}