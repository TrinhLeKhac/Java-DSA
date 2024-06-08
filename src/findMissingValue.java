// Given an array of n - 1 distinct numbers in the range of 1 to n
// Find the missing number in it

public class findMissingValue {
    public static void main(String[] args) {
        int[] arr = {5, 4, 2, 1};
        int missingValue = findMissing(arr);
        System.out.println(missingValue);
    }

    private static int findMissing(int[] arr) {
        int n = arr.length + 1;
        int sum = n * (n + 1) / 2;
        for (int ele : arr) {
            sum = sum - ele;
        }
        return sum;
    }
}
