package beakjun.n11657timeMachine;

import java.io.*;
import java.util.*;

public class Main {
	// 벨만 포드 알고리즘으로 해결, 음수 사이클 확인이 가능함
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Edge[] edges = new Edge[M];
		int[] distance = new int[N + 1];
		Arrays.fill(distance, 900000000);
		distance[1] = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			edges[i] = new Edge();
			edges[i].source = Integer.parseInt(st.nextToken());
			edges[i].dest = Integer.parseInt(st.nextToken());
			edges[i].weight = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < M; j++) {
				if (distance[edges[j].dest] > distance[edges[j].source] + edges[j].weight) {
					distance[edges[j].dest] = distance[edges[j].source] + edges[j].weight;
				}
			}
		}
		for (int i = 0; i < M; i++) {
			// 음수 싸이클이 있는지 확인
			if (distance[edges[i].dest] > distance[edges[i].source] + edges[i].weight) {
				System.out.println(-1);
				return;
			}
		}
		for (int i = 2; i <= N; i++) {
			if(distance[i] == 900000000) {
				System.out.println(-1);
			} else {
				System.out.println(distance[i]);
			}
		}
	}

}

class Edge {
	int source;
	int dest;
	int weight;
}