package array;

// Given a string s, return the index of first non-repeating character in it.
// If it does not exist, return -1
// The string only contains lower characters

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {
    public static int firstNonRepeatingCharacter(String seq) {
        char[] chars = seq.toCharArray();
        Map<Character, Integer> characterFrequencyMap = new HashMap<>();
        for (char c: chars) {
            characterFrequencyMap.put(c, characterFrequencyMap.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < chars.length; i++) {
            if (characterFrequencyMap.get(chars[i]) == 1) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        String target = "the index of first non-repeating character is";
        int first = firstNonRepeatingCharacter(target);
        if (first != -1) {
            System.out.println("The index of first non-repeating character is: " + first);
        } else {
            System.out.println("String with all characters repeated");
        }
    }
}
