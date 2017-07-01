package beakjun.n11399ATM;

import java.io.*;
import java.util.*;

public class Main2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] P = new int[N];
		int sum = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			P[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(P);
		for (int i = N; i >= 1; i--) {
			sum += P[N - i] * i;
		}
		System.out.println(sum);
	}

}
