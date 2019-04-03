package daily_coding_problem.chapter1_arrays.n1_2_locate_smallest_window_to_be_sorted;

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
        int start = -1;
        int end = -1;
        int[] orderedInput = Arrays.copyOf(input, input.length);
        Arrays.sort(orderedInput);

        for (int i = 0; i < input.length; i++) {
            if (orderedInput[i] != input[i] && start == -1) {
                start = i;
            }
            if (orderedInput[i] != input[i] && end < i) {
                end = i;
            }
        }
        return new int[]{start, end};
    }
}