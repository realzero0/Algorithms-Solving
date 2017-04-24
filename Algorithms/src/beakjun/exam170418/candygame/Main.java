package beakjun.exam170418.candygame;

// 옮긴걸 다시 제자리에 돌려놓으면 두 개의 배열변수가 필요하지는 않음

import java.util.*;

public class Main {
	final static int UP = -1, DOWN = 1, LEFT = -1, RIGHT = 1;
	static char[][] candies;
	static char[][] clone;
	static boolean[] visited;
	static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = 0;
		int length = sc.nextInt();
		candies = new char[length][length];
		clone = new char[length][length];
		visited = new boolean[length];
		for (int i = 0; i < candies.length; i++) {
			candies[i] = sc.next().toCharArray();
		}
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				for (int direction = 0; direction < 2; direction++) {
					for(int k=0; k<length; k++) {
						for(int l=0; l<length; l++) {
							clone[k][l] = candies[k][l];
						}
					}
					int a = swap(i, j, direction);
					if (c < a) {
						c = a;
					}
				}
			}
		}
		if(c == 1) {
			c = 0;
		}
		System.out.println(c);
	}

	// swap한 뒤에 찾아냄
	public static int swap(int row, int col, int direction) {
		char tmp = 0;
		int max = 0;
		switch (direction) {
		// 0 = down, 1 = right, 아래랑 오른쪽만 확인하면 모든 경우의 수 확인가능함
		case 0:
//			if (row + DOWN >= clone.length || clone[row][col] == clone[row + DOWN][col]) {
			if (row + DOWN >= clone.length) {
				return 0;
			}
			// 자리를 바꿈
			tmp = clone[row][col];
			clone[row][col] = clone[row + DOWN][col];
			clone[row + DOWN][col] = tmp;
			// count를 0으로 초기화하고 세로, 가로로 찾음
			for (int n = 0; n < 2; n++) {
				count = 0;
				Arrays.fill(visited, false);
				// n이 0이면 세로로 바꾼다는 의미임.
				dfs(clone[row][col], row, col, n);
				if (max < count) {
					max = count;
				}
				count = 0;
				Arrays.fill(visited, false);
				dfs(clone[row + DOWN][col], row + DOWN, col, n);
				if (max < count) {
					max = count;
				}
			}
			break;
		case 1:
//			if (col + RIGHT >= clone.length || clone[row][col] == clone[row][col + RIGHT]) {
			if (col + RIGHT >= clone.length) {
				return 0;
			}
			tmp = clone[row][col];
			clone[row][col] = clone[row][col + RIGHT];
			clone[row][col + RIGHT] = tmp;
			for (int n = 0; n < 2; n++) {
				count = 0;
				Arrays.fill(visited, false);
				dfs(clone[row][col], row, col, n);
				if (max < count) {
					max = count;
				}
				count = 0;
				Arrays.fill(visited, false);
				dfs(clone[row][col + RIGHT], row, col + RIGHT, n);
				if (max < count) {
					max = count;
				}
			}
			break;
		default:
			break;
		}
		return max;
	}

	// 세로, 가로 따로 dfs 가능하게 함
	public static void dfs(char compare, int row, int col, int direction) {

		if (direction == 0) {
			if (clone[row][col] == compare && !visited[row]) {
				count++;
				visited[row] = true;
			}
			if (row + UP >= 0) {
				if (clone[row + UP][col] == compare && !visited[row + UP]) {
					dfs(compare, row + UP, col, 0);
				}
			}
			if (row + DOWN < clone.length) {
				if (clone[row + DOWN][col] == compare && !visited[row + DOWN]) {
					dfs(compare, row + DOWN, col, 0);
				}
			}
		} else {
			if (clone[row][col] == compare && !visited[col]) {
				count++;
				visited[col] = true;
			}
			if (col + LEFT >= 0) {
				if (clone[row][col + LEFT] == compare && !visited[col + LEFT]) {
					dfs(compare, row, col + LEFT, 1);
				}
			}
			if (col + RIGHT < clone.length) {
				if (clone[row][col + RIGHT] == compare && !visited[col + RIGHT]) {
					dfs(compare, row, col + RIGHT, 1);
				}
			}
		}
	}
}
