package problemSolvingStrategy.graph.Dictionary;

import java.util.*;

public class Main {
	final static int ALPHANUM = 26;
	static int[][] alphabetList = new int[ALPHANUM][ALPHANUM];
	static boolean[] visited = new boolean[ALPHANUM];
	static ArrayList<Integer> order = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<ArrayList<String>> strInput = new ArrayList<>();
		int n = sc.nextInt();
		for (int loop = 0; loop < n; loop++) {
			strInput.add(new ArrayList<>());
			int count = sc.nextInt();
			for (int input = 0; input < count; input++) {
				strInput.get(loop).add(sc.next());
			}
		}

		for (int loop = 0; loop < n; loop++) {
			boolean isPossible = true;
			Arrays.fill(visited, false);
			for (int[] a : alphabetList) {
				Arrays.fill(a, 0);
			}
			order.clear();

			// 인접행렬을 이용해 i가 i+1보다 먼저 온다는 것을 표현
			for (int i = 0; i < strInput.get(loop).size() - 1; i++) {
				int len = 0;
				if (strInput.get(loop).get(i + 1).length() < strInput.get(loop).get(i).length()) {
					len = strInput.get(loop).get(i + 1).length();
				} else {
					len = strInput.get(loop).get(i).length();
				}
				for (int j = 0; j < len; j++) {
					// 해당 단어가 다르다는 것은 i번째에 있는 낱말이 i+1번째 있는 낱말보다 더 먼저 온다는 것을 의미함
					// 예를 들어 lotte, lg가 나온다고 하면
					// l은 같으니까 건너뛰고, g가 불려질 때 o가 더 먼저 불려져야함
					// 그러기 위해서는 다음단어인 lg(i+1번째)의 g가 들어갈 행에 o부분을
					// alphabetList[g(i+1번째)][o(i번째)]를 1로 만들어줘야함
					// 그러면 dfs에서 g를 찾으러 들어가게 될때, o를 먼저호출하게 되고, og의 순서를 만들수 있게 됨
					if (strInput.get(loop).get(i + 1).charAt(j) != strInput.get(loop).get(i).charAt(j)) {
						// i+1번째 낱말은 더 늦게 오므로 행의 숫자가 되고, i번째 낱말은 뒤에 오므로 열의 숫자가 됨
						// dfs로 i+1에 들어가게 되면 i번째 낱말이 true가 아니라면 i번째(dfs(i))를 먼저
						// 호출함
						// '<' 크다고 표시하더라도 정렬결과는 얻을 수 있지만 클 경우에만 1로 바꿔줄 경우
						// ba, aa, ab일 때, 이미 alphabet[b][a]가 있는데, alphabet[a][b]가 생겨 모순이 된다.
						// '<' 크다고 할 경우 a < b인 경우만 인접행렬에 저장하게 된다.
						// 실제적인 alphabet[b][a]인 경우 alphabet[a][b]가 1인지 여부를 판단해 모순을 검증할 수 있다
						alphabetList[strInput.get(loop).get(i + 1).charAt(j) - 'a'][strInput.get(loop).get(i).charAt(j)
								- 'a'] = 1;
						break;
					}
				}
			}

			// loop을 돌면서 위상정렬함
			for (int i = 0; i < alphabetList.length; i++) {
				if (!visited[i]) {
					dfs(i);
				}
			}

			// 뒤집어서 저장함/ 굳이 뒤집어서 저장할 필요가 없음
			// Collections.reverse(order);

			for (int i = 0; i < ALPHANUM; i++) {
				for (int j = i + 1; j < ALPHANUM; j++) {
					// order는 순서대로 만들어져있음(위상정렬로 순서대로 만들어 놓음)
					// order에서 i번째는 j번째보다 빠르다는 것임
					// 그런데 alphabetList에서 i, j면 dfs를 수행하는 과정에서(i번째를 here로 놓고
					// 들어가서 j가 나오고 visited가 false면 j번째를 먼저 dfs로 호출함)
					// order에서 j번째에 있는 낱말이 더 먼저 불려질 것임
					// 현재의 단어보다 더 큰 수 중 아무거나라도 1로 되어 있으면 먼저 호출하기 때문에 j를 i+1로 표현함
					// 그렇기 때문에 지금 i가 j보다 더 앞선 단어라는 명제와 논리적으로 모순됨
					if (alphabetList[order.get(i)][order.get(j)] == 1) {
						System.out.println("INVALID HYPOTHESIS");
						isPossible = false;
						break;
					}
				}
				if (isPossible == false) {
					break;
				}
			}

			if (isPossible == true) {
				for (int i = 0; i < order.size(); i++) {
					System.out.print((char) (order.get(i) + 'a'));
				}
				System.out.println();
			}
		}

	}

	public static void dfs(int here) {
		visited[here] = true;
		for (int there = 0; there < alphabetList[here].length; there++) {
			if (alphabetList[here][there] == 1 && !visited[there]) {
				dfs(there);
			}
		}
		order.add(here);
	}
}
