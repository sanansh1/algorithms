package org.slidingwindow;

import java.util.HashMap;
import java.util.Map;

// Start with brute force and optimize
public class LongestSubstringWithAtMostK {
    public static int findLongestSubstringBruteForce(char[] s, int K) {
        int maxLen = 0;
        Map<Character, Integer> characterCount = new HashMap<>();
        for (int i = 0; i < s.length; i++) {
            characterCount.clear();
            for (int j = i; j < s.length; j++) {
                characterCount.put(s[j], characterCount.getOrDefault(s[j], 0) + 1);
                if (characterCount.size() <= K) {
                    maxLen = Math.max(maxLen, j - i + 1);
                } else {
                    break;
                }
            }
        }
        return maxLen;
    }

    public static int findLongestSubstringSlidingWindow(char[] s, int K) {
        int maxLen = 0, left = 0, right = 0;
        Map<Character, Integer> characterCount = new HashMap<>();
        while (right < s.length) {
            characterCount.put(s[right], characterCount.getOrDefault(s[right], 0) + 1);
            while (characterCount.size() > K) {
                characterCount.put(s[left], characterCount.getOrDefault(s[left], 0) - 1);
                if (characterCount.get(s[left]) == 0) {
                    characterCount.remove(s[left]);
                }
                left++;
            }
            if (characterCount.size() <= K) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
            right++;
        }
        return maxLen;
    }

    public static int findLongestSubstringSlidingWindowOptimized(char[] s, int K) {
        int maxLen = 0, left = 0, right = 0;
        Map<Character, Integer> characterCount = new HashMap<>();
        while (right < s.length) {
            characterCount.put(s[right], characterCount.getOrDefault(s[right], 0) + 1);
            if (characterCount.size() > K) {
                characterCount.put(s[left], characterCount.getOrDefault(s[left], 0) - 1);
                if (characterCount.get(s[left]) == 0) {
                    characterCount.remove(s[left]);
                }
                left++;
            }
            if (characterCount.size() <= K) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
            right++;
        }
        return maxLen;
    }

    public static void main(String[] s) {
        System.out.println(findLongestSubstringBruteForce(new char[]{'a', 'a', 'a', 'b', 'b', 'c', 'c', 'd'}, 2));
        System.out.println(findLongestSubstringSlidingWindow(new char[]{'a', 'a', 'a', 'b', 'b', 'c', 'c', 'd'}, 2));
        System.out.println(findLongestSubstringSlidingWindowOptimized(new char[]{'a', 'a', 'a', 'b', 'b', 'c', 'c', 'd'}, 2));
    }
}
