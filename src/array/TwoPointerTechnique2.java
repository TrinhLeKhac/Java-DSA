package array;

// Given sorted array of integers, rearrange array in such a way that the first position will have the largest number,
// the second will have the smallest, the third will have  the second-largest and so on.
// Using O(1) extra space

public class TwoPointerTechnique2 {
    public static void simpleSolution(int[] arr) {
        int n = arr.length;
        int i = 0;  // traverse small value from the left
        int j = n - 1;  // traverse large value from the right
        int k = 0;  // traverse in-place change original arr
        int[] result = new int[n];  // copy value from original
        for (int l = 0; l < n; l++) {
            result[l] = arr[n - 1 - l];
        }
        while (k < n - 1 && i < j) {
            arr[k] = result[i];
            arr[k + 1] = result[j];
            i++;
            j--;
            k = k + 2;
        }
        arr[n - 1] = result[i];
    }
    public static void solution(int[] arr) {
        int minIdx = 0;
        int maxIdx = arr.length - 1;
        int multiplier = arr[maxIdx] + 1;
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                arr[i] = arr[i] + multiplier * (arr[maxIdx] % multiplier);
                maxIdx--;
            } else {
                arr[i] = arr[i] + multiplier * (arr[minIdx] % multiplier);
                minIdx++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] / multiplier;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 8, 10, 100};
        System.out.print("Original array: ");
        Utils.printArray(arr);
        System.out.println('\n');

//        System.out.print("After rearrange array by simple solution: ");
//        simpleSolution(arr);
//        Utils.printArray(arr);

        System.out.print("After rearrange array by optimal solution: ");
        solution(arr);
        Utils.printArray(arr);
    }
}
