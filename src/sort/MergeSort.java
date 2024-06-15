// sort.MergeSort is a divide and conquer algorithm

// Divide and conquer recursively breaks down a problem into two or more sub-problems of the same or related type
// until these become simple enough to be solved directly
// The solutions to the sub-problems are then combined to give a solution to the original problem

package sort;
import array.Utils;

public class MergeSort {

    public static int[] mergeSort(int[] arr, int m, int n) {
        if (n == m) { // base condition
            return new int[]{arr[m]};
        }

        int mid = (m + n) / 2;
        int[] left = mergeSort(arr, m, mid);
        int[] right = mergeSort(arr, mid + 1, n);
        return combine(left, right);
    }

    private static int[] combine(int[] left, int[] right) {
        int m = left.length;
        int n = right.length;

        int[] result = new int[m + n];

        int i = 0; // traverse arr left
        int j = 0; // traverse arr right
        int k = 0; // traverse arr result

        while (i < m && j < n) { // boundary condition
            if (left[i] < right[j]) {  // if element of left arr is less than element of right arr
                result[k] = left[i];   // storing element of left arr into result arr
                i++;
            } else {
                result[k] = right[j];  // storing element of right arr into result arr
                j++;
            }
            k++;
        }
        // arr left got exhausted or arr right got exhausted
        while (i < m) {  // arr right got exhausted
            result[k] = left[i];
            k++;
            i++;
        }
        while (j < n) {
            result[k] = right[j];
            k++;
            j++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {12, 4, 8, 111, 13, 27, 86, 1, 10, 5, 7, 17, 107, 17};
        System.out.print("Original array: ");
        Utils.printArray(arr);

        System.out.print("Sorted array: ");
        int[] result = mergeSort(arr, 0, arr.length-1);
        Utils.printArray(result);
    }
}
