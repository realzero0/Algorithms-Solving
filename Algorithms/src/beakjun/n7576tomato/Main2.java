package beakjun.n7576tomato;

import java.io.*;
import java.util.*;

public class Main2 {
	final static int UP = -1, DOWN = 1, LEFT = -1, RIGHT = 1;
	static Queue<Integer[]> q = new LinkedList<>();
	static int[][] tomatoes;
	static int day = 0;
	static int total;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] whStrArr = br.readLine().split(" ");
		int width = Integer.parseInt(whStrArr[0]);
		int height = Integer.parseInt(whStrArr[1]);
		tomatoes = new int[height][width];
		visited = new boolean[height][width];
		total = height * width;
		for (int i = 0; i < height; i++) {
			whStrArr = br.readLine().split(" ");
			for (int j = 0; j < whStrArr.length; j++) {
				tomatoes[i][j] = Integer.parseInt(whStrArr[j]);
				if (tomatoes[i][j] == 1 && visited[i][j] != true) {
					boolean isPosible = false;
					if (i + UP >= 0) {
						if (tomatoes[i + UP][j] == 0) {
							isPosible = true;
						}
					}
					if (j + LEFT >= 0) {
						if (tomatoes[i][j + LEFT] == 0) {
							isPosible = true;
						}
					}
					if (isPosible == true) {
						Integer[] t = { i, j, day };
						q.add(t);
						visited[i][j] = true;
					}
					total--;
				} else if (tomatoes[i][j] == -1) {
					total--;
				} else {
					if (i + UP >= 0) {
						if (tomatoes[i + UP][j] == 1 && visited[i + UP][j] != true) {
							Integer[] t = { i + UP, j, day };
							q.add(t);
							visited[i + UP][j] = true;
						}
					}
					if (j + LEFT >= 0) {
						if (tomatoes[i][j + LEFT] == 1 && visited[i][j + LEFT] != true) {
							Integer[] t = { i, j + LEFT, day };
							q.add(t);
							visited[i][j + LEFT] = true;
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
		if (t[0] + UP >= 0) {
			if (tomatoes[t[0] + UP][t[1]] == 0) {
				Integer[] t1 = { t[0] + UP, t[1], t[2] + 1 };
				day = t[2] + 1;
				total--;
				tomatoes[t[0]+ UP][t[1]] = 1;
				q.add(t1);
			}
		}
		if (t[0] + DOWN < tomatoes.length) {
			if (tomatoes[t[0] + DOWN][t[1]] == 0) {
				Integer[] t1 = { t[0] + DOWN, t[1], t[2] + 1 };
				day = t[2] + 1;
				total--;
				tomatoes[t[0]+ DOWN][t[1]] = 1;
				q.add(t1);
			}
		}
		if (t[1] + LEFT >= 0) {
			if (tomatoes[t[0]][t[1] + LEFT] == 0) {
				Integer[] t1 = { t[0], t[1] + LEFT, t[2] + 1 };
				day = t[2] + 1;
				total--;
				tomatoes[t[0]][t[1] + LEFT] = 1;
				q.add(t1);
			}
		}
		if (t[1] + RIGHT < tomatoes[0].length) {
			if (tomatoes[t[0]][t[1] + RIGHT] == 0) {
				Integer[] t1 = { t[0], t[1] + RIGHT, t[2] + 1 };
				day = t[2] + 1;
				total--;
				tomatoes[t[0]][t[1] + RIGHT] = 1;
				q.add(t1);
			}
		}
	}
}
