package binarytree;

import util.TreeUtils;

public class LC404 {
    private int sum;
    public int sumOfLeftLeaves(TreeUtils.TreeNode root) {
        sum = 0;
        dfs(root);
        return sum;
    }

    private void dfs(TreeUtils.TreeNode root) {
        if (root == null) return;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }
        dfs(root.left);
        dfs(root.right);
    }
}
