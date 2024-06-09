// Given an array of integers. For each element in the array
// find its next greater element in that array
// The next greater element is the first element towards right, which is greater than the current element

import java.util.Arrays;
import java.util.Stack;

public class FindTheNextGreaterElement {
    public static int[] nextGreaterElement(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = arr.length - 1; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                 result[i] = -1;
            } else {
                 result[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] input = {4, 7, 3, 4, 8, 1};
        System.out.println("Input: " + Arrays.toString(input));
        int[] output = nextGreaterElement(input);
        System.out.println("Output: " + Arrays.toString(output));
    }
}
