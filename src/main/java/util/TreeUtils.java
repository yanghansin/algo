package util;

import java.util.LinkedList;
import java.util.Queue;

public class TreeUtils {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int val) {this.val = val;}
    }

    public static TreeNode buildTree(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

        while (i < arr.length) {
            TreeNode node = queue.poll();
            if (node != null) {
                if (arr[i] != null) {
                    node.left = new TreeNode(arr[i]);
                    queue.offer(node.left);
                }

                i++;
                if (i < arr.length && arr[i] != null) {
                    node.right = new TreeNode(arr[i]);
                    queue.offer(node.right);
                }
                i++;
            }
        }

        return root;
    }

    public static void printAscii(TreeNode root) {
        printAscii(root, "", true);
    }

    private static void printAscii(TreeNode node, String prefix, boolean isTail) {
        if (node == null) return;

        if (node.right != null) {
            printAscii(node.right, prefix + (isTail ? "│   " : "    "), false);
        }

        System.out.println(prefix + (isTail ? "└── " : "┌── ") + node.val);

        if (node.left != null) {
            printAscii(node.left, prefix + (isTail ? "    " : "│   "), true);
        }
    }

}
