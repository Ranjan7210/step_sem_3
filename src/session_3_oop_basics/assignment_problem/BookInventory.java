package session_3_oop_basics.assignment_problem;

import java.util.Scanner;

public class BookInventory {
    String title;
    String author;
    int copiesAvailable;

    public BookInventory(String title, String author, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    public void printEntry() {
        System.out.println(title + " by " + author + " - " + copiesAvailable + " copies available");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookInventory[] books = new BookInventory[4];
        for (int i = 0; i < 4; i++) {
            System.out.print("Enter Book " + (i + 1) + " details (Title, Author, Copies): ");
            String line = sc.nextLine();
            String[] parts = line.split(", ");
            String title = parts[0];
            String author = parts[1];
            int copies = Integer.parseInt(parts[2]);
            books[i] = new BookInventory(title, author, copies);
        }
        for (int i = 0; i < 4; i++) {
            books[i].printEntry();
        }
        sc.close();
    }
}
