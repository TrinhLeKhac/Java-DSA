package sort;
import array.Utils;

public class MergeSortV2 {

    public static void mergeSort(int[] arr, int[] temp, int low, int high) {

        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, temp, low, mid);
            mergeSort(arr, temp, mid + 1, high);
            combine(arr, temp, low, mid, high);
        }
    }

    public static void combine(int[] arr, int[] temp, int low, int mid, int high) {

        for (int i = low; i <= high; i++) {
            temp[i] = arr[i];
        }

        // arr will change elements (in place) based on condition on temp arr elements
        int i = low; // traverse sub-left temp array
        int j = mid + 1; // traverse sub-right temp array
        int k = low;  // traverse originnal array

        while ((i <= mid) && (j <= high)) {
            if (temp[i] < temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            arr[k] = temp[i];
            k++;
            i++;
        }
        while (j <= high) {
            arr[k] = temp[j];
            k++;
            j++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 4, 8, 111, 13, 27, 86, 1, 10, 5, 7, 17, 107, 17};
        System.out.print("Original array: ");
        Utils.printArray(arr);

        System.out.print("Sorted array: ");
        mergeSort(arr, new int[arr.length], 0, arr.length-1);
        Utils.printArray(arr);
    }
}
