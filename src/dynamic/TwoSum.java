package dynamic;

// Given an array of integers, return indices of the two numbers such that
// they add up to a special target

import array.Utils;

import java.util.HashMap;
import java.util.Map;

// Example - Given an array of integers {2, 11, 5, 10, 7, 8}, target = 9
// Solution - Since, arr[0] + arr[4] = target, return {0, 4} indices
public class TwoSum {
    public static int[] twoSumNaive(int[] nums, int target) {
        int[] result = new int[2];
        if (nums.length < 2) {
            throw new IllegalArgumentException("The length of array too short");
        }
        for (int i = 0; i < nums.length - 1; i++) {
            int remain = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == remain) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    public static int[] twoSumMethod1(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(target - nums[i])) {
                map.put(nums[i], i);  // put nums[i], but check condition contains (target - nums[i])
            } else {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 11, 5, 10, 7, 8};
        int target = 9;
        System.out.println("----------------The naive twoSum method-----------------------");
        int[] result = twoSumNaive(nums, target);
        if (!(result[0] == 0 && result[1] == 0)) {
            System.out.println("The two indices that element add up to " + target + " is : ");
            Utils.printArray(result);
        } else {
            System.out.println("Not found two integers");
        }

        System.out.println("----------------The optimize twoSum method-----------------------");
        int[] result2 = twoSumMethod1(nums, target);
        if (!(result2[0] == 0 && result2[1] == 0)) {
            System.out.println("The two indices that element add up to " + target + " is : ");
            Utils.printArray(result2);
        } else {
            System.out.println("Not found two integers");
        }
    }
}
