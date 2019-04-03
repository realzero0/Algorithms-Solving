package daily_coding_problem.chapter1_arrays.n1_1_getProductOfAllOtherElements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class WithoutDivision {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int elementCount = st.countTokens();
        long[] input = new long[elementCount];
        for (int i = 0; i < elementCount; i++) {
            input[i] = Long.parseLong(st.nextToken());
        }

        System.out.println(Arrays.toString(solution(input)));
    }

    private static long[] solution(long[] input) {
        int lastElementIndex = input.length - 1;

        long[] prefixProduct = new long[input.length];
        long[] suffixProduct = new long[input.length];

        prefixProduct[0] = 1;
        prefixProduct[1] = input[0];
        for (int i = 2; i < input.length; i++) {
            prefixProduct[i] = prefixProduct[i - 1] * input[i - 1];
        }

        suffixProduct[lastElementIndex] = 1;
        suffixProduct[lastElementIndex - 1] = input[lastElementIndex];
        for (int i = lastElementIndex - 2; i >= 0; i--) {
            suffixProduct[i] = suffixProduct[i + 1] * input[i + 1];
        }

        long[] output = new long[input.length];
        for (int i = 0; i < input.length; i++) {
            if (i == 0) {
                output[i] = suffixProduct[0];
            } else if(i == lastElementIndex) {
                output[i] = prefixProduct[lastElementIndex];
            } else {
                output[i] = prefixProduct[i] * suffixProduct[i];
            }
        }
        return output;
    }
}