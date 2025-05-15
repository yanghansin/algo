package stack;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LC20Test {
    static class TestCase {
        String s;
        boolean expected;
        public TestCase(String s, boolean expected) {
            this.s = s;
            this.expected = expected;
        }
    }

    static Stream<TestCase> provideTestCases() {
        return Stream.of(
                new TestCase("()", true),
                new TestCase("[](){}", true),
                new TestCase("(]", false),
                new TestCase("[", false)
        );
    }
    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void test(TestCase tc) {
        LC20 lc20 = new LC20();
        assertEquals(lc20.validParentheses(tc.s), tc.expected);
    }
}