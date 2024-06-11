import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ImplementTree {
    private TreeNode root;

    public static class TreeNode {
        private final int data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data) {
            this.left = null;
            this.right = null;
            this.data = data;
        }
    }

    public ImplementTree() {
        this.root = null;
    }

    public TreeNode getRoot() {
        return this.root;
    }

    // Preorder Binary Tree traversal
    // Visit the root node
    // Traverse the left subtree in Preorder fashion
    // Traverse the right subtree in Preorder fashion
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void preOrderUsingStack() {
        preOrderUsingStack(root);
    }
    private void preOrderUsingStack(TreeNode node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()) {
            TreeNode current = stack.pop();
            System.out.print(current.data + " ");
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
    }

    // Inorder Binary Tree traversal
    // Traverse the left subtree in Inorder fashion
    // Visit the root node
    // Traverse the right subtree in Inorder Fashion

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    public void inOrderUsingStack() {
        inOrderUsingStack(root);
    }

    private void inOrderUsingStack(TreeNode node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = node;
        while (temp != null || !stack.isEmpty()) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                System.out.print(temp.data + " ");
                temp = temp.right;
            }
        }
    }


    // PostOrder Binary Tree Traversal
    // Visit the root node
    // Traverse the right subtree in PostOrder fashion
    // Traverse the left subtree in PostOrder fashion

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        postOrder(node.right);
        postOrder(node.left);
    }

    public void postOrderUsingStack() {
        postOrderUsingStack(root);
    }

    private void postOrderUsingStack(TreeNode node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            System.out.print(current.data + " ");
            if (current.left != null) {
                stack.push(current.left);
            }
            if (current.right != null) {
                stack.push(current.right);
            }
        }
    }

    public void levelOrder() {
        levelOrder(root);
    }

    private void levelOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode current;
        queue.offer(node);
        while (!queue.isEmpty()) {
             current = queue.poll();
             System.out.print(current.data + " ");
             if (current.left != null) {
                 queue.offer(current.left);
             }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
    }

    public int findMax() {
        return findMax(root);
    }

    private int findMax(TreeNode node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        int result = node.data;
        int left_max = findMax(node.left);
        int right_max = findMax(node.right);
        if (result < left_max) {
            result = left_max;
        }
        if (result < right_max) {
            result = right_max;
        }
        return result;
    }

    public void createBinaryTree() {
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(5);
        TreeNode sixth = new TreeNode(6);
        TreeNode seventh = new TreeNode(7);

        this.root = first;
        first.left = second;
        first.right = third;
        second.left = fourth;
        second.right = fifth;
        third.left = sixth;
        third.right = seventh;
    }

    public static void main(String[] args) {
        ImplementTree tree = new ImplementTree();
        tree.createBinaryTree();
        System.out.println("-----------------preOrder traversal----------------------");
        System.out.println("Preorder traversal of binary tree:");
        tree.preOrder();
        System.out.println('\n');

        System.out.println("Preorder traversal of binary tree by using stack:");
        tree.preOrderUsingStack();
        System.out.println('\n');

        System.out.println("-----------------inOrder traversal----------------------");
        System.out.println("inOrder traversal of binary tree:");
        tree.inOrder();
        System.out.println('\n');

        System.out.println("inOrder traversal of binary tree by using stack:");
        tree.inOrderUsingStack();
        System.out.println('\n');

        System.out.println("-----------------postOrder traversal----------------------");
        System.out.println("postOrder traversal of binary tree:");
        tree.postOrder(tree.getRoot());
        System.out.println('\n');

        System.out.println("postOrder traversal of binary tree by using stack:");
        tree.postOrderUsingStack();
        System.out.println('\n');

        System.out.println("-----------------levelOrder----------------------");
        tree.levelOrder();
        System.out.println('\n');

        System.out.println("-----------------findMax----------------------");
        System.out.println("The maximum value of tree: " + tree.findMax());
    }
}
