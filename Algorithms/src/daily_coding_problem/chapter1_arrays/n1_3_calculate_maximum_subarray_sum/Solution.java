package daily_coding_problem.chapter1_arrays.n1_3_calculate_maximum_subarray_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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

        System.out.println(Arrays.toString(solution(input)));
    }

    private static int[] solution(int[] input) {
        int sum = 0;
        int[] prefixSum = new int[input.length];
        int[] suffixSum = new int[input.length];
        for (int value : input) {
            sum += value;
        }

        prefixSum[0] = 0;
        for (int i = 1; i < input.length; i++) {
            prefixSum[i] = prefixSum[i-1] + input[i-1];
        }

        suffixSum[input.length - 1] = 0;
        for (int i = input.length - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + input[i + 1];
        }


        int prefixIndex = 0;
        int suffixIndex = input.length - 1;
        int minSum = sum;
        int prefixMin = 0;
        int suffixMin = 0;
        for(int i = 0; i < input.length; i++) {
            if(minSum < sum - prefixSum[i]) {
                prefixIndex = i;
                minSum = sum - prefixSum[i];
                prefixMin = prefixSum[i];
            }
        }

        minSum = sum;
        for(int i = input.length - 1; i >= 0; i--) {
            if(minSum < sum - suffixSum[i]) {
                suffixIndex = i + 1;
                minSum = sum - suffixSum[i];
                suffixMin = suffixSum[i];
            }
        }
        if (prefixIndex == input.length - 1 || suffixIndex == 0) {
            return null;
        }

        System.out.println("sum: " + (sum - prefixMin - suffixMin));
        return Arrays.copyOfRange(input, prefixIndex, suffixIndex + 1);
    }
}
