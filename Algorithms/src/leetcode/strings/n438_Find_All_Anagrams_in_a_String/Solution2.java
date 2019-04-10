package leetcode.strings.n438_Find_All_Anagrams_in_a_String;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] expectedValues = new int[26];
        if (s.length() < p.length()) {
            return result;
        }
        for (int i = 0; i < p.length(); i++) {
            expectedValues[p.charAt(i) - 'a']++;
        }
        int sum = p.length();
        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            if (expectedValues[s.charAt(end) - 'a'] > 0) {
                sum--;
            }
            expectedValues[s.charAt(end) - 'a']--;
            start = end - p.length() + 1;
            if (start < 0) {
                continue;
            }
            if (sum == 0) {
                result.add(start);
            }

            if (expectedValues[s.charAt(start) - 'a'] >= 0) {
                sum++;
            }
            expectedValues[s.charAt(start) - 'a']++;
        }
        return result;
    }
}
