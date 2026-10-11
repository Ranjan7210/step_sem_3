package session_9.class_problem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PairWithTargetSumUnsorted {
    public static boolean hasPairWithSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        Set<Integer> complements = new HashSet<>();
        for (int num : nums) {
            if (complements.contains(target - num)) {
                return true;
            }
            complements.add(num);
        }
        return false;
    }

    public static boolean hasPairWithSumTwoPointer(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int left = 0;
        int right = sorted.length - 1;

        while (left < right) {
            int sum = sorted[left] + sorted[right];
            if (sum == target) {
                return true;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] sample1 = {2, 7, 11, 15};
        System.out.println(hasPairWithSum(sample1, 9));

        int[] sample2 = {3, 4, 6};
        System.out.println(hasPairWithSum(sample2, 20));
    }
}
