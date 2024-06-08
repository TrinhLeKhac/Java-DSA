public class SinglyLinkedList {

    private Node head;

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

    public static void main(String[] args) {

        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);

        // Link all nodes to a chain
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.head = first;
        first.next = second;
        second.next = third;
        third.next = fourth;

        sll.display();
        System.out.println("Length of SLL: " + sll.length());

        sll.insertFirst(10);
        sll.display();
        System.out.println("Length of SLL: " + sll.length());

        sll.insertLast(100);
        sll.display();
        System.out.println("Length of SLL: " + sll.length());

        sll.insert(2, 1001);
        sll.display();
        System.out.println("Lengh of SLL: " + sll.length());

        sll.deleteFirst();
        sll.display();
        System.out.println("Lengh of SLL: " + sll.length());

        sll.deleteLast();
        sll.display();
        System.out.println("Lengh of SLL: " + sll.length());

        sll.delete(5);
        sll.display();
        System.out.println("Lengh of SLL: " + sll.length());

        sll.delete(5);
        sll.display();
        System.out.println("Lengh of SLL: " + sll.length());

//        int searchKey = 1;
//        if (sll.find(searchKey)) {
//            System.out.println("Find element " + searchKey + " in SinglyLikedList");
//        } else {
//            System.out.println("Find no element " + searchKey + " in SinglyLinkedList");
//        }

        sll.reverse();
        sll.display();
        System.out.println("Lengh of SLL: " + sll.length());

        int n = 4;
        Node nthNodeFromTheEnd = sll.getNthNodeFromEnd(n);
        sll.display();
        System.out.println("The nth element from the end of SinglyLinkedList " + nthNodeFromTheEnd.data);

    }

}
