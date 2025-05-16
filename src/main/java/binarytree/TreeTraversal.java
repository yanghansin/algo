package binarytree;

import util.TreeUtils;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeTraversal {
    public List<Integer> preorderTraversal(TreeUtils.TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderDFS(root, result);

        return result;
    }

    private void preorderDFS(TreeUtils.TreeNode root, List<Integer> result) {
        if (root == null) return;
        result.add(root.val);
        preorderDFS(root.left, result);
        preorderDFS(root.right, result);
    }

    public List<Integer> inorderTraversal(TreeUtils.TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderDFS(root, result);
        return result;
    }

    private void inorderDFS(TreeUtils.TreeNode root, List<Integer> result) {
        if (root == null) return;
        inorderDFS(root.left, result);
        result.add(root.val);
        inorderDFS(root.right, result);
    }


    public List<Integer> postorderTraversal(TreeUtils.TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderDFS(root, result);
        return result;
    }

    private void postorderDFS(TreeUtils.TreeNode root, List<Integer> result) {
        if (root == null) return;
        postorderDFS(root.left, result);
        postorderDFS(root.right, result);
        result.add(root.val);
    }

    public List<List<Integer>> levelOrderTraversal(TreeUtils.TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeUtils.TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeUtils.TreeNode node = queue.poll();
                assert node != null;
                level.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add(level);
        }

        return result;
    }
}
