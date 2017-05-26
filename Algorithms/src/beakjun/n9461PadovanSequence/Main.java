package beakjun.n9461PadovanSequence;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int padovanNum;
		long[] dt = new long[101];
		dt[1] = 1;
		dt[2] = 1;
		dt[3] = 1;
		dt[4] = 2;
		dt[5] = 2;
		int j = 6;
		for (int i = 0; i < T; i++) {
			padovanNum = Integer.parseInt(br.readLine());
			for (; j <= padovanNum; j++) {
				dt[j] = dt[j - 1] + dt[j - 5];
			}
			System.out.println(dt[padovanNum]);
		}
	}
}
