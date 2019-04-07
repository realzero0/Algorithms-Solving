package leetcode.arrays.n53_Maximum_Subarray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int elementCount = st.countTokens();
        int[] input = new int[elementCount];
        for (int i = 0; i < elementCount; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(maxSubArray(input));
    }

    private static int maxSubArray(int[] nums) {
        int maxEndingHere = 0;
        int maxSoFar = Integer.MIN_VALUE;
        for (int num : nums) {
            maxEndingHere = Math.max(num, maxEndingHere + num);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
}
