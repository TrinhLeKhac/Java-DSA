// Priority Queue is a data structure that allows us to find minimum/maximum element among a collection of elements
// in constant time. It supports following operations -
// insert(key)
// deleteMax()/ deleteMin() - return and remove largest/smallest key
// getMax()/getMin() - return largest/smallest key

// Binary Heap is a data structure that helps us in implementing Priority Queue operations efficiently
// A binary heap is a complete binary tree in which each node values is >= (or <=) than the values of its children
// Min Heap <> Max Heap

// Binary Heap usually is implemented using array (the first element is empty)
// The other elements are filled by traversing Binary Heap level by level from left to right

// Bottom-up Reheapify Max Heap
// After insert an element into heap. It may not satisfy above heap property
// Thus, we perform bottom-up reheapify technique, in which we adjust the locations
// of elements to satisfy heap property

// Complete Binary Tree
// A complete binary tree is a binary tree where all levels are completely filled except last level
// and last level has nodes in such a way that left side is never empty

package queue;
import java.util.Arrays;

public class MaxPriorityQueue {
    private Integer[] heap;
    private int n;

    public MaxPriorityQueue(int capacity) {
        this.heap = new Integer[capacity + 1];
        this.n = 0;
    }

    public boolean isEmpty() {
        return this.n == 0;
    }
    public int length() {
        return this.n;
    }

    public void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    public void insert(int x) {
        if (n == heap.length - 1) {
            System.out.println("Old capacity of heap: " + (heap.length - 1) + ". ");
            System.out.println("Insert to many element to MPQ. Resize capacity of heap to " + (heap.length * 2 - 1));
            resize(heap.length*2);
        }
        n++;
        heap[n] = x;
        swim(n);
    }

    private void resize(int size) {
        Integer[] temp = new Integer[size];
        for (int i = 0; i < heap.length; i++) {
            temp[i] = heap[i];
        }
        heap = temp;
    }

    private void swim(int size) {   // bottom up
        while (size > 1 && heap[size/2] < heap[size]) {
            swap(heap[size/2], heap[size]);
            size = size/2;
        }
    }

    // The maximum value is at the top which is root of complete binary tree. Its represent at index 1 e.e. heap[1]
    public int deleteMax() {
        int max = heap[1];
        swap(heap[1], heap[n]);
        n--;
        sink(1);
        heap[n+1] = null;
        if (n > 0 && n == (heap.length-1)/4) {  // delete too many elements  => resize heap.length
            resize(heap.length/2);
        }
        return max;
    }

    private void sink(int i) {
        while (i <= n) {
            int k = 2*i;
            if (k < n && heap[k] < heap[k+1]) {
                k++;
            }
            if (heap[i] >= heap[k]) {
                return;
            }

            swap(heap[i], heap[k]);
            i = k;
        }
    }

    public static void main(String[] args) {
        MaxPriorityQueue mpq = new MaxPriorityQueue(3);
        System.out.println(mpq.length());
        System.out.println(mpq.isEmpty());

        System.out.println("----------------insert Element to Heap-----------------------");
        mpq.insert(10);
        mpq.insert(4);
        mpq.insert(12);
        mpq.insert(9);
        mpq.insert(25);
        mpq.insert(101);
        System.out.println(Arrays.toString(mpq.heap));
    }
}
