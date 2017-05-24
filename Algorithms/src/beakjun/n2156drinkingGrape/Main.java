package beakjun.n2156drinkingGrape;

import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[][] dt = new int[2][n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		if(n == 1) {
			System.out.println(arr[0]);
			return;
		} else if(n == 2) {
			System.out.println(arr[0]+arr[1]);
			return;
		}
		dt[0][0] = arr[0]; dt[1][0] = arr[0];
		dt[0][1] = arr[1];
		dt[1][1] = dt[1][0] + arr[1];
		dt[0][2] = dt[0][0] + arr[2];
		dt[1][2] = dt[0][1] + arr[2];
		for(int i=3; i<n; i++) {
			dt[0][i] = max(dt[0][i-2], dt[0][i-3], dt[1][i-2], dt[1][i-3]) + arr[i];
			dt[1][i] = max(dt[0][i-1], dt[0][i-2], dt[1][i-2], dt[1][i-3]) + arr[i];
		}
		System.out.println(max(dt[0][n-1], dt[0][n-2], dt[1][n-1], dt[1][n-2]));
	}
	static int max(int a, int b, int c, int d) {
		int max, tmp;
		if(a > b) {
			max = a;
		} else {
			max = b;
		}
		if(c > d) {
			tmp = c;
		} else {
			tmp = d;
		}
		if(max > tmp) {
			return max;
		} else {
			return tmp;
		}
	}
}
