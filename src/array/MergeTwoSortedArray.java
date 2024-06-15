package array;

public class MergeTwoSortedArray {

    public static int[] mergeTwoSortedArray(int[] arr1, int[] arr2, int m, int n) {

        int[] result = new int[m + n];

        int i = 0; // traverse arr1
        int j = 0; // traverse arr2
        int k = 0; //traverse result
        while (i < m && j < n) {  // boundary condition
            if (arr1[i] < arr2[j]) {  // if arr1 element at i is less than arr2 element at j
                result[k] = arr1[i];  // storing arr1 element into result
                i++;
            } else {
                result[k] = arr2[j];  // storing arr2 element into result
                j++;
            }
            k++;
        }
        // either arr1 got exhausted or arr2 got exhausted
        while (i < m) {   // arr2 got exhausted
            result[k] = arr1[i];  // storing arr1 element into result
            k++;
            i++;
        }
        while (j < n) {    // arr1 got exhausted
            result[k] = arr2[j];  // storing arr2 element into result
            k++;
            j++;
        }
        return result;


    }
    public static void main(String[] args) {
        int[] arr1 = {2, 4, 8, 11, 13, 17, 18, 100};
        int[] arr2 = {1, 2, 4, 15, 25, 37, 75, 101};
        System.out.print("Array 1: ");
        Utils.printArray(arr1);

        System.out.print("Array 2: ");
        Utils.printArray(arr2);

        int[] arr = mergeTwoSortedArray(arr1, arr2, arr1.length, arr2.length);
        System.out.print("Array: ");
        Utils.printArray(arr);
    }
}
