// Its similar to Singly Linked List, with a difference that in
// Circular Linked List the last node points to first node and not null
// Instead of head, we keep track of last nodee in Circular Singly List

import java.util.NoSuchElementException;

public class CircularSInglyLinkedList {
    private int length;
    private Node last;

    private static class Node {
        private int data;
        private Node next;
        public Node(int value) {
            this.data = value;
            this.next = null;
        }
    }

    public CircularSInglyLinkedList() {
        this.length = 0;
        this.last = null;
    }

    public int size() {
        return this.length;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public void display() {
        if(isEmpty()) {
            System.out.println("null");
            return;
        }
        Node current = this.last.next;
        while(current != this.last) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.print(current.data + "->");
        System.out.println(current.next.data);
    }

    public void insertFirst(int value) {
        Node node = new Node(value);
        if(isEmpty()) {
            last = node;
        } else {
            node.next = last.next;
        }
        last.next = node;
        length++;
    }

    public void insertLast(int value) {
        Node node = new Node(value);
        if(isEmpty()) {
            last = node;
            last.next = node;
        } else {
            node.next = last.next;
            last.next = node;
            last = node;
        }
        length++;
    }

    public Node removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Circular Singly Linked List is already empty");
        }
        Node node = last.next;
        if (this.length == 1) {
            last = null;
        }
        if (this.length > 1) {
            last.next = node.next;
        }
        node.next = null;
        length--;
        return node;
    }

    public Node removeLast() {
        if(isEmpty()) {
            throw new NoSuchElementException("Cannot remove element from Empty Circular Singly Linked List");
        }
        Node node = last;
        if (this.length == 1) {
            last = null;
        }
        if (this.length > 1) {
            Node current = node.next;
            while (current.next != node) {
                current = current.next;
            }
            current.next = node.next;
            last = current;
        }
        node.next = null; // remove circular in node
        length--;
        return node;
    }

    public static CircularSInglyLinkedList createCircularLinkedList(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            throw new NoSuchElementException("Cannot create CircularLinkedList from empty array");
        }
        CircularSInglyLinkedList csll = new CircularSInglyLinkedList();
        Node[] nodes = new Node[n];
        for(int i = 0; i < n; i++) {
            Node temp = new Node(arr[i]);
            nodes[i] = temp;
        }
        for(int i = 0; i < n; i++) {
            nodes[i].next = nodes[(i + 1) % n];
        }
        csll.length = n;
        csll.last = nodes[n - 1];

        return csll;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        CircularSInglyLinkedList csll = createCircularLinkedList(arr);
        csll.display();
        System.out.println("The length of DLL is: " + csll.size());
        System.out.println('\n');

        System.out.println("----------------insertFirst-----------------------");
        csll.insertFirst(10);
        csll.display();
        System.out.println("The length of DLL is: " + csll.size());
        System.out.println('\n');

        System.out.println("----------------insertLast-----------------------");
        csll.insertLast(100);
        csll.display();
        System.out.println("The length of DLL is: " + csll.size());
        System.out.println('\n');

        System.out.println("----------------removeFirst-----------------------");
        Node a = csll.removeFirst();
        Node b = csll.removeFirst();
        csll.display();
        System.out.println("The elements are already remove: " + a.data + ", " + b.data);
        System.out.println("The length of DLL is: " + csll.size());
        System.out.println('\n');

        System.out.println("----------------removeLast-----------------------");
        Node c = csll.removeLast();
        csll.display();
        System.out.println("The elements are already remove: " + c.data);
        System.out.println("The length of DLL is: " + csll.size());
        System.out.println('\n');

//        csll.removeFirst();
//        csll.removeFirst();
//        csll.removeFirst();
//        csll.display();
//        csll.removeFirst();
//        System.out.println("The length of DLL is: " + csll.size());
//        System.out.println('\n');

        // Insert again
//        csll.insertFirst(100);
//        csll.insertLast(100);
//        csll.display();
    }
}
