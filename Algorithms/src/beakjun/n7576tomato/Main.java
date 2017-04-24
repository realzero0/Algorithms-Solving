package beakjun.n7576tomato;

import java.io.*;
import java.util.*;

public class Main {
	final static int[] DX = { -1, 0, 1, 0 }; // up, left, down, right
	final static int[] DY = { 0, -1, 0, 1 };
	static Queue<Integer[]> q = new LinkedList<>();
	static int[][] tomatoes;
	static int day = 0;
	static int total, width, height;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		width = Integer.valueOf(st.nextToken());
		height = Integer.valueOf(st.nextToken());
		tomatoes = new int[height][width];
		boolean able = false;
		boolean all = true;
		for (int i = 0; i < height; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < width; j++) {
				tomatoes[i][j] = Integer.valueOf(st.nextToken());
				if (tomatoes[i][j] == 1) {
					able = true;
					Integer[] t = { i, j, day };
					q.add(t);
					total++;
				} else if (tomatoes[i][j] == -1) {
					all = false;
					total++;
				} else {
					all = false;
				}
			}
		}
		if (!able) {
			System.out.println(-1);
			return;
		}

		if (all) {
			System.out.println(0);
			return;
		}
		while (!q.isEmpty()) {
			bfs(q.remove());
		}
		if (total == height * width) {
			System.out.println(day);
		} else {
			System.out.println(-1);
		}

	}

	static public void bfs(Integer[] t) {
		for (int i = 0; i < 4; i++) {
			if (t[0] + DX[i] >= 0 && t[1] + DY[i] >= 0 && t[0] + DX[i] < height
					&& t[1] + DY[i] < width) {
				if (tomatoes[t[0] + DX[i]][t[1] + DY[i]] == 0) {
					Integer[] t1 = { t[0] + DX[i], t[1] + DY[i], t[2] + 1 };
					day = t[2] + 1;
					total++;
					tomatoes[t[0] + DX[i]][t[1] + DY[i]] = 1;
					q.add(t1);
				}
			}
		}
	}
}
