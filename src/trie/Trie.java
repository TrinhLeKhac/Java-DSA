package trie;

// Trie basically comes from the word Retrieval
// The main purpose of this data structure is to retrieve stored information very fast

// Application - Auto-Complete words
// Autocomplete feature is implemented by Tries
// Many websites have used autocomplete feature, which suggest user rest of the word, while user is typing

// Spell Checking
// Tries help to check and correct word spelling entered by user

// TrieNode
// A TrieNode in a Trie represents a single alphabet of the word

// TrieNode[] children
// boolean isWord

public class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode(); // root is empty
    }

    private static class TrieNode {
        private TrieNode[] children;
        private boolean isWord;
        public TrieNode() {
            children = new TrieNode[26]; // storing 26 character in english alphabet
            isWord = false;
        }
    }

    public void insert(String word) {
        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException("Invalid input");
        }
        word = word.toLowerCase();

        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (current.children[index] == null) {
                TrieNode node = new TrieNode();
                current.children[index] = node;
                current = node;
            } else {
                current = current.children[index];
            }
        }
        current.isWord = true;
    }

    public boolean search(String word){
        return false;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("cat");
        trie.insert("cab");
        trie.insert("son");
        trie.insert("so");
        System.out.println("Values inserted successfully !!!");

    }
}
