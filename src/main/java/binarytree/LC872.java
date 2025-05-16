package binarytree;

import util.TreeUtils;
import java.util.*;

public class LC872 {
    public boolean leafSimilar(TreeUtils.TreeNode root1, TreeUtils.TreeNode root2) {
        List<Integer> leaves1 = getLeaves(root1);
        List<Integer> leaves2 = getLeaves(root2);
        return leaves1.equals(leaves2);
    }

    private List<Integer> getLeaves(TreeUtils.TreeNode root)  {
        List<Integer> result = new ArrayList<>();
        dfs(result, root);
        return result;
    }

    private void dfs(List<Integer> result, TreeUtils.TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            result.add(root.val);
        }
        dfs(result, root.left);
        dfs(result, root.right);
    }
}
