package Day3;

import java.util.Scanner;

class IdCard {
    String name;
    int booksIssued;

    public IdCard(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }
}

public class pg4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String line1 = sc.nextLine();
        String[] parts1 = line1.split(", ");
        String name = parts1[0];
        int initialBooks = Integer.parseInt(parts1[1]);
        
        int newBooks = Integer.parseInt(sc.nextLine());
        
        String line3 = sc.nextLine();
        String[] parts3 = line3.split(", ");
        String separateName = parts3[0];
        int separateBooks = Integer.parseInt(parts3[1]);

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
