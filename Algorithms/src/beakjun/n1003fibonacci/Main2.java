package beakjun.n1003fibonacci;

import java.io.*;
import java.util.*;

public class Main2 {
	static int[][] fibos = new int[40 + 1][2];
	public static void main(String[] args) throws IOException {
		fibos[0][0] = 1;
		fibos[0][1] = 0;
		fibos[1][0] = 0;
		fibos[1][1] = 1;
		for(int i=2; i<=40; i++) {
			fibos[i][0] = fibos[i-1][0] + fibos[i-2][0];
			fibos[i][1] = fibos[i-1][1] + fibos[i-2][1];
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int count = Integer.parseInt(st.nextToken());
		int[][] fiboCal = new int[count][2];
		for(int i=0; i<count; i++) {
			st = new StringTokenizer(br.readLine());
			int input = Integer.parseInt(st.nextToken());
			fiboCal[i][0] = fibos[input][0];
			fiboCal[i][1] = fibos[input][1];
		}
		for(int[] a : fiboCal) {
			System.out.println(a[0] + " " + a[1]);
		}
	}

}
