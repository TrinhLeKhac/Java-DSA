// Its an ordered list in which insertion and deletion are done at one end
// The last element inserted is the first one to be deleted.
// Therefore it is called as Last In First Out (LIFO) list

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class StackImplement {
    private int length;
    private Node top;

    private static class Node {
        private int data;
        private Node next;
        public Node (int value) {
            this.data = value;
            this.next = null;
        }
    }

    public StackImplement() {
        this.length = 0;
        this.top = null;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public int length() {
        return this.length;
    }

    public void push(int data) {
        Node node = new Node(data);
        node.next = top;
        top = node;
        length++;
    }

    public int pop() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        int data = top.data;
        top = top.next;
        length--;
        return data;
    }

    public int peek() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public void display() {
        Node current = top;
        if(current == null) {
            System.out.println("null");
            return;
        }
        while(current.next != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println(current.data);
    }

    public static void main(String[] args) {

        System.out.println("----------------push-----------------------");
        StackImplement stack = new StackImplement();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.print("The stack: ");
        stack.display();
        System.out.println("The length of DLL is: " + stack.length);

        int a = stack.pop();
        System.out.print("The stack: ");
        stack.display();
        System.out.println("The pop value: " + a);
        System.out.println("The length of DLL is: " + stack.length);

        stack.pop();
        System.out.print("The stack: ");
        stack.display();
        System.out.println("The length of DLL is: " + stack.length);

        System.out.println("The peek value: " + stack.peek());
//        stack.pop();
//        stack.display();
//        System.out.println("The length of DLL is: " + stack.length);

    }

}
