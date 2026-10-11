package session_9.class_problem;

import java.util.HashSet;
import java.util.Set;

public class PairWithTargetSum {
    public static boolean hasPairWithSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            int complement = target - num;
            if (seen.contains(complement)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    public static boolean hasPairWithSumBruteForce(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 7, 11, 15};
        System.out.println(hasPairWithSum(nums1, 9));

        int[] nums2 = {3, 4, 6};
        System.out.println(hasPairWithSum(nums2, 20));
    }
}
