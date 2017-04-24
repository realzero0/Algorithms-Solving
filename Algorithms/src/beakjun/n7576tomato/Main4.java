package beakjun.n7576tomato;

import java.io.*;
import java.util.*;

public class Main4 {
	final static int[] DX = { -1, 0, 1, 0 }; // up, left, down, right
	final static int[] DY = { 0, -1, 0, 1 };
	static Queue<Pointer> q = new LinkedList<>();
	static int[][] tomatoes;
	static int day = 0;
	static int total, width, height;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		width = Integer.valueOf(st.nextToken());
		height = Integer.valueOf(st.nextToken());
		tomatoes = new int[height][width];
		for (int i = 0; i < height; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < width; j++) {
				tomatoes[i][j] = Integer.valueOf(st.nextToken());
				if (tomatoes[i][j] == 1) {
					Pointer t = new Pointer(i, j, day);
					q.add(t);
					total++;
				} else if (tomatoes[i][j] == -1) {
					total++;
				}
			}
		}
		if (total == height * width) {
			System.out.println(day);
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

	static public void bfs(Pointer t) {
		for (int i = 0; i < 4; i++) {
			if (t.x + DX[i] >= 0 && t.y + DY[i] >= 0 && t.x + DX[i] < height && t.y + DY[i] < width) {
				if (tomatoes[t.x + DX[i]][t.y + DY[i]] == 0) {
					Pointer t1 = new Pointer(t.x + DX[i], t.y + DY[i], t.day + 1);
					day = t.day + 1;
					total++;
					tomatoes[t.x + DX[i]][t.y + DY[i]] = 1;
					q.add(t1);
				}
			}
		}
	}
}

class Pointer {
	int x;
	int y;
	int day;

	public Pointer(int x, int y, int day) {
		this.x = x;
		this.y = y;
		this.day = day;
	}
}
