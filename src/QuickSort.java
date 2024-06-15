// QuickSort is a divide and conquer algorithm. It involves 3 steps -
// Pivot selection: Pick an element and mark it as pivot. It can be first element, last element or any random element

// Partitioning: Reorder the array such that -
// all elements greater than pivot comes after the pivot
// all elements smaller than pivot comes before the pivot
// the elements equal to pivot can go either side of the pivot

// Recursion: Recursively apply the above steps on the sub-array formed to the left side of pivot
// and on the sub-array formed on the right side of the pivot

// [a, b] with b < a will be considered empty
// [low, j - 1]: smaller or equal to pivot
// [j, i - 1]: greater than pivot
// [i, high]: yet to be traversed

public class QuickSort {

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int i = low, j = low;
        int pivot = arr[high];

        while (i <= high) { // condition, [i, high] will be have at least 1 element
            if (arr[i] <= pivot) {  // belong to j  ==> swap value
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
            i++;
        }
        return j - 1;
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // At final step
            // when arr[i] = arr[high] = pivot  ==> swap  ==> position j is pivot==> j++ & return j - 1
            // ==> p (return value of function) = position of pivot
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p+1, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 2, 4, 1, 3, 7, 8, 100};
        System.out.print("Original array: ");
        printArray(arr);
        System.out.println('\n');

        System.out.print("After sort elements: ");
        quickSort(arr, 0, arr.length - 1);
        printArray(arr);
    }
}
