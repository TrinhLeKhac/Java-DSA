package array;

// Remove vowels of string and keep order of remaining characters

import java.util.Set;

public class RemoveVowels {

    public static String removeVowels(String s) {
        Set<Character> vowels = Set.of('a', 'e', 'u', 'o', 'i');
        StringBuilder result = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char c: chars) {
            if (!vowels.contains(c)) {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "lekhactrinh52341@12345trinhlekhac";
        String result = removeVowels(s);
        System.out.println("The remaining string after removing vowels character is: " + result);
    }
}
