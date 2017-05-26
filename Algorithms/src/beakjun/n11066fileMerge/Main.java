package beakjun.n11066fileMerge;

import java.io.*;
import java.util.*;

public class Main {
	static int[][] dt = new int[1001][1001];
	static int[] file = new int[1001];
	static int[] summations = new int[1001];
	static final int MAX = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		int K;

		for (int i = 0; i < T; i++) {

			K = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= K; j++) {
				file[j] = Integer.parseInt(st.nextToken());
				summations[j] = summations[j - 1] + file[j];
				for (int k = 1; k <= K; k++) {
					dt[j][k] = MAX;
				}
			}

			System.out.println(dp(1, K));
		}
	}

	public static int dp(int i, int j) {
		// 자기 자신인 경우 합치는 비용은 0
		if (i >= j) {

			return 0;
		}

		// 이웃한 경우
		if (j == i + 1) {

			return file[i] + file[j];
		}
		
		// MAX보다 작으면 이미 저장된 값이라는 
		if (dt[i][j] < MAX) {

			return dt[i][j];
		}

		for (int k = i; k < j; k++) {

			int temp = dp(i, k) + dp(k + 1, j) + summations[j] - summations[i - 1];

			dt[i][j] = min(dt[i][j], temp);
		}

		return dt[i][j];
	}

	public static int min(int a, int b) {
		if (a < b) {
			return a;
		} else {
			return b;
		}
	}
}
