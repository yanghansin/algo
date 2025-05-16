package binarytree;

import util.TreeUtils;

import java.util.LinkedList;
import java.util.Queue;

public class LC671 {
    public int findSecondMinimumValue(TreeUtils.TreeNode root) {
        if (root == null || root.left == null || root.right == null) return -1;

        int leftVal = root.left.val;
        int rightVal = root.right.val;

        if (leftVal == root.val) {
            leftVal = findSecondMinimumValue(root.left);
        }

        if (rightVal == root.val) {
            rightVal = findSecondMinimumValue(root.right);
        }

        if (leftVal != -1 && rightVal != -1) {
            return Math.min(leftVal, rightVal);
        } else {
            return Math.max(leftVal, rightVal);
        }
    }
}
