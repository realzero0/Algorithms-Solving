package beakjun.n4307ant;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testcase = Integer.parseInt(br.readLine());
		int[][] results = new int[testcase][2];
		for (int i = 0; i < testcase; i++) {
			st = new StringTokenizer(br.readLine());
			int stickLength = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int k;
			int longMax = -1;
			int shortMax = -1;
			for (int j = 0; j < n; j++) {
				k = Integer.parseInt(br.readLine());
				if (k > stickLength - k) {
					if (k > longMax) {
						longMax = k;
					}
					if (stickLength - k > shortMax) {
						shortMax = stickLength - k;
					}
				} else {
					if (stickLength - k > longMax) {
						longMax = stickLength - k;
					}
					if (k > shortMax) {
						shortMax = k;
					}
				}
			}
			results[i][0] = shortMax;
			results[i][1] = longMax;
		}
		for (int[] result : results) {
			System.out.println(result[0] + " " + result[1]);
		}
	}
}
