// Insertion sort

// We devide the given array into two parts - sorted part and unsorted part
// From unsorted part, we take first element and place at its correct postion in sorted array.
// This can be done by shifting all the elements which are larger the first element by one position

public class InsertionSort {

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void insertionSort(int[] arr) {
        // Sorted array have i element (i from 1 to n - 1)
        // Unsorted array have n - i element (start from position i to position n - 1)
        for (int i = 1; i < arr.length; i++) {
            // Find position for the first element of unsorted array (arr[i]) in sorted array (pos)
            int pos = i; // the default position when arr[i] greater than all element of sorted array
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) {
                    pos = j;
                    break;
                }
            }
            if (pos != i) {
                int temp = arr[i];
                for (int k = i; k > pos; k--) {
                    arr[k] = arr[k-1];
                }
                arr[pos] = temp;
            }
        }
    }

    public static void insertionSortV2(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];
                } else {
                    arr[j + 1] = temp;
                    break;
                }
            }
        }
    }

    public static void insertionSortV3(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 2, 4, 1, 3, 7, 8, 100};
        System.out.print("Original array: ");
        printArray(arr);
        System.out.println('\n');

        System.out.print("After sort elements by method V1: ");
        insertionSort(arr);
        printArray(arr);
        System.out.println('\n');

        System.out.print("After sort elements by method V2: ");
        insertionSortV2(arr);
        printArray(arr);
        System.out.println('\n');

        System.out.print("After sort elements by method V3: ");
        insertionSortV3(arr);
        printArray(arr);
        System.out.println('\n');
    }
}
