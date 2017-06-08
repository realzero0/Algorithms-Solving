package beakjun.n1753minimumroad;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		int[][] graph = new int[V + 1][V + 1];
		int[] dijkstra = new int[V + 1];
		for (int i = 0; i < V + 1; i++) {
			Arrays.fill(graph[i], -1);
		}
		Arrays.fill(dijkstra, 100000000);
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			graph[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = Integer
					.parseInt(st.nextToken());
		}
		
		dijkstra[K] = 0;
		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				if(graph[i][j] != -1) {
					dijkstra[j] = Math.min(dijkstra[i] + graph[i][j], dijkstra[j]);
				}
			}
		}
		
		for(int i = 1; i<=V; i++) {
			if(dijkstra[i] == 100000000) {
				System.out.println("INF");
			} else {
				System.out.println(dijkstra[i]);
			}
		}
	}
}
