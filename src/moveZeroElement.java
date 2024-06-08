// Given an array of integers, write a function to move all 0's to end of it
// while maintaining the relative order of the non-zero elements.

// Input
//    Given array of integers - {0, 1, 0, 4, 12}

// Output
//    {1, 4, 12, 0, 0}

public class moveZeroElement {
    public static void main(String[] args) {
         int[] arr = {1, 0, 2, 0, 0, 4};
         moveZero(arr);
         Utils.printArray(arr);
    }

    private static void moveZero(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == 0 && arr[j] != 0) {
                    arr[i] = arr[j];
                    arr[j] = 0;
                }
            }
        }
    }
}
