package beakjun.n10217KCMTravel;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Airport[][] graph = new Airport[N + 1][N + 1];
		int[] dijkstra = new int[N + 1];
		int[] time = new int[N + 1];
		Arrays.fill(dijkstra, 100000000);
		for (int x = 1; x <= N; x++) {
			for (int y = 1; y <= N; y++) {
				graph[x][y] = new Airport();
			}
		}
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph[x][y].cost = Integer.parseInt(st.nextToken());
			graph[x][y].time = Integer.parseInt(st.nextToken());
		}

		dijkstra[1] = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (dijkstra[j] > dijkstra[i] + graph[i][j].cost) {
					dijkstra[j] = dijkstra[i] + graph[i][j].cost;
					time[j] += graph[i][j].time;
				}
			}
		}
		if (dijkstra[N] != 100000000 && dijkstra[N] < M && dijkstra[N] != 0) {
			System.out.println(time[N]);
		} else {
			System.out.println("Poor KCM");
		}
	}

}

class Airport {
	int cost;
	int time;
}