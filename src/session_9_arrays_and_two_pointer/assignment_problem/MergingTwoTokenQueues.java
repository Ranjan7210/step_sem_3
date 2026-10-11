package session_9.assignment_problem;

import java.util.Arrays;

public class MergingTwoTokenQueues {

    static int[] mergeTokens(int[] counterA, int[] counterB) {
        int[] merged = new int[counterA.length + counterB.length];
        int i = 0, j = 0, k = 0;
        while (i < counterA.length && j < counterB.length) {
            if (counterA[i] <= counterB[j]) {
                merged[k++] = counterA[i++];
            } else {
                merged[k++] = counterB[j++];
            }
        }
        while (i < counterA.length) {
            merged[k++] = counterA[i++];
        }
        while (j < counterB.length) {
            merged[k++] = counterB[j++];
        }
        return merged;
    }

    public static void main(String[] args) {
        int[] a1 = {1, 3, 5, 7};
        int[] b1 = {2, 4, 6, 8};
        System.out.println(Arrays.toString(mergeTokens(a1, b1)));

        int[] a2 = {1, 2, 9};
        int[] b2 = {3, 7};
        System.out.println(Arrays.toString(mergeTokens(a2, b2)));
    }
}
