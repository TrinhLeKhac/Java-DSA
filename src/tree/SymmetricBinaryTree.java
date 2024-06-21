package tree;

// Given a root of a binary tree, check whether it is a mirror of itself (symmetric tree)

import java.util.Stack;

public class SymmetricBinaryTree {
    private final TreeNode root;

    public SymmetricBinaryTree() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    private static class TreeNode {
        private int data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static boolean symmetricBinaryTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.isEmpty()) {
            TreeNode n1 = stack.pop();
            TreeNode n2 = stack.pop();
            if (n1 == null && n2 == null) {
                continue;
            }
            if (n1 == null || n2 == null || n1.data != n2.data) {
                return false;
            }
            stack.push(n1.left);
            stack.push(n2.right);
            stack.push(n1.right);
            stack.push(n2.left);
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
