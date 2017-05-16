package beakjun.n2579stairs;

import java.io.*;

public class Main {
	public static int[][] dt = new int[500][2];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int stairCount = Integer.parseInt(br.readLine());
		int[] stairs = new int[stairCount];
		for (int i = 0; i < stairCount; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		dt[0][0] = stairs[0]; 	// 건너 뛰는 경우
		dt[0][1] = 0;			// 바로 다음 계단을 선택하는 경우
		dt[1][0] = stairs[1];
		dt[1][1] = stairs[0] + stairs[1];
		for (int i = 2; i < stairs.length; i++) {
			// 건너 뛰는 경우일 때, 2번째 전의 계단을 선택할 때, 2번째 전 계단에서 건너 뛰었을 경우와, 연속했을 경우의 최대값을 이용
			dt[i][0] = max(dt[i - 2][0], dt[i - 2][1]) + stairs[i];
			// 바로 다음 계단을 선택할 경우, 바로 전 계단은 반드시 건너 뛰어야 하므로 dt[i-1][0]임
			dt[i][1] = dt[i - 1][0] + stairs[i];
		}
		System.out.println(max(dt[stairCount - 1][0], dt[stairCount - 1][1]));
	}

	public static int max(int a, int b) {
		if (a > b) {
			return a;
		} else {
			return b;
		}
	}
}
