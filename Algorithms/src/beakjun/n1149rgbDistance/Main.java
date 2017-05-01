package beakjun.n1149rgbDistance;

import java.io.*;
import java.util.*;

public class Main {
	static int[][] houses;
	// 다이나믹 테이블
	static int[] d = new int[3];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int count = Integer.parseInt(st.nextToken());
		houses = new int[count][3];
		for (int i = 0; i < count; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				houses[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 다이나믹 테이블 초기화
		for (int i = 0; i < 3; i++) {
			d[i] = houses[0][i];
		}
		// 중간 결과값을 임시 저장
		int[] tmp = new int[3];
		for (int i = 1; i < count; i++) {
			for (int j = 0; j < 3; j++) {
				switch (j) {
				case 0:
					if (d[1] > d[2]) {
						tmp[0] = d[2] + houses[i][0];
					} else {
						tmp[0] = d[1] + houses[i][0];
					}
					break;
				case 1:
					if (d[0] > d[2]) {
						tmp[1] = d[2] + houses[i][1];
					} else {
						tmp[1] = d[0] + houses[i][1];
					}
					break;
				case 2:
					if (d[1] > d[0]) {
						tmp[2] = d[0] + houses[i][2];
					} else {
						tmp[2] = d[1] + houses[i][2];
					}
					break;
				default:
					break;
				}
			}
			d = Arrays.copyOf(tmp, tmp.length);
		}
		Arrays.sort(d);
		System.out.println(d[0]);
	}
}