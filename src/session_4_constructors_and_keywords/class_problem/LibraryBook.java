package Day4;

import java.util.Scanner;

public class LibraryBook {
    String title;
    String isbn;

    public LibraryBook(String title, String isbn) {
        this.title = title;
        if (isbn == null || isbn.trim().isEmpty()) {
            this.isbn = "PENDING";
        } else {
            this.isbn = isbn.trim();
        }
    }

    public LibraryBook(String title) {
        this(title, "PENDING");
    }

    public void display() {
        System.out.println(title + " | " + isbn + " | Catalogued: true");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of books: ");
        int n = Integer.parseInt(sc.nextLine().trim());

        LibraryBook[] books = new LibraryBook[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter title for book " + (i + 1) + ": ");
            String title = sc.nextLine().trim();

            System.out.print("Enter ISBN (press enter if not available): ");
            String isbn = sc.nextLine().trim();

            if (isbn.isEmpty()) {
                books[i] = new LibraryBook(title);
            } else {
                books[i] = new LibraryBook(title, isbn);
            }
        }

        System.out.println("\n--- Catalogued Books ---");
        for (int i = 0; i < n; i++) {
            books[i].display();
        }

        sc.close();
    }
}
