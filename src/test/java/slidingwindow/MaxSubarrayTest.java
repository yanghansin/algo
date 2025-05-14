package slidingwindow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MaxSubarrayTest {

    static class TestCase{
        int[] nums;
        int k;
        int expected;

        TestCase(int[] nums, int k, int expected) {
            this.nums = nums;
            this.k = k;
            this.expected = expected;
        }
    }

    static Stream<TestCase> provideTestCases() {
        return Stream.of(
                new TestCase(new int[] {1, 4, 2, 10, 23, 3, 1, 0, 20}, 4, 39),
                new TestCase(new int[] {}, 2, 0),
                new TestCase(new int[] {5, -10, 6, 90, 3}, 2, 96),
                new TestCase(new int[] {2, 1, 5, 1, 3, 2}, 3, 9),
                new TestCase(new int[] {-1, -2, -3, -4}, 2, -3)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testMaxSubarray(TestCase tc) {
        MaxSubarray maxSubarray = new MaxSubarray();
        assertEquals(tc.expected, maxSubarray.maxSubArray(tc.nums, tc.k));
    }
}