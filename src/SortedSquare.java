// Input: sorted array - Example: {-4, -1, 0, 3, 10}
// Output: sorted array with element is square of element of input array - Example [0, 1, 9, 16, 100}

public class SortedSquare {

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int[] sortSquare(int[] arr) {

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
        printArray(arr);
        System.out.println('\n');

        System.out.print("After sort elements: ");
        int[] result = sortSquare(arr);
        printArray(result);
    }
}
