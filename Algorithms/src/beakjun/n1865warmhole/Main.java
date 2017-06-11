package beakjun.n1865warmhole;

import java.io.*;
import java.util.*;

public class Main {
	public static final String[] YES_OR_NO = { "YES", "NO" };

	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		String[] answers = new String[T];
		for (int i = 0; i < T; i++) {
			answers[i] = YES_OR_NO[1];
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int[][] graph = new int[N + 1][N + 1];
			for (int j = 0; j <= N; j++) {
				Arrays.fill(graph[j], 100000000);
				graph[j][j] = 0;
			}
			for (int j = 0; j < M; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());
				graph[x][y] = Math.min(graph[x][y], value);
				graph[y][x] = Math.min(graph[y][x], value);
			}
			for (int j = 0; j < W; j++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());
				graph[start][end] = Math.min(graph[start][end], -value);
			}

			for (int k = 1; k <= N; k++) {
				for (int x = 1; x <= N; x++) {
					for (int y = 1; y <= N; y++) {
						graph[x][y] = Math.min(graph[x][y], graph[x][k] + graph[k][y]);
					}
				}
			}
			for(int x = 1; x<=N; x++) {
				for(int y = 1; y<=N; y++) {
					if(graph[x][y] + graph[y][x] < 0) {
						answers[i] = YES_OR_NO[0];
						break;
					}
				}
				if(answers[i].equals(YES_OR_NO[0])) {
					break;
				}
			}
		}
		for (String str : answers) {
			System.out.println(str);
		}
	}
}