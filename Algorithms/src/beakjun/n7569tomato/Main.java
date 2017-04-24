package beakjun.n7569tomato;

import java.io.*;
import java.util.*;

public class Main {
	final static int[] DM = { -1, 0, 1, 0, 0, 0 }; // up, left, down, right, 상, 하
	final static int[] DN = { 0, -1, 0, 1, 0, 0 };
	final static int[] DH = { 0, 0, 0, 0, -1, 1 };
	static Queue<Pointer> q = new LinkedList<>();
	static int[][][] tomatoes;
	static int day = 0;
	static int total, M, N, H;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.valueOf(st.nextToken());
		N = Integer.valueOf(st.nextToken());
		H = Integer.valueOf(st.nextToken());
		tomatoes = new int[H][N][M];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					tomatoes[i][j][k] = Integer.valueOf(st.nextToken());
					if (tomatoes[i][j][k] == 1) {
						Pointer t = new Pointer(i, j, k, day);
						q.add(t);
						total++;
					} else if (tomatoes[i][j][k] == -1) {
						total++;
					}
				}

			}
		}
		if (total == M * N * H) {
			System.out.println(day);
			return;
		}
		while (!q.isEmpty()) {
			bfs(q.remove());
		}
		if (total == M * N * H) {
			System.out.println(day);
		} else {
			System.out.println(-1);
		}

	}

	static public void bfs(Pointer t) {
		for (int i = 0; i < 6; i++) {
			if (t.h + DH[i] >= 0 && t.n + DN[i] >= 0 && t.m + DM[i] >= 0 && t.h + DH[i] < H && t.n + DN[i] < N
					&& t.m + DM[i] < M) {
				if (tomatoes[t.h + DH[i]][t.n + DN[i]][t.m + DM[i]] == 0) {
					Pointer t1 = new Pointer(t.h + DH[i], t.n + DN[i], t.m + DM[i], t.day + 1);
					day = t.day + 1;
					total++;
					tomatoes[t.h + DH[i]][t.n + DN[i]][t.m + DM[i]] = 1;
					q.add(t1);
				}
			}
		}
	}
}

class Pointer {
	int h;
	int n;
	int m;
	int day;

	public Pointer(int h, int n, int m, int day) {
		this.h = h;
		this.n = n;
		this.m = m;
		this.day = day;
	}
}
