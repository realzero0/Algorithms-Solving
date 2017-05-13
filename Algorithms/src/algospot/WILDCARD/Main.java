package algospot.WILDCARD;

import java.io.*;
import java.util.*;

public class Main {
	// -1은 아직 답이 계산되지 않음을 의미
	// 1은 해당 입력들이 서로 대응됨을 의미
	// 0은 해당 입력들이 서로 대응되지 않음을 의미
	static int[][] cache = new int[100 + 1][100 + 1];
	static String W, S;
	static Comparator<String> s = new Comparator<String>() {

		@Override
		public int compare(String o1, String o2) {
			if (o1.compareTo(o2) > 0) {
				return 1;
			} else if (o1.compareTo(o2) < 0) {
				return -1;
			} else {
				return 0;
			}
		}
	};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<ArrayList<String>> elements = new ArrayList<>();
		int testCount = Integer.parseInt(br.readLine());
		int elementCount;
		for (int i = 0; i < testCount; i++) {
			W = br.readLine();
			ArrayList<String> els = new ArrayList<>();
			elementCount = Integer.parseInt(br.readLine());
			for (int j = 0; j < elementCount; j++) {
				S = br.readLine();
				if (matchMemoized(0, 0) == 1) {
					els.add(S);
				}
			}
			System.out.println(els);
			els.sort(s);
			elements.add(els);
		}
		System.out.println(elements);
	}

	public static int matchMemoized(int w, int s) {
		// 메모이제이션
		if (cache[w][s] != -1) {
			return cache[w][s];
		}
		// W[w]와 S[s]를 맞춰나감
		while (s < S.length() && w < W.length() && (W.charAt(w) == '?' || W.charAt(w) == S.charAt(s))) {
			w++;
			s++;
		}
		// 더이상 대응할 수 없으면 왜 while문이 끝났는지 확인
		// 패턴 끝에 도달해서 끝난 경우: 문자열도 끝났어야 참
		if (w == W.length()) {
			return cache[w][s] = (s == S.length()) ? 1 : 0;
		}

		// *를 만나서 끝난 경우: *에 몇 글자를 대응해야 할지 재귀 호출하면서 확인
		if (W.charAt(w) == '*') {
			for (int skip = 0; skip + s <= S.length(); skip++) {
				if (matchMemoized(w + 1, s + skip) == 1) {
					return cache[w][s] = 1;
				}
			}
		}

		// 이 외의 경우 모두 대응되지 않음
		return cache[w][s] = 0;
	}
}
