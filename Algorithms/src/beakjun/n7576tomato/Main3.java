package beakjun.n7576tomato;

import java.io.*;
import java.util.*;

public class Main3 {
	final static int[] DX = { -1, 0, 1, 0 }; // up, left, down, right
	final static int[] DY = { 0, -1, 0, 1 };
	static Queue<Integer[]> q = new LinkedList<>();
	static int[][] tomatoes;
	static int day = 0;
	static int total;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] whStrArr = br.readLine().split(" ");
		int width = Integer.parseInt(whStrArr[0]);
		int height = Integer.parseInt(whStrArr[1]);
		tomatoes = new int[height][width];
		total = height * width;
		for (int i = 0; i < height; i++) {
			whStrArr = br.readLine().split(" ");
			for (int j = 0; j < whStrArr.length; j++) {
				tomatoes[i][j] = Integer.parseInt(whStrArr[j]);
				if (tomatoes[i][j] == 1) {
					boolean isPosible = false;
					for (int k = 0; k < 2; k++) {
						if (i + DX[k] >= 0 && j + DY[k] >= 0 && i + DX[k] < tomatoes.length
								&& j + DY[k] < tomatoes[0].length) {
							if (tomatoes[i + DX[k]][j + DY[k]] == 0) {
								isPosible = true;
								break;
							}
						}
					}
					if (isPosible == true) {
						Integer[] t = { i, j, day };
						q.add(t);
					}
					total--;
				} else if (tomatoes[i][j] == -1) {
					total--;
				} else {
					for (int k = 0; k < 2; k++) {
						if (i + DX[k] >= 0 && j + DY[k] >= 0 && i + DX[k] < tomatoes.length
								&& j + DY[k] < tomatoes[0].length) {
							if (tomatoes[i + DX[k]][j + DY[k]] == 1) {
								Integer[] t = { i + DX[k], j + DY[k], day };
								q.add(t);
							}
						}
					}
				}
			}
		}
		while (!q.isEmpty()) {
			bfs(q.remove());
		}
		if (total == 0) {
			System.out.println(day);
		} else {
			System.out.println(-1);
		}

	}

	static public void bfs(Integer[] t) {
		for (int i = 0; i < 4; i++) {
			if (t[0] + DX[i] >= 0 && t[1] + DY[i] >= 0 && t[0] + DX[i] < tomatoes.length
					&& t[1] + DY[i] < tomatoes[0].length) {
				if (tomatoes[t[0] + DX[i]][t[1] + DY[i]] == 0) {
					Integer[] t1 = { t[0] + DX[i], t[1] + DY[i], t[2] + 1 };
					day = t[2] + 1;
					total--;
					tomatoes[t[0] + DX[i]][t[1] + DY[i]] = 1;
					q.add(t1);
				}
			}
		}
	}
}
