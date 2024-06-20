package array;

// A sub-sequence of a string is a new string formed from the original string
//  by deleting some or no characters without changing the order of remaining characters.

// Example -
// "ace" is a sub-sequence of "abcde"
// "ace" is not a sub-sequence of "abcde"
public class SubSequence {
    public static boolean isSubSequence(String target, String seq) {
        int i = 0;  // traverse target
        int j = 0;  // traverse seq
        while (i < target.length() && j < seq.length()) {
            if (target.charAt(i) == seq.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == seq.length();
    }
    public static void main(String[] args) {
        String target = "abcde";
        String seq = "aec";
        if (isSubSequence(target, seq)) {
            System.out.println("The seq " + seq + " is a sub-sequence of original string " + target);
        } else {
            System.out.println("The seq " + seq + " is NOT a sub-sequence of original string " + target);
        }
    }
}
