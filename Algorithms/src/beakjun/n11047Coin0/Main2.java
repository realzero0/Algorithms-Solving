package beakjun.n11047Coin0;

import java.io.*;
import java.util.*;

public class Main2 {
	// 효율성 향상
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] coins = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			coins[i] = Integer.parseInt(st.nextToken());
		}
		int count = 0;
		int i = N - 1;
		while (i >= 0) {
			if(K - coins[i] >= 0) {
				count += K / coins[i];
				K %= coins[i];
			}
			if(K == 0) {
				break;
			}
			i--;
		}
		System.out.println(count);
	}
}
