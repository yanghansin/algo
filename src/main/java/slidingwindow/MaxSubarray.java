package slidingwindow;

/**
 * Given an integer array nums and an integer k, return the maximum sum of any contiguous subarray of size k.
 * Example 1
 * Input: nums = [1, 4, 2, 10, 23, 3, 1, 0, 20], k = 4
 * Output: 39
 * Explanation: The subarray with the maximum sum is [4, 2, 10, 23].
 * Example 2
 * Input: nums = [5, -10, 6, 90, 3], k = 2
 * Output: 96
 * Explanation: The subarray with the maximum sum is [6, 90].
 */
public class MaxSubarray {
    public int maxSubArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int sum = 0;
        int max = 0;
        for (int i = 0; i < k; i++) sum += nums[i];
        max = sum;

        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            max = Math.max(max, sum);
        }

        return max;
    }
}
