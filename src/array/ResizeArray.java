// Given an array of integers, resize the array to new capacity

// Input
//   - Given an array of integers - {1, 2, 3, 4, 5}
//   - Resize array to new capacity (2 * array.length)

// Output
//  {1, 2, 3, 4, 5, 0, 0, 0, 0, 0}

package array;

public class ResizeArray {

    private static int[] resizeArr(int[] arr, int capacity) {
        int[] newArr = new int[capacity];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.print("Original array: ");
        Utils.printArray(arr);

        int[] newArr = resizeArr(arr, arr.length*2);
        System.out.print("Modified array: ");
        Utils.printArray(newArr);
    }
}
