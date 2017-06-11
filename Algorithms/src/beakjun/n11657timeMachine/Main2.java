package beakjun.n11657timeMachine;

import java.io.*;
import java.util.*;

public class Main2 {
	// 벨만 포드 알고리즘으로 해결, 음수 사이클 확인이 가능함
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] edges = new int[M][3];
			int[] distance = new int[N + 1];
			Arrays.fill(distance, 900000000);
			distance[1] = 0;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				edges[i][0] = Integer.parseInt(st.nextToken());	// source
				edges[i][1] = Integer.parseInt(st.nextToken());	// dest
				edges[i][2] = Integer.parseInt(st.nextToken());	// weight
			}

			for (int i = 1; i <= N - 1; i++) {
				for (int j = 0; j < M; j++) {
					if (distance[edges[j][1]] > distance[edges[j][0]] + edges[j][2]) {
						distance[edges[j][1]] = distance[edges[j][0]] + edges[j][2];
					}
				}
			}
			for (int i = 0; i < M; i++) {
				// 음수 싸이클이 있는지 확인
				if (distance[edges[i][1]] > distance[edges[i][0]] + edges[i][2]) {
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
