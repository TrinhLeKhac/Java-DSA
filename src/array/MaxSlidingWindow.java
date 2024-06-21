package array;


// Given an array of integers arr, there is a sliding window of size k
// which is moving from very left of the array to the very right
// You can only see the k numbers in the window
// Each time the sliding window moves right by one position
// Return the max sliding window

// Input - {4, 7, 3, 4, 8, 1} and k = 3
// Output - {7, 7, 8, 8}

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MaxSlidingWindow {
    public static ArrayList<Integer> maxSlidingWindow(int[] arr, int k) {
        int[] ngeArr = nextGreaterElement(arr);
        ArrayList<Integer> result = new ArrayList<>();
        int j;
        for (int i = 0; i <= arr.length - k; i++) {
            j = i;
            while (ngeArr[j] < i + k) {
                j = ngeArr[j];
            }
            result.add(arr[j]);
        }
        return result;
    }

    private static int[] nextGreaterElement(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                result[i] = arr.length;
            } else {
                result[i] = stack.peek();
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 7, 3, 4, 8, 1};
        int slideSize = 3;
        ArrayList<Integer> result = maxSlidingWindow(arr, slideSize);
        System.out.print("The maximum integers with sliding: " + slideSize + " is: ");
        Utils.printArray(result);
    }
}
