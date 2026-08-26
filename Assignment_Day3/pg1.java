package Assignment_Day3;

import java.util.Scanner;

class BookInventory {
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
}

public class pg1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookInventory[] books = new BookInventory[4];
        for (int i = 0; i < 4; i++) {
            System.out.print("Enter details: ");
            String line = sc.nextLine();
            String[] parts = line.split(", ");
            books[i] = new BookInventory(parts[0], parts[1], Integer.parseInt(parts[2]));
        }
        for (int i = 0; i < 4; i++) {
            books[i].printEntry();
        }
        sc.close();
    }
}
