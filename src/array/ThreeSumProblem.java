package array;

// Given an array of DISTINCT integer, print all such triplets such that they add up to a specific target
// The triplets should be ordered in ascending order

import java.util.Arrays;

// Example -
// Input {2, 4, 3, 7, 1, 8, 9, 0}, target = 6
// Solution -
// {0, 2, 4}, {1, 2, 3}
public class ThreeSumProblem {

    public static void threeSumProblem(int[] nums, int target) {
        if (nums.length < 3) {
            throw new IllegalArgumentException("The array need have at least 3 element");
        }
        Arrays.sort(nums);
        int j, sum;
        int k = nums.length - 1;
        for (int i = 0; i < nums.length - 2; i++) {
            j = i + 1;
            while (j < k) {
                sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    System.out.println("{" + i + ", " + j + ", " + k + "}");
                    j++;
                    k--;
                } else if (sum > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 3, 7, 1, 8, 9, 0};
        int target = 6;
        threeSumProblem(nums, target);
    }
}
