import java.util.NoSuchElementException;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    private static class Node {
        private int data;
        private Node previous;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.previous = null;
            this.next = null;
        }
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public int length() {
        return this.length;
    }

    public void displayForward() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("null");
    }

    public void displayBackward() {
        Node current =tail;
        while(current != null) {
            System.out.print(current.data + "->");
            current = current.previous;
        }
        System.out.println("null");
    }

    public void insertFirst(int value) {
        Node node = new Node(value);
        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            head.previous = node;
            node.next = head;
            head = node;
        }
        length++;
    }

    public void insertLast(int value) {
        Node node = new Node(value);
        if(isEmpty()) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
        length++;
    }

    public Node deleteFirst() {
        if(isEmpty()) {
            throw new NoSuchElementException("Can not delete element from empty Doubly Linked List");
        }
        Node temp = head;
        if (head == tail) {
            tail = null;
        }
        else {
            head.next.previous = null;
        }
        head = head.next;
        temp.next = null;
        length--;
        return temp;
    }

    public Node deleteLast() {
        if(isEmpty()) {
            throw new NoSuchElementException("Can not delete element from empty Doubly Linked List");
        }
        Node temp = tail;
        if (tail == head) {
            head = null;
        } else {
            tail.previous.next = null;
        }
        tail = tail.previous;
        temp.previous = null;
        length--;
        return temp;
    }

    public static void main(String[] args) {
        System.out.println("----------------create DoublyLinkedList-----------------------");
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertFirst(3);
        dll.insertFirst(2);
        dll.insertFirst(1);
        dll.insertLast(4);
        dll.insertLast(5);
        dll.insertLast(6);
        System.out.println("The length of DLL is: " + dll.length);
        System.out.println("----------------displayForward-----------------------");
        dll.displayForward();
        System.out.println("----------------displayBackward-----------------------");
        dll.displayBackward();
        System.out.println('\n');

        System.out.println("----------------create deleteFirst-----------------------");
        Node dlfNode = dll.deleteFirst();
        System.out.println("The node has been delete is: " + dlfNode.data);
        dll.displayForward();
        System.out.println("The length of DLL is: " + dll.length);
        System.out.println('\n');

        System.out.println("----------------create deleteLast-----------------------");
        Node dflNode = dll.deleteLast();
        System.out.println("The node has been delete is: " + dflNode.data);
        dll.displayForward();
        System.out.println("The length of DLL is: " + dll.length);
        System.out.println('\n');
    }

}
