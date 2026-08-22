package Day3;

import java.util.Scanner;

class Course {
    String code;
    String title;
    int credits;
    int labCredits;

    public Course(String code, String title, int credits, int labCredits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.labCredits = labCredits;
    }

    public Course(String code, String title, int credits) {
        this(code, title, credits, 0);
    }

    public int totalCredits() {
        return credits + labCredits;
    }
}

public class pg3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String line1 = sc.nextLine();
        String[] parts1 = line1.split(", ");
        Course c1;
        if (parts1.length == 3) {
            c1 = new Course(parts1[0], parts1[1], Integer.parseInt(parts1[2]));
        } else {
            c1 = new Course(parts1[0], parts1[1], Integer.parseInt(parts1[2]), Integer.parseInt(parts1[3]));
        }

        String line2 = sc.nextLine();
        String[] parts2 = line2.split(", ");
        Course c2;
        if (parts2.length == 3) {
            c2 = new Course(parts2[0], parts2[1], Integer.parseInt(parts2[2]));
        } else {
            c2 = new Course(parts2[0], parts2[1], Integer.parseInt(parts2[2]), Integer.parseInt(parts2[3]));
        }

        System.out.println(c1.code + " total credits: " + c1.totalCredits());
        System.out.println(c2.code + " total credits: " + c2.totalCredits());
        
        sc.close();
    }
}
