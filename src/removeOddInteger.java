// Given an array of integers, return an array with odd integers removed

//    Input: arr = {3, 2, 4, 7, 10, 6, 5}
//    Output: arr = {2, 4, 10, 6}

public class removeOddInteger {

    public static int[] removeOdd(int[] arr) {
        int evenCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                evenCount++;
            }
        }
        int[] res = new int[evenCount];
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                res[idx] = arr[i];
                idx++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int[] res = removeOdd(arr);
        Utils.printArray(res);
    }
}
