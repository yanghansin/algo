package stack;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LC1249Test {
    static class TestCase {
        String s;
        String expected;
        public TestCase(String s, String expected) {
            this.s = s;
            this.expected = expected;
        }
    }

    static Stream<TestCase> provideTestCases() {
        return Stream.of(
                new TestCase("lee(t(c)o)de)", "lee(t(c)o)de"),
                new TestCase("a)b(c)d", "ab(c)d"),
                new TestCase("))((", "")
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testStackSolution(TestCase tc) {
        LC1249 lc1249 = new LC1249();
        System.out.println("Stack solution input: " + tc.s);
        System.out.println("Stack solution output: " + lc1249.makeValidParentheses(tc.s));
        System.out.println("Expected: " + tc.expected);
        assertEquals(tc.expected, lc1249.validParenthesesPrioritized(tc.s));
    }
}