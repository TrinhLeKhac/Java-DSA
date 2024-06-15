// Binary Search Tree is a type of Binary Tree in which data is organized in an ordered manner
// which helps in faster search and insertion of data. It satisfies following properties
// The left subtree of a node contains only nodes with values lesser than the nodes' value
// The right subtree of a node contains only nodes with values greater than the nodes' value
// The left and right subtree each must also be a binary search tree

package tree;

public class BinarySearchTree {

    private TreeNode root;

    public static class TreeNode {
        private int data;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(int data) {
            this.left = null;
            this.right = null;
            this.data = data;
        }
    }

    public BinarySearchTree() {
        root = null;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    private static TreeNode insert(TreeNode root, int value) {
        if (root == null) {  // base case
            root = new TreeNode(value);
            return root;
        }
        if (value < root.data) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }
        return root;
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public boolean search(int key) {
        TreeNode result = search(root, key);
        return result!=null;
    }

    private TreeNode search(TreeNode node, int key) {
        if (node == null || node.data == key) {
            return node;
        }
        if (node.data < key) {
            return search(node.right, key);
        } else {
            return search(node.left, key);
        }
    }

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();

        System.out.println("-----------------insert Element into BST----------------------");
//        bst.root = insert(bst.root, 4);  // root insert
//        bst.root = insert(bst.root, 2);
//        bst.root = insert(bst.root, 1);
//        bst.root = insert(bst.root, 7);
//        bst.root = insert(bst.root, 9);
//        bst.root = insert(bst.root, 3);

        bst.insert(4);  // customize insert
        bst.insert(2);
        bst.insert(1);
        bst.insert(7);
        bst.insert(9);
        bst.insert(3);

        System.out.println("-----------------traverse by preOrder----------------------");
//        bst.preOrder(bst.getRoot());
        bst.preOrder();
        System.out.println('\n');

        System.out.println("-----------------search----------------------");
        int value = 7;
        if (bst.search(value)) {
            System.out.println("The elemment exists in BST");
        } else {
            System.out.println("The element doesn't exists in BST");
        }
    }
}
