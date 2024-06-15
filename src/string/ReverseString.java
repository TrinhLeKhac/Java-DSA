// Reverse string using Stack<Character>

package string;
import java.util.Stack;

public class ReverseString {
    public static String reverseString(String str) {
        Stack<Character> stack = new Stack<>();
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            stack.push(aChar);
        }
        for(int i = 0; i < chars.length; i++) {
            chars[i] = stack.pop();
        }
        return new String(chars);
    }
    public static void main(String[] args) {
        String input = "LEKHACTRINH52341@";
        System.out.println("Before reverse: " + input);
        String output = reverseString(input);
        System.out.println("After reverse: " + output);
    }
}
