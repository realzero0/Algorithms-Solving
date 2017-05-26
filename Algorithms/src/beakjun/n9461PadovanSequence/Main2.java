package beakjun.n9461PadovanSequence;

import java.io.*;

public class Main2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		long[] dt = new long[101];
		dt[3] = dt[2] = dt[1] = 1;
		dt[5] = dt[4] = 2;
		for (int j = 6; j <= 100; j++) {
			dt[j] = dt[j - 5] + dt[j - 1];
		}
		for (int i = 0; i < T; i++) {
			System.out.println(dt[Integer.parseInt(br.readLine())]);
		}
	}
}
