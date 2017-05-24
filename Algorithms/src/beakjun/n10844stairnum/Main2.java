package beakjun.n10844stairnum;

import java.io.*;
import java.util.*;

public class Main2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// 메모리 최소화
		int[][] d = new int[2][10];
		long sum = 0;
		Arrays.fill(d[0], 1);
		for (int i = 0; i < N; i++) {
			int k = i % 2;
			int m = (i+1) % 2;
			for (int j = 0; j <= 9; j++) {
				if (j + 1 > 9) {
					d[m][j] = d[k][j - 1];
				} else if (j - 1 < 0) {
					d[m][j] = d[k][j + 1];
				} else {
					d[m][j] = d[k][j - 1] + d[k][j + 1];
					if(d[m][j] > 1000000000) {
						d[m][j] = d[m][j] % 1000000000;
					}
				}
			}
		}
		
		for (int i = 1; i < 10; i++) {
			if(N % 2 == 1) {
				sum += d[0][i];
			} else {
				sum += d[1][i];
			}
		}
		System.out.println(sum % 1000000000);
	}
}
