import java.util.NoSuchElementException;

public class SinglyLinkedList {

    private Node head;
    private int length;

    public SinglyLinkedList() {
        this.head = null;
        this.length = 0;
    }

    public SinglyLinkedList(Node head) {
        int len = 0;
        Node current = head;
        while(current != null) {
            current = current.next;
            len++;
        }

        this.head = head;
        this.length = len;
    }

    private static class Node {
        private final int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public boolean isEmpty() {
        return this.length == 0;
    }
    public int length() {
        return this.length;
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("null");
    }

    public void insertFirst(int value) {
        Node node = new Node(value);
        if(isEmpty()) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
        length++;
    }

    public void insertLast(int value) {
        Node node = new Node(value);
        if(isEmpty()) {
            head = node;
            length++;
            return;
        }

        Node previous = head;
        while (previous.next != null) {
            previous = previous.next;
        }
        previous.next = node;
        length++;
    }

    public void insert(int position, int value) {
        if (position < 1) {
            throw new IllegalArgumentException("Position should be >= 1");
        }

        if (position == 1) {
            this.insertFirst(value);
            return;
        }

        Node node = new Node(value);
        Node previous = head;
        int count = 1;
        while (count < position - 1 && previous != null) {
            previous = previous.next;
            count++;
        }

        if (previous == null) {
            throw new IllegalArgumentException("Position exceeds the length of the list");
        }

        node.next = previous.next;
        previous.next = node;
        length++;
    }

    public Node removeFirst() {
        Node node = head;
        if (isEmpty()) {
            System.out.println("Empty LinkedList");
        } else {
            head = node.next;
            length--;
            node.next = null;
        }
        return node;
    }

    public Node removeLast() {
        if (isEmpty()) {
            System.out.println("Empty LinkedList");
            return head;
        }
        if (head.next == null) {
            Node node = head;
            head = null;
            length--;
            node.next = null;
            return node;
        }
        Node previous = head;
        while (previous.next.next != null) {
            previous = previous.next;
        }
        Node node = previous.next;
        previous.next = null;
        length--;
        return node;
    }

    public Node remove(int position) {

        if (isEmpty()) {
            throw new NoSuchElementException("Empty LinkedList");
        }
        if (position < 1) {
            throw new IllegalArgumentException("The postion need >= 1");
        }
        if(position == 1) {
            Node node = head;
            head = node.next;
            length--;
            node.next = null;
            return node;
        }
        if (this.length < position) {
            throw new IllegalArgumentException("The delete position exceeds the length of LinkedList");
        }

        Node previous = head;
        int count = 1;
        while (count < position - 1) {
            previous = previous.next;
            count++;
        }
        Node node = previous.next;
        previous.next = node.next;
        length--;
        node.next = null;
        return node;
    }

    public boolean find(int searchKey) {
        Node current = head;
        while (current != null) {
            if (current.data == searchKey) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void reverse() {
        Node previous = null;
        Node current = head;
        Node next;
        while(current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }

    public Node getNthNodeFromEnd(int n) {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty LinkedList");
        }
        if (n <= 0 || this.length < n) {
            throw new IllegalArgumentException("Invalid n: " + n);
        }
        Node current = head;
        for(int i = 0; i < this.length - n; i++) {
            current = current.next;
        }
        return current;
    }

    public void removeDuplicate() {
        Node current = head;
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
                length--;
            } else {
                current = current.next;
            }
        }
    }

    public boolean containLoop() {
        Node slowPtr = head;
        Node fastPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr) {
                return true;
            }
        }
        return false;
    }

    public Node startNodeInALoop() {
        Node slowPtr = head;
        Node fastPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr) {
                return getStartingNode(slowPtr);
            }
        }
        return null;
    }

    private Node getStartingNode(Node slowPtr) {
        Node temp = head;
        while (temp != slowPtr) {
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        return temp;
    }

    public static SinglyLinkedList createASinglyLinkedList(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Array of values in Singly Linked List is null");
        }
        if (arr.length == 0) {
            throw new IllegalArgumentException("Array of values of Singly Linked List is empty");
        }

        SinglyLinkedList sll = new SinglyLinkedList();
        sll.head = new Node(arr[0]);
        sll.length = arr.length;
        Node temp = sll.head;

        for (int i = 1; i < arr.length; i++) {
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }

        return sll;
    }

    public static SinglyLinkedList createALoopInLinkedList() {
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);
        Node sixth = new Node(6);

        // Link all nodes to a chain
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.head = first;
        sll.length = 6;

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = third;

        return sll;
    }

    public static Node merge(Node a, Node b) {
        Node dummy = new Node(0);
        Node tail = dummy;

        while (a != null && b != null) {
            if (a.data < b.data) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        tail.next = (a != null) ? a : b;

        return dummy.next;
    }

    public static Node add(Node a, Node b) {
        Node dummy = new Node(0);
        Node tail = dummy;
        int carry = 0;
        int value = 0;

        while (a != null || b != null) {
            int x = (a != null) ? a.data : 0;
            int y = (b != null) ? b.data : 0;
            int sum = x + y + carry;

            System.out.println(x + " + " + y + " + " + carry + "(carry) = " + sum % 10 + "(carry " + sum / 10 + ")");

            carry = sum / 10;
            value = sum % 10;
            Node node = new Node(value);
            tail.next = node;
            tail = tail.next;

            if (a != null) {  // avoid NullPointerException
                a = a.next;
                SinglyLinkedList sll_tmp_a = new SinglyLinkedList(a);
                sll_tmp_a.display();
//                System.out.println(sll_tmp_a.length);
            }
            if (b != null) {  // avoid NullPointerException
                b = b.next;
                SinglyLinkedList sll_tmp_b = new SinglyLinkedList(b);
                sll_tmp_b.display();
//                System.out.println(sll_tmp_b.length);
            }
        }

        if (carry != 0) {
            tail.next = new Node(carry);
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 4, 4};
        SinglyLinkedList sll = createASinglyLinkedList(arr);
        System.out.println("----------------Length of SLL-----------------------");
        sll.display();
        System.out.println("Length: " + sll.length());
        System.out.println('\n');

        System.out.println("-------------------insertFirst--------------------");
        sll.insertFirst(0);
        sll.display();
        System.out.println("Length: " + sll.length());
        System.out.println('\n');

        System.out.println("----------------insertLast-----------------------");
        sll.insertLast(5);
        sll.display();
        System.out.println("Length: " + sll.length());
        System.out.println('\n');

        System.out.println("----------------insert any position-----------------------");
        sll.insert(3, 2);
        sll.display();
        System.out.println("Length: " + sll.length());
        System.out.println('\n');

        System.out.println("----------------removeDuplicate-----------------------");
        sll.removeDuplicate();
        sll.display();
        System.out.println("Length: " + sll.length());
        System.out.println('\n');

        System.out.println("----------------removeFirst-----------------------");
        Node a = sll.removeFirst();
        sll.display();
//        Node x = sll.removeFirst();
//        sll.display();
//        Node y = sll.removeFirst();
//        sll.display();
//        Node z = sll.removeFirst();
//        sll.display();
//        Node u = sll.removeFirst();
//        sll.display();
//        Node v = sll.removeFirst();
//        sll.display();
        System.out.println("Remove element: " + a.data);
        System.out.println("Length: " + sll.length());
        System.out.println('\n');

        System.out.println("-----------------removeLast----------------------");
        Node b = sll.removeLast();
        sll.display();
        System.out.println("Remove element: " + b.data);
        System.out.println("Length: " + sll.length());
        System.out.println('\n');

        System.out.println("-----------------remove element in any position----------------------");
        Node c = sll.remove(4);
        sll.display();
        System.out.println("Remove element: " + c.data);
        System.out.println("Length: " + sll.length());
        System.out.println('\n');

        System.out.println("----------------reverse-----------------------");
        sll.reverse();
        sll.display();
        System.out.println("Length of SLL: " + sll.length());
        System.out.println('\n');

        System.out.println("----------------nthNodeFromTheEnd-----------------------");
        int n = 1;
        Node nthNodeFromTheEnd = sll.getNthNodeFromEnd(n);
        sll.display();
        System.out.println("The " + n + "nth element from the end of SinglyLinkedList: " + nthNodeFromTheEnd.data);
        System.out.println('\n');

        System.out.println("------------------searchKey---------------------");
        int searchKey = 1;
        if (sll.find(searchKey)) {
            System.out.println("Found element " + searchKey + " in SinglyLinkedList");
        } else {
            System.out.println("Element " + searchKey + " not found in SinglyLinkedList");
        }
        System.out.println('\n');

        System.out.println("----------------containLoop-----------------------");
        SinglyLinkedList sllWithLoop = createALoopInLinkedList();
        if (sllWithLoop.containLoop()) {
            System.out.println("Singly Linked List contains a loop");
        } else {
            System.out.println("Singly Linked List does not contain a loop");
        }
        System.out.println('\n');

        System.out.println("----------------startNodeInALoop-----------------------");
        Node startNodeInALoop = sllWithLoop.startNodeInALoop();
        if (startNodeInALoop != null) {
            System.out.println("Start node in a loop of Singly Linked List is: " + startNodeInALoop.data);
        } else {
            System.out.println("Singly Linked List does not contain a loop");
        }
        System.out.println('\n');

        System.out.println("----------------Merge two SinglyLinkedLists-----------------------");
        int[] arr1 = {1, 4, 9, 11, 13};
        int[] arr2 = {3, 6, 7, 10, 1001};
        SinglyLinkedList sll_a = createASinglyLinkedList(arr1);
        SinglyLinkedList sll_b = createASinglyLinkedList(arr2);

        System.out.print("First SinglyLinkedList: ");
        sll_a.display();
        System.out.print("Second SinglyLinkedList: ");
        sll_b.display();

        Node mergedHead = merge(sll_a.head, sll_b.head);
        SinglyLinkedList sll_merged = new SinglyLinkedList(mergedHead);
        System.out.print("Merged SinglyLinkedList: ");
        sll_merged.display();
        System.out.println("Length: " + sll_merged.length());
        System.out.println('\n');

        System.out.println("----------------Add two SinglyLinkedLists-----------------------");
        int[] arr3 = {8, 5, 7, 9, 8, 4, 7};
        int[] arr4 = {3, 8, 5, 7, 9, 9};
        SinglyLinkedList sll_c = createASinglyLinkedList(arr3);
        System.out.print("First SinglyLinkedList: ");System.out.print("First SinglyLinkedList: ");
        sll_c.display();
        SinglyLinkedList sll_d = createASinglyLinkedList(arr4);
        System.out.print("Second SinglyLinkedList: ");
        sll_d.display();
        Node addedHead = add(sll_c.head, sll_d.head);
        SinglyLinkedList sll_added = new SinglyLinkedList(addedHead);
        System.out.print("Added SinglyLinkedList: ");
        sll_added.display();
        System.out.println("Length: " + sll_added.length());
        System.out.println('\n');
    }
}
