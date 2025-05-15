package stack;
//LeetCode 1249 — Minimum Remove to Make Valid Parentheses
//Description:
//Given a string s of '(', ')', and lowercase English letters, remove the minimum number of parentheses to make the resulting string valid.
//
//Return any valid result.
//
//A string is valid if:
//
//It is empty, or
//
//It can be written as AB (where A and B are valid), or
//
//It can be written as (A), where A is valid.

//Input: s = "lee(t(c)o)de)"
//Output: "lee(t(c)o)de"

//Input: s = "a)b(c)d"
//Output: "ab(c)d"

//Input: s = "))(("
//Output: ""

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class LC1249 {
    /**
     * Assume String has length n
     * Iterate String Characters: O(n)
     * Construct Result String: O(n)
     * Overall Time Complexity: O(n)
     * Overall Space Complexity: O(n)
     */
    public String makeValidParentheses(String s) {
        if (s == null || s.isEmpty()) return "";
        Stack<Integer> stack = new Stack<>();
        Set<Integer> remvoeSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    remvoeSet.add(i);
                }
            }
        }
        while (!stack.isEmpty()) {
            remvoeSet.add(stack.pop());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!remvoeSet.contains(i)){
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }

    /**
     * Use Counter to Replace Stack
     * Reduce Space Complexity to O(1)
     */

    public String validParenthesesPrioritized(String s) {
        StringBuilder firstPass = new StringBuilder();
        int open = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
                firstPass.append(c);
            } else if (c == ')') {
                if (open > 0) {
                    open--;
                    firstPass.append(c);
                }
            } else {
                firstPass.append(c);
            }
        }

        StringBuilder result = new StringBuilder();
        open = 0;
        for (int i = firstPass.length() - 1; i >= 0; i--) {
            char c = firstPass.charAt(i);
            if (c == ')') {
                open++;
                result.append(c);
            } else if (c == '(') {
                if (open > 0) {
                    open--;
                    result.append(c);
                }
            } else {
                result.append(c);
            }
        }

        return result.reverse().toString();
    }
}
