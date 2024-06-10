// Generate binary number from 1 to n using a Queue

// Example -
// Input: n = 3
// Output: {1, 10, 11}

// enqueue: offer
// dequeue: poll

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryNumberUsingQueue {
    public static String[] generateBinaryNumber(int n) {
        String[] result = new String[n];
        Queue<String> queue = new LinkedList<>();
        queue.offer("1");
        for (int i = 0; i < n; i++) {
            result[i] = queue.poll();
            String n1 = result[i] + "0";
            String n2 = result[i] + "1";
            queue.offer(n1);
            queue.offer(n2);
        }
        return result;
    }
    public static void main(String[] args) {
        String[] result = generateBinaryNumber(16);
        System.out.println(Arrays.toString(result));
    }
}
