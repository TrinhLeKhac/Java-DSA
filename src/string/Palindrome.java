package string;

public class Palindrome {

    private static boolean isPalindrome(String word) {
        char[] charArr = word.toCharArray();
        int start = 0;
        int end = word.length() - 1;
        while(start < end) {
            if (charArr[start] != charArr[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abcdcba";
        boolean isPalindrome = isPalindrome(s);
        if (isPalindrome) {
            System.out.println("The string is palindrome");
        } else {
            System.out.println("The string is not palindrome");
        }
    }
}
