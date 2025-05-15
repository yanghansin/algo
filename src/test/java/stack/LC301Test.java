package stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LC301Test {
    static class TestCase {
        String s;
        List<String> expected;
        public TestCase(String s, List<String> expected) {
            this.s = s;
            this.expected = expected;
        }
    }

    static Stream<TestCase> stream() {
        return Stream.of(
                new TestCase("", List.of("")),

                new TestCase("abc", List.of("abc")),

                new TestCase("()", List.of("()")),

                new TestCase("())", List.of("()")),

                new TestCase("(((", List.of("")),

                new TestCase("()())()", List.of("(())()", "()()()")),

                new TestCase("(a)())()", List.of("(a())()", "(a)()()")),

                new TestCase(")(", List.of("")),

                new TestCase("((()))())(()", List.of("((()))()()", "((())())()")),

                new TestCase("n", List.of("n"))
        );
    }
    @ParameterizedTest
    @MethodSource("stream")
    void testRemoveInvalidParentheses(TestCase tc) {
        LC301 lc301 = new LC301();
        List<String> actual = lc301.removeInvalidParentheses(tc.s);

        assertEquals(new HashSet<>(tc.expected), new HashSet<>(actual));
    }

}