// Given a string s, containing just the characters '(', ')', '[', ']', '{', '}'
// Determine if the input string is valid
// An input string is valid if:
// Open brackets must be closed by same type of brackets
// Open brackets must be closed in correct order

package string;
import java.util.Stack;

public class Parentheses {

    public static boolean checkParentheses(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;  // Stack is empty but we encountered a closing bracket
                }
                char top = stack.pop();
                if (!isMatchingPair(top, c)) {
                    return false;  // Mismatched pair
                }
            }
        }
        return stack.isEmpty();  // Stack should be empty if all parentheses are matched
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }

    public static void main(String[] args) {
        String input = "{()}";
        if (checkParentheses(input)) {
            System.out.println("The input is valid parentheses");
        } else {
            System.out.println("The input is not valid parentheses");
        }
    }
}

