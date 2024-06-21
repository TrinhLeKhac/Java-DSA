package array;

// Given an array of integers arr, there is a sliding window of size k which is moving from the very left of the array
// to the very right. Find the maximum sum of any contiguous sub-array of size k

// Example -
// Input {2, 7, 3, 5, 8, 1} k = 3
// Output: 16 (3 + 5 + 8)

// Naive solution - O(k*n)
// Solution
// - Sum of first k elements
// - Subtract the most left element
// - Add right element

public class MaximumSlidingWindow {
    public static int maximumSlidingWindow(int[] nums, int k) {
        int sumWindow = 0;
        int start = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sumWindow = sumWindow + nums[i];
            if (i >= k - 1) {
                maxSum = Math.max(maxSum, sumWindow);
                sumWindow = sumWindow - nums[start];
                start++;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 3, 5, 8, 1};
        int k = 3;
        int result = maximumSlidingWindow(nums, k);
        System.out.print("The maximum sum of window with sliding " + k + " is: " + result);
    }
}
