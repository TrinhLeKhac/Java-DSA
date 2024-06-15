package search;

public class BinarySearch {
    public static int binarySearch(int[] arr, int n, int key) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            if (arr[mid] > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {1, 10, 20, 47, 59, 65, 75, 88, 99};
        int key = 65;
        int idx = binarySearch(nums, nums.length, key);
        if (idx == -1) {
            System.out.println("The element " + key + " not found in array");
        } else {
            System.out.println("The element " + key +  " found at position " + idx + " in array");
        }
    }
}
