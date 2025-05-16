package binarytree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.TreeUtils;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class TreeTraversalTest {
    TreeUtils.TreeNode root;
    TreeTraversal traversal;

    @BeforeEach
    void setUp() {
        root = TreeUtils.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        traversal = new TreeTraversal();
    }

    @Test
    void testPrintAsciiTree() {
        TreeUtils.printAscii(root);
    }

    @Test
    void testPreorderTraversal() {
        assertEquals(List.of(3, 9, 20, 15, 7), traversal.preorderTraversal(root));
    }

    @Test
    void inorderTraversal() {
        assertEquals(List.of(9, 3, 15, 20, 7), traversal.inorderTraversal(root));
    }

    @Test
    void postorderTraversal() {
        assertEquals(List.of(9, 15, 7, 20, 3), traversal.postorderTraversal(root));
    }

    @Test
    void levelOrderTraversal() {
        assertEquals(List.of(
                List.of(3),
                List.of(9, 20),
                List.of(15, 7)
        ), traversal.levelOrderTraversal(root));
    }
}
