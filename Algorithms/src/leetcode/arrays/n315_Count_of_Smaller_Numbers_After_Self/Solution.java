package leetcode.arrays.n315_Count_of_Smaller_Numbers_After_Self;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        List<Integer> result = new ArrayList<>();
        List<Integer> comparisonList = new ArrayList<>();
        int[] calculatedValues = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            int value = binarySearch(comparisonList, nums[i]);
            comparisonList.add(value, nums[i]);
            calculatedValues[i] = value;
        }
        for (int val : calculatedValues) {
            result.add(val);
        }
        return result;
    }

    private static int binarySearch(List<Integer> comparisonList, int target) {
        int right = comparisonList.size() - 1;
        int left = 0;
        if (comparisonList.size() == 1) {
            return target > comparisonList.get(0) ? 1 : 0;
        }

        while (left <= right) {
            int medium = (left + right) / 2;
            if (target > comparisonList.get(medium)) {
                left = medium + 1;
            } else {
                right = medium - 1;
            }
        }
        return left;
    }
}