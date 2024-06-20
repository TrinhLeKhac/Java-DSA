package array;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static void printArrayBasic(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void printArray(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            System.out.println("Empty array found!");
        }
        if (n == 1){
            System.out.print("{" + arr[n-1] + "}");
        }
        if (n > 1) {
            System.out.print("{");
            for (int i = 0; i < n-1; i++) {
                System.out.printf("%d, ", arr[i]);
            }
            System.out.printf("%d", arr[n-1]);
            System.out.print("}");
        }
        System.out.println();
    }

    public static void printArray(List<Integer> arr) {
        int n = arr.size();
        if (n == 0) {
            System.out.println("Empty ArrayList found!");
        }
        if (n == 1){
            System.out.print("{" + arr.getFirst() + "}");
        }
        if (n > 1) {
            System.out.print("{");
            for (int i = 0; i < n-1; i++) {
                System.out.printf("%d, ", arr.get(i));
            }
            System.out.printf("%d", arr.get(n-1));
            System.out.print("}");
        }
        System.out.print("");
    }
}
