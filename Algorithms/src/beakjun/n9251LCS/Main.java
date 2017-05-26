package beakjun.n9251LCS;

import java.io.*;

public class Main {
	// 다이나믹 테이블을 각 단계마다 숫자를 늘려가는 방식으로 디자인 한다.
	static int[][] dt = new int[1001][1001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String firstString = br.readLine();
		String secondString = br.readLine();
		for (int i = 1; i <= secondString.length(); i++) {
			for (int j = 1; j <= firstString.length(); j++) {
				if (firstString.charAt(j - 1) == secondString.charAt(i - 1)) {
					// 바로 전 단계의 값에 + 1을 해준다. 이는 A - C - A와 같이 비교 순서에서 비교 순서가 하나 증가함을 의미함
					// A를 비교하는 단계에서 C를 비교하는 단계로 바뀌는 것임
					dt[i][j] = dt[i - 1][j - 1] + 1;
				} else {
					// 하나의 시퀀스에서 바로 전은 [i][j-1]또는 [i-1][j]인데, 바로 전 시퀀스 중 큰 값을 저장함 
					dt[i][j] = max(dt[i][j - 1], dt[i - 1][j]);
				}
			}
		}
		System.out.println(dt[secondString.length()][firstString.length()]);

	}

	public static int max(int a, int b) {
		if (a > b) {
			return a;
		} else {
			return b;
		}
	}
}
