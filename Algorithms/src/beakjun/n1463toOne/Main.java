package beakjun.n1463toOne;

import java.io.*;

public class Main {
	public static int[] dt = new int[1000001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int compare;
		dt[1] = 0;
		dt[2] = 1;
		dt[3] = 1;
		for (int i = 4; i <= num; i++) {
			compare = num;
			if (i % 3 == 0) {
				compare = dt[i / 3];
			}
			if (i % 2 == 0) {
				compare = min(compare, dt[i / 2]);
			}
			compare = min(compare, dt[i - 1]);
			dt[i] = compare + 1;
		}
		System.out.println(dt[num]);
	}

	public static int min(int a, int b) {
		if (a > b) {
			return b;
		} else {
			return a;
		}
	}
}