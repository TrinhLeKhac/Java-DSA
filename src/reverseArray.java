// Given an array or string, the task is to reverse the array or string

// Input
//    Given array of integers - {2, 11, 5, 10, 7, 8}

// Output
//    Return reverse of array - {8, 6, 10, 5, 11, 2}

public class reverseArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        Utils.printArray(arr);
        reverseArr(arr, 0, arr.length-1);
        Utils.printArray(arr);
        System.out.println("The minimum of array is: " + minArray(arr));
    }

    private static int minArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Invalid argument");
        }
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }

    private static void reverseArr(int[] arr, int start, int end) {
        int tmp = 0;
        while (start < end) {
            tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
    }
}
