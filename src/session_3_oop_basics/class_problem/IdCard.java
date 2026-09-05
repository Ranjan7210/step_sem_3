package session_3_oop_basics.class_problem;

import java.util.Scanner;

public class IdCard {
    String name;
    int booksIssued;

    public IdCard(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Primary Student details (Name, Books Issued): ");
        String line1 = sc.nextLine();
        String[] parts1 = line1.split(", ");
        String name = parts1[0].trim();
        int initialBooks = Integer.parseInt(parts1[1].trim());

        System.out.print("Enter updated books count for duplicate card: ");
        int newBooks = Integer.parseInt(sc.nextLine().trim());

        System.out.print("Enter Separate Student details (Name, Books Issued): ");
        String line3 = sc.nextLine();
        String[] parts3 = line3.split(", ");
        String separateName = parts3[0].trim();
        int separateBooks = Integer.parseInt(parts3[1].trim());

        IdCard ravi = new IdCard(name, initialBooks);
        IdCard duplicate = ravi;
        duplicate.booksIssued = newBooks;

        System.out.println(ravi.name + "'s booksIssued (via first variable): " + ravi.booksIssued);
        System.out.println("duplicate == ravi: " + (duplicate == ravi));

        IdCard separate = new IdCard(separateName, separateBooks);
        System.out.println("separate == ravi: " + (separate == ravi));

        sc.close();
    }
}
