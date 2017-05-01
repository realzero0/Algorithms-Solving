package algospot.JUMPGAME;

import java.io.*;
import java.util.*;

public class Main {
	// 게임판 크기
	static int n;
	static int[][] board = new int[100][100];
	static int[][] cache = new int[100][100];
	public static void main(String []args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCount = Integer.parseInt(st.nextToken());
		boolean[] isPossible = new boolean[testCount];
		for(int i = 0 ; i < testCount; i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			for(int m = 0; m<n; m++) {
				Arrays.fill(cache[m], -1);
				Arrays.fill(board[m], 0);
			}
			for(int j = 0; j < n ; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k = 0; k < n; k++) {					
					board[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			if(jump(0, 0) == 1) {
				isPossible[i] = true;
			} else {
				isPossible[i] = false;
			}
		}
		for(boolean a : isPossible) {
			if(a == true) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
	
	public static int jump(int y, int x) {
		// 게임판 밖으로 벗어난 경우
		if(y >= n || x >= n) {
			return 0;
		}
		
		// 기저사례: 게임판 마지막 칸에 도착한 경우
		if(y == n-1 && x == n-1) {
			return 1;
		}
		if(cache[y][x] != -1) {
			return cache[y][x];
		}
		int jumpSize = board[y][x];
		return cache[y][x] = (jump(y + jumpSize, x) == 1 || jump(y, x + jumpSize) == 1) ? 1 : 0;
	}
}
