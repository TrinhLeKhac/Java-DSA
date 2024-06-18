package array;

import java.util.HashSet;
import java.util.Set;

public class CheckDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 13};
        if (containsDuplicate(nums)) {
            System.out.println("The array contains duplicated element");
        }
        else {
            System.out.println("The array doesn't contains duplicated element");
        }
    }
}
