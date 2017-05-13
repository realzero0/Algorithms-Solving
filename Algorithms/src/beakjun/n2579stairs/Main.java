package beakjun.n2579stairs;

import java.io.*;
import java.util.*;

public class Main {
	public static int[][] dt = new int[2][500];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int stairCount = Integer.parseInt(br.readLine());
		int[] stairs = new int[stairCount];
		for (int i = 0; i < stairCount; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		dt[0][0] = stairs[0];
		for (int i = 0; i < stairs.length - 1; i++) {
			if (dt[1][i] != 1 && dt[0][i + 1] < dt[0][i] + stairs[i + 1] && i+2 != stairs.length-1) {
				dt[0][i + 1] = dt[0][i] + stairs[i + 1];
				dt[1][i + 1] = 1;
			}
			if (i + 2 < stairs.length && dt[0][i + 2] < dt[0][i] + stairs[i + 2]) {
				dt[0][i + 2] = dt[0][i] + stairs[i + 2];
				dt[1][i + 2] = 2;
			}
		}
		int tmp = dt[0][stairs.length - 1];
		Arrays.fill(dt[0], 0);
		Arrays.fill(dt[1], 0);
		dt[0][1] = stairs[1];
		for (int i = 1; i < stairs.length - 1; i++) {
			if (dt[1][i] != 1 && dt[0][i + 1] < dt[0][i] + stairs[i + 1] && i+2 != stairs.length-1) {
				dt[0][i + 1] = dt[0][i] + stairs[i + 1];
				dt[1][i + 1] = 1;
			}
			if (i + 2 < stairs.length && dt[0][i + 2] < dt[0][i] + stairs[i + 2]) {
				dt[0][i + 2] = dt[0][i] + stairs[i + 2];
				dt[1][i + 2] = 2;
			}
		}
		if (tmp > dt[0][stairs.length - 1]) {
			System.out.println(tmp);
		} else {
			System.out.println(dt[stairs.length - 1]);
		}
	}
}
