package binarytree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import util.TreeUtils;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LC404Test {

    static class TestCase {
        TreeUtils.TreeNode root;
        int expected;
        TestCase(TreeUtils.TreeNode root, int expected) {
            this.root = root;
            this.expected = expected;
        }
    }

    static Stream<TestCase> provideTestCases() {
        return Stream.of(
                new TestCase(TreeUtils.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7}), 24),

                new TestCase(TreeUtils.buildTree(new Integer[]{1, null, 2, null, 3}), 0),

                new TestCase(TreeUtils.buildTree(new Integer[]{1}), 0),

                new TestCase(TreeUtils.buildTree(new Integer[]{1, 4}), 4),

                new TestCase(TreeUtils.buildTree(new Integer[]{1, 2, 3, 4, null, 5, 6}), 9)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void sumOfLeftLeaves(TestCase testCase) {
        LC404 solver = new LC404();
        assertEquals(testCase.expected, solver.sumOfLeftLeaves(testCase.root));
    }
}
