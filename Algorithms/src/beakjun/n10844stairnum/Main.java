package beakjun.n10844stairnum;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] d = new int[101][10];
		long sum = 0;
		Arrays.fill(d[1], 1);
		for (int i = 1; i < N; i++) {
			for (int j = 0; j <= 9; j++) {
				if (j + 1 > 9) {
					d[i + 1][j] = d[i][j - 1];
				} else if (j - 1 < 0) {
					d[i + 1][j] = d[i][j + 1];
				} else {
					d[i + 1][j] = d[i][j - 1] + d[i][j + 1];
					if(d[i + 1][j] > 1000000000) {
						d[i + 1][j] = d[i + 1][j] % 1000000000;
					}
				}
			}
		}
		
		for (int i = 1; i < 10; i++) {
			sum += d[N][i];
		}
		System.out.println(sum % 1000000000);
	}
}
