// Sort an array of 0s, 1s and 2s in linear time and constant space

package array;

public class DutchNationalFlagProblem {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void solution(int[] arr) {
        int i = 0, j = 0, k = arr.length - 1;
        // region [a, b] with b < a equivalent to empty
        // [0, i - 1]: 0s   ==> upper boundary of 0s is i - 1  ==> extend by i++
        // [i, j - 1]: 1s   ==> upper boundary of 1s is j - 1  ==> extend by j++
        // [j, k]: un-sort
        // [k + 1, arr.length - 1]: 2s  ==> lower boundary of 2s is k ==> extend by k--;
        // initially, region of 0s, 1s, 2s is empty (i - 1 < 0, j - 1 < i, arr.length - 1 < k + 1)
        // we extend region of 0s, 1s, 2s and narrow region of un-sorted elements

        while (j <= k) {  // j > k => [j, k] empty ==> stop condition
            if (arr[j] == 0) {
                swap(arr, i, j);
                i++;
                j++;
            }
            else if (arr[j] == 1) {
                j++;
            }
            else if (arr[j] == 2) {
                swap(arr, j, k);
                k--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 0, 2, 2, 0, 1, 1};
        System.out.print("Original array: ");
        Utils.printArray(arr);

        System.out.print("Sorted array: ");
        solution(arr);
        Utils.printArray(arr);
    }
}
