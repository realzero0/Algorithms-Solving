package beakjun.n11047Coin0;

import java.io.*;
import java.util.*;

public class Main {

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
			while(K - coins[i] >= 0) {
				K -= coins[i];
				count++;
			}
			if(K == 0) {
				break;
			}
			i--;
		}
		System.out.println(count);
	}
}
