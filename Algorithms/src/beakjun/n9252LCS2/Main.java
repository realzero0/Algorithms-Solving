package beakjun.n9252LCS2;

import java.io.*;
import java.util.*;

public class Main {
	static int[][] dt = new int[1001][1001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String firstString = br.readLine();
		String secondString = br.readLine();
		// Stack
		Stack<Character> stack = new Stack<>();
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
		int i = secondString.length();
		int j = firstString.length();
		while (i >= 1 && j >= 1) {
			// 시퀀스에서 왼쪽 위쪽 중 같은 값이 있으면 이동 후 더 이상 같은 값이 없을 때, 다음 단계와 비교함
			if (dt[i - 1][j] == dt[i][j]) {
				i--;
				continue;
			}
			if (dt[i][j - 1] == dt[i][j]) {
				j--;
				continue;
			}
			if (dt[i - 1][j - 1] == dt[i][j] - 1) {
				stack.add(firstString.charAt(j - 1));
				i--;
				j--;
			}
		}
		System.out.println(dt[secondString.length()][firstString.length()]);
		while (!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
	}

	public static int max(int a, int b) {
		if (a > b) {
			return a;
		} else {
			return b;
		}
	}
}
