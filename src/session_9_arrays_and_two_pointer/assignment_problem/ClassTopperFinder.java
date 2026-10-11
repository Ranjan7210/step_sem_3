package session_9.assignment_problem;

import java.util.Arrays;
import java.util.List;

public class ClassTopperFinder {

    static int[] findTopper(int[][] marks) {
        int topperRow = 0;
        int topperTotal = 0;
        for (int i = 0; i < marks[0].length; i++) {
            topperTotal += marks[0][i];
        }
        for (int i = 1; i < marks.length; i++) {
            int total = 0;
            for (int j = 0; j < marks[i].length; j++) {
                total += marks[i][j];
            }
            if (total > topperTotal) {
                topperTotal = total;
                topperRow = i;
            }
        }
        return new int[]{topperRow, topperTotal};
    }

    public static void main(String[] args) {
        int[][] marks1 = {{85, 90, 78}, {92, 88, 95}, {70, 75, 80}};
        int[] result1 = findTopper(marks1);
        System.out.println("(" + result1[0] + ", " + result1[1] + ")");

        int[][] marks2 = {{100, 100}, {100, 100}, {90, 80}};
        int[] result2 = findTopper(marks2);
        System.out.println("(" + result2[0] + ", " + result2[1] + ")");
    }
}
