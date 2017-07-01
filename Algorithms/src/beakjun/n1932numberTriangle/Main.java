package beakjun.n1932numberTriangle;

import java.io.*;
import java.util.*;

public class Main {
	public static int[][] dt = new int[2][500];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int triangleSize = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		dt[0][0] = Integer.parseInt(st.nextToken());
		for (int i = 2; i <= triangleSize; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < i; j++) {
				if (j - 1 < 0) {
					dt[1][j] = dt[0][j] + Integer.parseInt(st.nextToken());
				} else if (j == triangleSize - 1) {
					dt[1][j] = dt[0][j - 1] + Integer.parseInt(st.nextToken());
				} else {
					dt[1][j] = max(dt[0][j], dt[0][j - 1]) + Integer.parseInt(st.nextToken());
				}
			}
			for (int j = 0; j < i; j++) {
				dt[0][j] = dt[1][j];
			}
		}
		Arrays.sort(dt[0]);
		System.out.println(dt[0][499]);
	}

	public static int max(int a, int b) {
		if (a > b) {
			return a;
		} else {
			return b;
		}
	}
}
