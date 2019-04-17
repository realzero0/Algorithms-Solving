package leetcode.strings.n6_ZigZag_Conversion;

class Solution {
    public String convert(String s, int numRows) {
        String[] strings = new String[numRows];
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            int k = 0;
            if (numRows - 1 > 0) {
                k = i % ((numRows - 1) * 2);
            }
            if (k >= numRows) {
                k = ((numRows - 1) * 2) - k;
            }
            if (strings[k] == null) {
                strings[k] = "";
            }
            strings[k] += s.charAt(i);
        }
        for (int i = 0; i < numRows; i++) {
            if (strings[i] == null) {
                continue;
            }
            result += strings[i];
        }
        return result;
    }
}