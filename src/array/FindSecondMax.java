// Given an array of integers, return the second maximum value of it

// Example -
//    Input: arr = {12, 34, 2, 34, 33, 1}
//    Output: 34

//    Input: arr = {1}
//    Output: 1

package array;

public class FindSecondMax {

    private static int findSecondMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Invalid argument");
        }
        if (arr.length == 1) {
            return arr[0];
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            } else if (arr[i] <= max && arr[i] > secondMax) {
                secondMax = arr[i];
            }
        }
        return secondMax;
    }

    public static void main(String[] args) {
        int[] arr = {12, 34, 2, 34, 33, 1};
        System.out.print("Original array: ");
        Utils.printArray(arr);

        int res = findSecondMax(arr);
        System.out.println("The second max value of array is: " + res);
    }
}
