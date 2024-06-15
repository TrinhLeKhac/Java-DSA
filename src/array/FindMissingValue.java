// Given an array of n - 1 distinct numbers in the range of 1 to n
// Find the missing number in it

package array;

public class FindMissingValue {

    public static int findMissing(int[] arr) {
        int n = arr.length + 1;
        int sum = n * (n + 1) / 2;
        for (int ele : arr) {
            sum = sum - ele;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 2, 1};
        System.out.print("Original array: ");
        Utils.printArray(arr);

        int missingValue = findMissing(arr);
        System.out.println("The missing value of array: " + missingValue);
    }
}
