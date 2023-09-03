package LeetCodeStuff;

import java.util.Stack;

public class Valid_Parentheses {
    public boolean isValid(String s) {
        Stack<Character> brackets = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[') brackets.push(s.charAt(i));
            else if (!brackets.isEmpty() && (s.charAt(i) == ')' && brackets.peek() == '('
                    || s.charAt(i) == ']' && brackets.peek() == '['
                    || s.charAt(i) == '}' && brackets.peek() == '{')) brackets.pop();
            else return false;
        }
        return brackets.isEmpty();
    }

    public static void main(String[] args) {
        String s = "]";
        Valid_Parentheses v = new Valid_Parentheses();
        System.out.println(v.isValid(s));
    }
}
