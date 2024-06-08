public class SinglyLinkedList {

    private Node head;

    public SinglyLinkedList() {}

    public  SinglyLinkedList(Node head) {
        this.head = head;
    }

    private static class Node {
        private final int data;
        private Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private int length() {
        Node current = this.head;
        int count = 0;
        while(current != null) {
            current = current.next;
            count++;
        }
        return count;
    }

    private void display() {
        Node current = this.head;
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("null");
    }

    private void insertFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;
    }

    private void insert(int postion, int value) {
        Node node = new Node(value);
        if (postion == 1) {
            node.next = this.head;
            this.head = node;
        } else {
            Node previous = this.head;
            int count = 1;
            while(count < postion - 1) {
                previous = previous.next;
                count += 1;
            }
            node.next = previous.next;
            previous.next = node;
        }
    }

    private void insertLast(int value) {
        Node node = new Node(value);
        if (this.head == null) {
            this.head = node;
        } else {
            Node current = head;
            while(current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
    }

    private void deleteFirst() {
        if (head != null) {
            head = head.next;
        }
        if (head == null) {
            System.out.println("Empty LinkedList");
        }
    }

    private void deleteLast() {
        if (head.next != null) {
            Node previous = null;
            Node current = head;
            while (current.next != null) {
                previous = current;
                current = current.next;
            }
            previous.next =  null;
        } else {
            head = null;
        }
        if (head == null) {
            System.out.println("Empty LinkedList");
        }
    }

    private void delete(int postion) {
        if (head == null) {
            System.out.println("Empty LinkedList");
        }
        if (head.next == null && postion == 1) {
            head = null;
            System.out.println("Empty LinkedList");
        }
        if (head.next == null && postion > 1){
            System.out.println("The delete postion exceed the length of LinkedList");
        }
        if (head.next != null && postion == 1) {
            head = head.next;
        }
        if (head.next != null && postion > 1) {
            Node previous = null;
            Node current = head;
            int count = 1;
            while (count < postion && current.next != null) {
                previous = current;
                current = current.next;
                count++;
            }
            if (count == postion) {
                previous.next = current.next;
            } else {
                System.out.println("The delete postion exceed the length of LinkedList");
            }
        }
    }

    private boolean find(int searchKey) {
        if (head == null) {
            return false;
        }
        Node current = head;
        while (current != null) {
            if (current.data == searchKey) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    private void reverse() {
        Node previous = null;
        Node current = head;
        Node next = head;
        while(current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }

    private Node getNthNodeFromEnd(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Invalid n: " + n);
        }
        if (head == null) {
            head = null;
        }
        Node mainPtr = head;
        Node refPtr = head;
        int count = 0;
        while (count < n) {
            if (refPtr == null) {
                throw new IllegalArgumentException("The postion " + n + " exceeds the length of SinglyLinkedList");
            }
            refPtr = refPtr.next;
            count++;
        }
        while(refPtr != null) {
            mainPtr = mainPtr.next;
            refPtr = refPtr.next;
        }
        return mainPtr;
    }

    private void removeDuplicate() {
        Node current = head;
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    private boolean containLoop() {
        Node slowPtr = head;
        Node fastPrt = head;
        while (fastPrt != null && fastPrt.next != null) {
            slowPtr = slowPtr.next;
            fastPrt = fastPrt.next.next;
            if (slowPtr == fastPrt) {
                return true;
            }
        }
        return false;
    }

    private Node startNodeInALoop() {
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
            temp =  temp.next;
            slowPtr = slowPtr.next;
        }
        return temp;
    }

    private static SinglyLinkedList createASinglyLinkedList(int[] arr) {

        if (arr == null) {
            throw new IllegalArgumentException("Array of values in Singly Linked List is null");
        }
        int n = arr.length;
        if (n == 0) {
            throw new IllegalArgumentException("Array of values of Singly Linked List is empty");
        }

        Node[] nodes = new Node[n];

        for (int i = 0; i < n; i++) {
            Node temp = new Node(arr[i]);
            nodes[i] = temp;
        }

        // Link all nodes to a chain
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.head = nodes[0];  // anchor
        Node temp = sll.head;  // loop and connect nodes
        for (int i = 1; i < n; i++) {
            temp.next = nodes[i];
            temp = temp.next;
        }

        return sll;
    }

    private static SinglyLinkedList createALoopInLinkedList() {
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(4);
        Node sixth = new Node(4);

        // Link all nodes to a chain
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.head = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = third;

        return sll;
    }

    private static Node merge(Node a, Node b) {
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
        if (a == null) {
            tail.next = b;
        }
        if (b == null) {
            tail.next = a;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        SinglyLinkedList sll = createASinglyLinkedList(arr);
        System.out.println("----------------Length of SLL-----------------------");
        sll.display();
        System.out.println("Length: " + sll.length());
        System.out.println('\n');

        System.out.println("-------------------insertFirst--------------------");
        sll.insertFirst(0);
        sll.display();
        System.out.println('\n');

        System.out.println("----------------insertLast-----------------------");
        sll.insertLast(5);
        sll.display();
        System.out.println('\n');

        System.out.println("----------------insert any postion-----------------------");
        sll.insert(2, 101);
        sll.display();
        System.out.println('\n');

        System.out.println("----------------deleteFirst-----------------------");
        sll.deleteFirst();
        sll.display();

        System.out.println("-----------------deleteLast----------------------");
        sll.deleteLast();
        sll.display();
        System.out.println('\n');

        System.out.println("-----------------delete any postion----------------------");
        sll.delete(5);
        sll.display();
        System.out.println('\n');

        System.out.println("----------------reverse-----------------------");
        sll.reverse();
        sll.display();
        System.out.println("Lengh of SLL: " + sll.length());
        System.out.println('\n');

        System.out.println("----------------nthNodeFromTheEnd-----------------------");
        int n = 4;
        Node nthNodeFromTheEnd = sll.getNthNodeFromEnd(n);
        sll.display();
        System.out.println("The nth element from the end of SinglyLinkedList " + nthNodeFromTheEnd.data);
        System.out.println('\n');

        System.out.println("------------------searchKey---------------------");
        int searchKey = 1;
        if (sll.find(searchKey)) {
            System.out.println("Find element " + searchKey + " in SinglyLikedList");
        } else {
            System.out.println("Find no element " + searchKey + " in SinglyLinkedList");
        }
        System.out.println('\n');


        System.out.println("----------------containLoop-----------------------");
        SinglyLinkedList sllWithLoop = createALoopInLinkedList();
        if (sllWithLoop.containLoop()) {
            System.out.println("Singly Linked List have loop");
        } else {
            System.out.println("Singly Linked List have no loop");
        }
        System.out.println('\n');

        System.out.println("----------------startNodeInALoop-----------------------");
        Node startNodeInALoop = sllWithLoop.startNodeInALoop();
        if (startNodeInALoop != null) {
            System.out.println("startNodeInALoop of Singly Linked List is: " + startNodeInALoop.data);
        } else {
            System.out.println("Singly Linked List have no loop");
        }
        System.out.println('\n');

        System.out.println("----------------Merge two SinglyLinkedList-----------------------");
        int[] arr1 = {1, 4, 9, 11, 13};
        int[] arr2 = {3, 6, 7, 10, 1001};
        SinglyLinkedList sll_a = createASinglyLinkedList(arr1);
        SinglyLinkedList ssl_b = createASinglyLinkedList(arr2);
        Node a = sll_a.head;
        Node b = ssl_b.head;
        Node merge = merge(a, b);
        SinglyLinkedList sll_merge = new SinglyLinkedList(merge);
        sll_merge.display();

    }

}
