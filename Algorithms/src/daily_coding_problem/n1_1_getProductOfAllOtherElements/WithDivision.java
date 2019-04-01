package daily_coding_problem.n1_1_getProductOfAllOtherElements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class WithDivision {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int elementCount = st.countTokens();
        long[] input = new long[elementCount];
        for (int i = 0; i < elementCount; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(Arrays.toString(solution(input)));
    }

    private static long[] solution(long[] input) {
        long allElementsProduct = 1;
        for (long element : input) {
            allElementsProduct *= element;
        }
        long[] output = new long[input.length];
        for (int i = 0; i < input.length; i++) {
            output[i] = allElementsProduct / input[i];
        }
        return output;
    }
}
