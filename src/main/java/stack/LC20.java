package stack;

import java.util.Stack;

//Given a string s containing just the characters '(', ')', '{', '}', '[', and ']', determine if the input string is valid.
//
//A string is valid if:
//
//Open brackets are closed by the same type of brackets.
//
//Open brackets are closed in the correct order.
//
//Every closing bracket has a corresponding open bracket of the same type.
//Input: s = "()"
//Output: true
//Input: s = "()[]{}"
//Output: true
//Input: s = "(]"
//Output: false
public class LC20 {
    public boolean validParentheses(String s) {
        if (s == null || s.isEmpty()) return false;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
