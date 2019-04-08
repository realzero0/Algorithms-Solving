package leetcode.arrays.n918_Maximum_Sum_Circular_Subarray;

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

        System.out.println(maxSubarraySumCircular(input));
    }

    public static int maxSubarraySumCircular(int[] A) {
        int minEndingHere = 0;
        int minSoFar = Integer.MAX_VALUE;
        int maxEndingHere = 0;
        int maxSoFar = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : A) {
            minEndingHere = Math.min(num, minEndingHere + num);
            minSoFar = Math.min(minSoFar, minEndingHere);
            maxEndingHere = Math.max(num, maxEndingHere + num);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
            sum += num;
        }

        if (sum - minSoFar == 0 || maxSoFar > sum - minSoFar) {
            return maxSoFar;
        }

        return sum - minSoFar;
    }
}
