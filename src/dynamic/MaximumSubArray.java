package dynamic;

import array.Intervals;
import array.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class MaximumSubArray {
    public static void maximumSubArray(int[] nums) {
        if (nums.length == 0) {
            throw new NoSuchElementException("Array is empty");
        }
        int currentMax = 0;
        int maxSubArray = Integer.MIN_VALUE;
        List<Integer> subArray = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            currentMax = currentMax + nums[i];
            if (currentMax > maxSubArray) {
                maxSubArray = currentMax;
            }
            if (currentMax < nums[i]) {
                System.out.println("currentMax < currentElement(" + (currentMax - nums[i]) + " + " + nums[i] + " < " + nums[i] + ")" + " ===> Start a new sub-array");
                currentMax = nums[i];
                subArray.clear();
            }
            subArray.add(nums[i]);
            System.out.print("subArray: ");
            Utils.printArray(subArray);
            System.out.print(" --- currentMax: " + currentMax);
            System.out.println(" --- maximum: " + maxSubArray);
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, -2, 6, -12, 7, -1, 6};
        maximumSubArray(nums);
    }
}
