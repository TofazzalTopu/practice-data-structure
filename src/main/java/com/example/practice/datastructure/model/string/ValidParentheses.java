package com.example.practice.datastructure.model.string;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValidParentheses("()[]{}"));
        System.out.println(isValidParentheses("()"));
    }

    public static boolean isValidParentheses(String s) {
        int length = s.length();
        char[] array = s.toCharArray();
        if (length == 0) return true;
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < length; i++) {
            if (array[i] == '(' || array[i] == '{' || array[i] == '[') {
                stack.push(array[i]);
            }
            if (array[i] == ')' || array[i] == '}' || array[i] == ']') {
                if (stack.isEmpty()) return false;
                char temp = stack.pop();
                if ((temp == '(' && array[i] == ')') || (temp == '{' && array[i] == '}') || (temp == '[' && array[i] == ']')) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) return false;
        return true;
    }
}
