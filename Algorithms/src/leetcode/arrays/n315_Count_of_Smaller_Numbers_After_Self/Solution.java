package leetcode.arrays.n315_Count_of_Smaller_Numbers_After_Self;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int elementCount = st.countTokens();
        int[] input = new int[elementCount];
        for (int i = 0; i < elementCount; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(countSmaller(input));
    }

    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new LinkedList<>();
        List<Integer> comparisonList = new LinkedList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int value = 0;
            if(!comparisonList.isEmpty()) {
                value = Collections.binarySearch(comparisonList, nums[i]);
                if(value < 0) {
                    value = -value - 1;
                }
            }
            comparisonList.add(value, nums[i]);
            result.add(0, value);
        }
        return result;
    }
}