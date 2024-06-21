package array;

// Given an array of integers arr[], return an array result[] such that result[i] is equal to the product of all the elements
// of arr except arr[i]
// The algorithm should run in O(n) time and without using division operator

// Example -
// input: arr = {2, 3, 4, 5}
// {1, 2, 6, 24}
//
// output: result = {60, 40, 30, 24}

public class ProductSolution {
    public static int[] productSolution(int[] arr) {
        int[] result = new int[arr.length];
        int temp = 1;
        for (int i = 0; i < arr.length; i++) {
            result[i] = temp;
            temp = temp * arr[i];
        }
        temp = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            result[i] = result[i] * temp;
            temp = temp * arr[i];
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5};
        System.out.print("The original array is: ");
        Utils.printArray(arr);

        int[] result = productSolution(arr);
        System.out.print("The result after producting is: ");
        Utils.printArray(result);
    }
}
