package stack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Problem Description:
Given a string s that contains parentheses '(', ')', and lowercase letters, remove the minimum number of invalid parentheses to make the input string valid.

Return all possible results.

You may return the answer in any order.
example 1:
Input: s = "()())()"
Output: ["(())()", "()()()"]

example 2:
Input: s = "(a)())()"
Output: ["(a())()", "(a)()()"]

example 3:
Input: s = ")("
Output: [""]

s = "()())()"

 */
public class LC301 {
    private int[] countRemovals(String s) {
        int[] result = new int[2];
        int leftRemove = 0;
        int rightRemove = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftRemove++;
            } else if (s.charAt(i) == ')') {
                if (leftRemove > 0) {
                    leftRemove--;
                } else {
                    rightRemove++;
                }
            }
        }
        result[0] = leftRemove;
        result[1] = rightRemove;
        return result;
    }

    private void dfs (
            String s,
            int index,
            int leftRemove,
            int rightRemove,
            int open,
            StringBuilder path,
            Set<String> result
    ) {
        if (index == s.length()) {
            if (leftRemove == 0 && rightRemove == 0 && open == 0) {
                result.add(path.toString());
            }
            return;
        }

        char c = s.charAt(index);
        int len = path.length();

        if (c == '(') {
            if (leftRemove > 0) {
                dfs(s, index + 1, leftRemove - 1, rightRemove, open, path, result);
            }

            path.append('(');
            dfs(s, index + 1, leftRemove, rightRemove, open + 1, path, result);
            path.setLength(len);
        } else if (c == ')') {
            if (rightRemove > 0) {
                dfs(s, index + 1, leftRemove, rightRemove - 1, open, path, result);
            }

            if (open > 0) {
                path.append(')');
                dfs(s, index + 1, leftRemove, rightRemove, open - 1, path, result);
                path.setLength(len);
            }
        } else {
            path.append(c);
            dfs(s, index + 1, leftRemove, rightRemove, open, path, result);
            path.setLength(len);
        }
    }

    public List<String> removeInvalidParentheses(String s) {
        int[] toRemove = countRemovals(s);
        Set<String> result = new HashSet<>();
        dfs(s, 0, toRemove[0], toRemove[1], 0, new StringBuilder(), result);
        return new ArrayList<>(result);
    }

}
