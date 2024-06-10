// Its an ordered list in which insertion are done at one end, called as rear
// and deletion are done at other end called as front
// The first element inserted is the first one to be deleted, hence it is called as First In First Out (FIFO) list

import java.awt.desktop.SystemSleepEvent;
import java.util.NoSuchElementException;

public class QueueFromLinkedList {

    private Node front, rear;
    private int length;

    private static class Node {
        private int data;
        private Node next;
        public Node (int value) {
            this.data = value;
            this.next = null;
        }
    }
    public QueueFromLinkedList() {
        this.front = null;
        this.rear = null;
        this.length = 0;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int length() {
        return length;
    }

    public void enqueue(int data) {
        Node node = new Node(data);
        if(isEmpty()) {
            front = node;
        } else {
            rear.next = node;
        }
        rear = node;
        length++;
    }

    public void display() {
        if(isEmpty()) {
            System.out.println("null");
            return;
        }
        Node current = front;
        while(current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("null");
    }

    public int dequeue() {
        if(isEmpty()) {
            throw new NoSuchElementException("Queue is already empty");
        }
        Node node = front;
        front = node.next;
        if(front == null) {
            rear = null;
        }
        node.next = null;
        length--;
        return node.data;
    }

    public int first() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is already empty");
        }
        return front.data;
    }

    public int last() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is already empty");
        }
        return rear.data;
    }

    public static void main(String[] args) {
        System.out.println("-----------------QueueFromLinkedList----------------------");
        QueueFromLinkedList qll = new QueueFromLinkedList();
        qll.enqueue(1);
        qll.enqueue(2);
        qll.enqueue(3);
        int a = qll.dequeue();
        System.out.println("Dequeue values " + a + " from Queue");
        qll.display();
        System.out.println("The first element is: " + qll.first());
        System.out.println("The last elemnt is: " + qll.last());
        System.out.println('\n');
    }
}
