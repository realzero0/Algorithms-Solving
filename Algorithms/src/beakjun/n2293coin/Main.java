package beakjun.n2293coin;

import java.io.*;
import java.util.*;

public class Main {
	public static int[] dt = new int[10001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] coins = new int[n];
		for (int i = 0; i < n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		dt[0] = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= k; j++) {
				if (j - coins[i] >= 0) {
					dt[j] += dt[j - coins[i]];
				}
			}
		}
		System.out.println(dt[k]);
	}

}
