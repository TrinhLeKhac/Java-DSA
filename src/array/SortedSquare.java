// Input: sorted array - Example: {-4, -1, 0, 3, 10}
// Output: sorted array with element is square of element of input array - Example [0, 1, 9, 16, 100}

package array;

public class SortedSquare {

    public static int[] sortedSquare(int[] arr) {

        int n = arr.length;
        int[] result = new int[n];

        int i = 0;
        int j = n - 1;
        for (int k = n - 1; k >= 0; k--) {
            if (Math.abs(arr[i]) > Math.abs(arr[j])) {
                result[k] = arr[i] * arr[i];
                i++;
            } else {
                result[k] = arr[j] * arr[j];
                j--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {-4, -1, 0, 3, 10};
        System.out.print("Original array: ");
        Utils.printArray(arr);
        System.out.println('\n');

        System.out.print("After sort elements: ");
        int[] result = sortedSquare(arr);
        Utils.printArray(result);
    }
}
