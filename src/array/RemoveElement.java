package array;

// Remove in-place element val from array nums and return number of element from nums that different from val

// Input - nums = {1, 2, 3, 2, 5, 1}  val = 2
// Output - nums = {1, 3, 5, 1, _, _} and return value is 4

import java.util.NoSuchElementException;

public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            throw new NoSuchElementException("Empty array found!!!");
        }
        int i = 0; // slow pointer that stop at position val
        int j = 0;  // fast pointer
        while (j < nums.length) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        int result = i;
        while (i < nums.length) {
            nums[i] = -1;
            i++;
        }
        System.out.print("The remaining array is: ");
        Utils.printArray(nums);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 5, 1};
        int val = 2;
        System.out.print("The original array: ");
        Utils.printArray(nums);
        int lengthRemainingArray = removeElement(nums, val);
        System.out.println("The length of remaining array is: " + lengthRemainingArray);
    }
}
