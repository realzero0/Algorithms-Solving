package beakjun.n11399ATM;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] P = new int[N];
		int sum = 0;
		int totalSum = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			P[i] = Integer.parseInt(st.nextToken());
			sum += P[i];
		}
		Arrays.sort(P);
		totalSum += sum;
		for (int i = N - 1; i >= 0; i--) {
			sum -= P[i];
			totalSum += sum;
		}
		System.out.println(totalSum);
	}
}
