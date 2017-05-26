package beakjun.n11066fileMerge;

import java.io.*;
import java.util.*;

public class Main2 {
	static int[][] dt = new int[1001][1001];
	static int[] file = new int[1001];
	static int[] summation = new int[1001];
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
				summation[j] = summation[j - 1] + file[j];
			}
			for (int gap = 1; gap < K; gap++) {
				for (int start = 1; start + gap <= K; start++) {
					int end = start + gap;
					dt[start][end] = MAX;
					for (int k = start; k < end; k++) {
						dt[start][end] = Math.min(dt[start][end], dt[start][k] + dt[k + 1][end]);
					}

					dt[start][end] += (summation[end] - summation[start - 1]);
				}
			}

			System.out.println(dt[1][K]);
		}
	}
}
