package beakjun.n1504specificShortestRoad;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// 플로이드-와샬 알고리즘으로 해결
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int[][] graph = new int[V + 1][V + 1];
		for (int i = 0; i <= V; i++) {
			Arrays.fill(graph[i], 100000000);
			graph[i][i] = 0;
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			graph[x][y] = value;
			graph[y][x] = value;
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int to = Integer.parseInt(st.nextToken());
		for (int k = 1; k <= V; k++) {
			for (int i = 1; i <= V; i++) {
				for (int j = 1; j <= V; j++) {
					graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
				}
			}
		}
		int result = Math.min(graph[1][start] + graph[start][to] + graph[to][V], graph[1][to] + graph[to][start] + graph[start][V]);
		if (result >= 100000000) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}
	}
}
