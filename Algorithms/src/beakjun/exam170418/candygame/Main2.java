package beakjun.exam170418.candygame;

import java.util.*;
// 자리가 바뀔 경우 행, 열에 관계없이 최대 갯수를 구하는 프로그램임
public class Main2 {
	final static int UP = -1, DOWN = 1, LEFT = -1, RIGHT = 1;
	static int count = 0;
	static char[][] clone;
	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int max = 0;
		char[][] candies = new char[length][length];
		visited = new boolean[length][length];

		for (int i = 0; i < candies.length; i++) {
			candies[i] = sc.next().toCharArray();
		}
		clone = new char[length][length];
		clone = candies.clone();
		max = swap(0, 0, 0);
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				for (int direction = 0; direction < 2; direction++) {
					count = 0;
					for (boolean[] a : visited) {
						Arrays.fill(a, false);
					}
					clone = candies.clone();
					int c = swap(i, j, direction);
					if (max < c) {
						max = c;
					}
				}
			}
		}
		System.out.println(max);
	}

	public static int swap(int row, int col, int direction) {// swap한뒤에
		// swap한 부분의
		// 좌표를 리턴함
		char tmp = 0;
		int a = 0;
		switch (direction) {
		// 1 = up, 2=down, 3=left, 4=right // 0 = down 1 = right 만 바꿔보면 다 바꿀수 있음
		// case 1:
		// if (row + UP < 0) {
		// return new int[0][0];
		// }
		// char tmp = candies[row][col];
		// candies[row][col] = candies[row + UP][col];
		// candies[row][col] = tmp;
		// target[1][0] = row + UP;
		// target[1][1] = col;
		// break;
		case 0:
			if (row + DOWN  >= clone.length) {
				return 0;
			}
			tmp = clone[row][col];
			clone[row][col] = clone[row + DOWN][col];
			clone[row][col] = tmp;
			count = 0;
			dfs(clone[row][col], row, col);
			a = count;
			count = 0;
			dfs(clone[row + DOWN][col], row + DOWN, col);
			if (a > count) {
				return a;
			} else {
				return count;
			}
		// case 3:
		// if (col + LEFT < 0) {
		// return new int[0][0];
		// }
		// char tmp = candies[row][col];
		// candies[row][col] = candies[row][col + LEFT];
		// candies[row][col] = tmp;
		// target[1][0] = row;
		// target[1][1] = col + LEFT;
		// break;
		case 1:
			if (col + RIGHT  >= clone.length) {
				return 0;
			}
			tmp = clone[row][col];
			clone[row][col] = clone[row][col + RIGHT];
			clone[row][col + RIGHT] = tmp;
			count = 0;
			dfs(clone[row][col], row, col);
			a = count;
			count = 0;
			dfs(clone[row][col + RIGHT], row, col + RIGHT);
			if (a > count) {
				return a;
			} else {
				return count;
			}
		default:
			break;
		}
		return 0;
	}

	public static void dfs(char compare, int row, int col) {
		if (clone[row][col] == compare && !visited[row][col]) {
			count++;
			visited[row][col] = true;
		}

		if (row + UP >= 0) {
			if (clone[row + UP][col] == compare && !visited[row + UP][col]) {
				dfs(compare, row + UP, col);
			}
		}
		if (row + DOWN < clone.length) {
			if (clone[row + DOWN][col] == compare && !visited[row + DOWN][col]) {
				dfs(compare, row + DOWN, col);
			}
		}
		if (col + LEFT >= 0) {
			if (clone[row][col + LEFT] == compare && !visited[row][col + LEFT]) {
				dfs(compare, row, col + LEFT);
			}
		}
		if (col + RIGHT < clone.length) {
			if (clone[row][col + RIGHT] == compare && !visited[row][col + RIGHT]) {
				dfs(compare, row, col + RIGHT);
			}
		}

	}

}
