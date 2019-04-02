package daily_coding_problem.n1_2_locate_smallest_window_to_be_sorted;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SolutionWithoutSorting {
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
        int maxSeen = input[0];
        int minSeen = input[input.length - 1];


        for(int i = 1; i < input.length; i++) {
            maxSeen = Math.max(input[i], maxSeen);
            if (maxSeen > input[i]) {
                end = i;
            }
        }

        for (int i = input.length - 2; i >= 0; i--) {
            minSeen = Math.min(input[i], minSeen);
            if(minSeen < input[i]) {
                start = i;
            }
        }
        return new int[]{start, end};
    }
}