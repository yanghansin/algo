package util;

import org.junit.jupiter.api.Test;
import static util.TreeUtils.*;
class TreeUtilsTest {

    @Test
    void testTreeAlgo() {
        TreeNode root = buildTree(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        printAscii(root);
    }
}