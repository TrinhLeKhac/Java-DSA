package hash;
// Search in arbitrary array take O(n)
// Search in sorted array take 0(logn) (binary search)
// Search in array such as {4, 1, 3, 6} which arrange with index {null, 1, null, 3, 4, null, 6} take O(1)
// (Jump directed into index to get values)

// In case array with large values (such as CardID 12 numbers)  ==> take a lot abundant memory

// Solution: hashing

// Method: hashing key
// index = h(key) = key % size
// Example -
// array {5, 1, 10, 26, 99}  ==> size = 10 ==> index {5, 1, 0, 6, 9} ==> {0, 1, null, null, null, 5, 6, null, null, 9}


// Hash table
// It is a generalized form of an array
// It stores the data in form of key-value pair
// It convert key to an index using hash function
// The primary operations -
// put(key, value)
// get(key)
// remove(key)

// Average running time is of O(1)
// Java Collections Framework -
// HashMap class - deal with key-value pair
// HashSet class - deal with only keys

// Collision Resolution Technique (Separate Chaining)
// key-value space: {(5, John), (1, Tom), (105, Mary)}
// size = 10  ==> (5, John) and (105, Mary) is collision
// Solution: Separate chaining (Linkedlist)
// index: 5 -> (5, John) -> (105, Mary)
// New structure HashNode(K key, V value, HashNode next)

// HashTable (HashNode[] buckets)

import java.util.NoSuchElementException;

public class HashTable {
    private HashNode[] buckets;
    private int numOfBuckets;  // capacity
    private int size;  // number of key value pairs in hash table or number of hash nodes

    public HashTable() {
        this(10);
    }

    public HashTable(int capacity) {
        this.numOfBuckets = capacity;
        this.size = 0;
        this.buckets = new HashNode[this.numOfBuckets];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void put(Integer key, String value) {
        if (size == numOfBuckets) {
            throw new StackOverflowError("Exceed the capacity of buckets");
        }
        this.buckets[size] = new HashNode(key, value);
        size++;
    }

    public String get(Integer key) {
        for (int i = 0; i < size; i++) {
            if (this.buckets[i].key.equals(key)) {
                return this.buckets[i].value;
            }
        }
        throw new NoSuchElementException("Buckets has no key: " + key);
    }

    public String remove(Integer key) {
        for (int i = 0; i < size; i++) {
            if (this.buckets[i].key.equals(key)) {
                this.buckets[i].next = null;
                size--;
                return this.buckets[i].value;
            }
        }
        throw new NoSuchElementException("Buckets has no key: " + key);
    }

    private static class HashNode {
        private Integer key;  // Can be generic type
        private String value;  // Can be generic type
        private HashNode next;  // Reference to next HashNode

        public HashNode(Integer key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

    }
    public static void main(String[] args) {
        HashTable table = new HashTable(10);
    }
}
