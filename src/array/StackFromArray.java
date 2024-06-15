// implement Stack from Array

package array;
import java.util.EmptyStackException;

public class StackFromArray {

    private int top;
    private int[] arr;

    StackFromArray(int capacity) {
        this.top = -1; // Empty stack
        arr = new int[capacity];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    public boolean isFull() {
        return top + 1 == arr.length;
    }

    public void push(int value) {
        if(isFull()) {
            throw new StackOverflowError("Stack is full");
        }
        top++;
        arr[top] = value;
    }

    public int pop() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        int data = arr[top];
        top--;
        return data;
    }

    public int peek() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        return arr[top];
    }

    public static void main(String[] args) {

        System.out.println("----------------Stack-----------------------");
        StackFromArray stack = new StackFromArray(2);
        if (stack.isEmpty()) {
            System.out.println("The stack is empty");
        } else {
            System.out.println("The stack is not empty");
        }

        stack.push(1);
        stack.push(2);
        System.out.println("The top element in stack is: " + stack.peek());
//        stack.push(5); //Push element into full stack;
        int a = stack.pop();
        int b = stack.pop();
//        int c = stack.pop(); //Pop element from emtpy stack;
    }
}
