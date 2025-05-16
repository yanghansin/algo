package binarytree;

import com.sun.source.tree.Tree;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import util.TreeUtils;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LC872Test {
    static class TestCase {
        TreeUtils.TreeNode root1;
        TreeUtils.TreeNode root2;
        Boolean expected;
        public TestCase(TreeUtils.TreeNode root1, TreeUtils.TreeNode root2, Boolean expected) {
            this.root1 = root1;
            this.root2 = root2;
            this.expected = expected;
        }
    }

    static Stream<TestCase> provideTestCases() {
        TestCase testCase1 = new TestCase(TreeUtils.buildTree(new Integer[] {3,5,1,6,2,9,8,null,null,7,4}), TreeUtils.buildTree(new Integer[]{3,5,1,6,7,4,2,null,null,null,null,null,null,9,8}), true);
        return Stream.of(testCase1);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testLeafSimilar(TestCase testCase) {
        LC872 lc872 = new LC872();
        TreeUtils.printAscii(testCase.root1);
        TreeUtils.printAscii(testCase.root2);
        assertEquals(testCase.expected, lc872.leafSimilar(testCase.root1, testCase.root2));
    }

}