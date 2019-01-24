package study01.programmers.skcnc.no3;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

}

class Solution {
	int solution(int[][] board, int K, int Ax, int Ay, int Bx, int By) {
		final int[] DX = { 0, 0, -1, 1 }; // 상, 하, 좌, 우
		final int[] DY = { -1, 1, 0, 0 };
		int possibleCount = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == 1) {
					int x = i;
					int y = j + 1;
					int k = 0;
					while (y < board.length && board[x][y] != 2 && board[i][y] != 1 && k < K) {
						board[x][y] = -1;
						k++;
						y++;
					}
					x = i;
					y = j - 1;
					k = 0;
					while (y >= 0 && board[x][y] != 2 && board[i][y] != 1 && k < K) {
						board[x][y] = -1;
						k++;
						y--;
					}
					x = i + 1;
					y = j;
					k = 0;
					while (x < board.length && board[x][y] != 2 && board[i][y] != 1 && k < K) {
						board[x][y] = -1;
						k++;
						x++;
					}
					x = i - 1;
					y = j;
					k = 0;
					while (x >= 0 && board[x][y] != 2 && board[i][y] != 1 && k < K) {
						board[x][y] = -1;
						k++;
						x--;
					}
				}
			}
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == 0) {
					possibleCount++;
				}
			}
		}
		if (possibleCount < 2) {
			return -1;
		}
		Queue<Integer[]> q = new LinkedList<>();
		q.add(new Integer[] { Ax, Ay, 0 });
		while (!q.isEmpty()) {
			Integer[] element = q.poll();
			if(board[element[0]][element[1]] == 0) {
				if(min > element[2]) {
					min = element[2];
				}
				break;
			}
			for (int i = 0; i < 4; i++) {
				if (element[0] + DX[i] >= 0 && element[0] + DX[i] < board.length && element[1] + DY[i] >= 0
						&& element[1] + DY[i] < board.length) {
					if(board[element[0] + DX[i]][element[1] + DY[i]] == -1 && board[element[0] + DX[i]][element[1] + DY[i]] == 0) {
						q.add(new Integer[] { element[0] + DX[i], element[1] + DY[i], element[2] + 1 });
					}
				}
			}
		}
		q.clear();
		return min;
	}
}