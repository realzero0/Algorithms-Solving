package leetcode.strings.n438_Find_All_Anagrams_in_a_String;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new LinkedList<>();
        Map<Character, Integer> expectedMap = new HashMap<>();
        if(s.length() < p.length()) {
            return result;
        }
        for(int i = 0; i < p.length(); i++) {
            if(expectedMap.get(p.charAt(i)) == null) {
                expectedMap.put(p.charAt(i), 1);
            } else {
                expectedMap.put(p.charAt(i), expectedMap.get(p.charAt(i)) + 1);
            }
        }

        for(int i = 0; i < p.length(); i++) {
            if(expectedMap.get(s.charAt(i)) != null) {
                expectedMap.put(s.charAt(i), expectedMap.get(s.charAt(i)) - 1);
            }
        }
        boolean isOK = true;
        for (int value : expectedMap.values()) {
            if (value != 0) {
                isOK = false;
                break;
            }
        }
        if(isOK) {
            result.add(0);
        }
        int j = 0;
        for(int i = p.length(); i < s.length(); i++) {
            if(expectedMap.get(s.charAt(j)) != null) {
                expectedMap.put(s.charAt(j), expectedMap.get(s.charAt(j)) + 1);
            }
            if(expectedMap.get(s.charAt(i)) != null) {
                expectedMap.put(s.charAt(i), expectedMap.get(s.charAt(i)) - 1);
            }
            isOK = true;
            for (int value : expectedMap.values()) {
                if (value != 0) {
                    isOK = false;
                    break;
                }
            }
            j++;
            if(isOK) {
                result.add(j);
            }
        }
        return result;
    }
}