package beakjun.n2098TravelingSalesmanproblem;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] graph = new int[N][N];
		int[] dt = new int[N];
		int min = Integer.MAX_VALUE;
		boolean[] visited = new boolean[N];
		Arrays.fill(dt, 10000000);
		dt[0] = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			int minNum = i;
			for (int j = 0; j < N; j++) {
				if (graph[i][j] != 0 && dt[j] == 100000000) {
					if (min > graph[i][j]) {
						min = graph[i][j];
						minNum = j;
					}
				}
			}
			dt[minNum] = Math.min(dt[minNum], dt[i] + min);
		}

	}

	public static void TSP(int current, int visited) {
		if(visited == 65535) {
			return;
		}
		
		
	}
}
