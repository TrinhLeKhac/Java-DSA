package array;

// Given a string, find the length of longest sub-string without repeating characters
// Example -
// Input "abcabcbb"
// Output - 3

import java.util.HashMap;
import java.util.Map;

public class LongestSubString {
    public static int longestSubString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int maxLength = 0;
        for (int end = 0; end < s.length(); end++) {
            if (map.containsKey(s.charAt(end))) {
                start = Math.max(start, map.get(s.charAt(end)) + 1);
            }
            map.put(s.charAt(end), end);
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
    public static void main(String[] args) {
        String s = "abba";
        int maxLength = longestSubString(s);
        System.out.println("The length of longest sub-string without repeating characters is: " + maxLength);
    }
}
