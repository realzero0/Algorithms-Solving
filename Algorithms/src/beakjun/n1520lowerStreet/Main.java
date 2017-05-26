package beakjun.n1520lowerStreet;

import java.io.*;
import java.util.*;

public class Main {
	static int M, N, Count;
	static int[][] cache, map;
	static int[] dx = {0, 1, -1, 0};
	static int[] dy = {1, 0, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		cache = new int[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//-1로 초기화 - 가지 않은 위치임을 의미함
		for(int i =0 ; i< M; i++) {
			Arrays.fill(cache[i], -1);
		}
		System.out.println(dp(0, 0));
	}

	public static int dp(int y, int x) {
		int py, px;
		if (y == M - 1 && x == N - 1) {
			// 끝에 도달했을 때 종료
			return 1;
		}
		//이미 한번 이상 도달한 적이 있다면 그 값을 가져옴, 메모이제이션이 사용되는 부분
		if(cache[y][x] != -1) {
			return cache[y][x];
		}
		cache[y][x] = 0;
		for(int i=0; i<4; i++) {
			py = y + dy[i];
			px = x + dx[i];
			if(py < M && py >= 0 && px < N && px >= 0 && map[y][x] > map[py][px]) {
				cache[y][x] += dp(py, px);
			}
		}
		return cache[y][x];
	}
}
