package beakjun.n9252LCS2;

import java.io.*;
import java.util.*;

public class Main2 {
	static int[][] dt = new int[1001][1001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String firstString = br.readLine();
		String secondString = br.readLine();
		//링크드 리스트로 구현할 경우 4ms 정도 속도가 늘어남
		List<Character> stack = new LinkedList<>();
		for (int i = 1; i <= secondString.length(); i++) {
			for (int j = 1; j <= firstString.length(); j++) {
				if (firstString.charAt(j - 1) == secondString.charAt(i - 1)) {
					dt[i][j] = dt[i - 1][j - 1] + 1;
				} else {
					dt[i][j] = max(dt[i][j - 1], dt[i - 1][j]);
				}
			}
		}
		int i = secondString.length();
		int j = firstString.length();
		while (i >= 1 && j >= 1) {
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
			System.out.print(stack.remove(stack.size()-1));
		}
		System.out.println();
	}

	public static int max(int a, int b) {
		if (a > b) {
			return a;
		} else {
			return b;
		}
	}
}
