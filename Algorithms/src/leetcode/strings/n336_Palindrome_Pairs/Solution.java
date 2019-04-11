package leetcode.strings.n336_Palindrome_Pairs;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i == j) {
                    continue;
                }
                int minWordLength = Math.min(words[j].length(), words[i].length());
                boolean isOK = true;
                for (int k = 0; k < minWordLength; k++) {
                    if (words[i].charAt(k) != words[j].charAt(words[j].length() - k - 1)) {
                        isOK = false;
                        break;
                    }
                }
                if (!isOK) {
                    continue;
                } else if (words[i].length() == words[j].length()) {
                    ArrayList<Integer> element = new ArrayList<>();
                    element.add(i);
                    element.add(j);
                    result.add(element);
                    continue;
                }
                String combinedWord = words[i] + words[j];

                int n = combinedWord.length() - minWordLength - 1;
                isOK = true;
                for (int k = minWordLength; k < combinedWord.length() / 2; k++) {
                    if (combinedWord.charAt(n) != combinedWord.charAt(k)) {
                        isOK = false;
                        break;
                    }
                    n--;
                }
                if (isOK) {
                    ArrayList<Integer> element = new ArrayList<>();
                    element.add(i);
                    element.add(j);
                    result.add(element);
                }
            }
        }
        return result;
    }
}