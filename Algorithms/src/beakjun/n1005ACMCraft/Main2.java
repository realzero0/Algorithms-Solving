package beakjun.n1005ACMCraft;

import java.io.*;
import java.util.*;

public class Main2 {

	public static void main(String[] args) throws IOException {

		int T = 0; // TC 개수
		int N = 0; // 건물 개수
		int K = 0; // 건설순서규칙의 개수
		int W = 0; // 승리하기 위해 지어야 하는 건물

		ArrayList<ArrayList<Integer>> XY;
		int[] D; // 각 건물당 건설에 걸리는 시간
		int[] indegree;
		int[] cost; // 최고 비용

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		/* Input-------------------------------------------------------------- */
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			D = new int[N + 1];
			indegree = new int[N + 1];
			cost = new int[N + 1];
			XY = new ArrayList<ArrayList<Integer>>();

			// 초기화 블록
			for (int i = 0; i <= N; i++) {

				D[i] = -1;
				indegree[i] = 0;
				cost[i] = 0;
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {

				D[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i <= N; i++) {

				XY.add(new ArrayList<Integer>());
			}

			for (int i = 0; i < K; i++) {

				st = new StringTokenizer(br.readLine());

				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());

				XY.get(X).add(Y);
				indegree[Y]++;
			}

			W = Integer.parseInt(br.readLine());

			/* ~Input---------------------------------------------------------- */

			Queue<Integer> q = new LinkedList<Integer>();

			// indegree가 0인 노드들을 Queue에 넣는다.
			for (int i = 1; i <= N; i++) {

				if (indegree[i] == 0) {

					q.offer(i);
					cost[i] = D[i];
				}
			}

			// N번 Loop : 노드가 N개이고 loop 1번에 노드가 1개씩 처리될 것이다.
			for (int i = 0; i < N; i++) {

				if (q.isEmpty()) {

					return;
				}

				int v = q.poll();
				for (int nextNode : XY.get(v)) {

					// indegree가 0인 노드들을 제거하면서, 인접한 노드들의 indegree를 1씩 줄여준다.
					indegree[nextNode]--;

					// 인접한 노드들의 cost를 갱신해준다.
					if (cost[nextNode] < cost[v] + D[nextNode]) {

						cost[nextNode] = cost[v] + D[nextNode];
					}

					// 인접한 노드의 indegree가 0이 되면 Queue에 삽입한다.
					if (indegree[nextNode] == 0) {

						q.offer(nextNode);
					}
				}
			}

			System.out.println(cost[W]);

		}

	}

}
