// Selection Sort

// We devide the given array into two parts - sorted part and unsorted part
// From unsorted part, we find the minimum elements and swap it with the left-most element
// Sorted part initially has 0 element

package sort;
import array.Utils;

public class SelectionSort {

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) { // i => length of sorted part
            int idxMin = i;
            for (int j = i + 1; j < arr.length; j++) { // find index of min element on unsorted array
                if (arr[j] < arr[idxMin]) {
                    idxMin = j;
                }
            }
            // Swap with the left-most element
            int temp = arr[i];
            arr[i] = arr[idxMin];
            arr[idxMin] = temp;
        }
    }
    public static void main(String[] args) {
        int[] arr = {10, 2, 4, 1, 3, 7, 8, 100};
        System.out.print("Original array: ");
        Utils.printArray(arr);

        System.out.print("After sort elements: ");
        selectionSort(arr);
        Utils.printArray(arr);
    }
}
