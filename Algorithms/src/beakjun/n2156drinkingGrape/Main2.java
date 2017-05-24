package beakjun.n2156drinkingGrape;

import java.io.*;

public class Main2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] dt = new int[n];
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
		dt[0] = arr[0];
		dt[1] = arr[0] + arr[1];
		dt[2] = max(dt[1], arr[0] + arr[2], arr[1] + arr[2]);
		for(int i=3; i<n; i++) {
			//지금 와인을 먹지 않았을 때가 제일 큰경우 dt[i-1]가 제일 큼
			//지금 먹었는데, 바로 전에도 먹었을 때가 더 큰 경우, arr[i] + arr[i-1] + dt[i-3]가 제일 큼
			//지금 먹었는데, 바로 전에 안먹었을 때가 더 큰 경우, arr[i] + dt[i-2]가 제일 큼
			dt[i] = max(dt[i-1], arr[i] + arr[i-1] + dt[i-3], arr[i] + dt[i-2]);
		}
		System.out.println(dt[n-1]);
	}
	static int max(int a, int b, int c) {
		int max;
		if(a > b) {
			max = a;
		} else {
			max = b;
		}
		if(c > max) {
			return c;
		} else {
			return max;
		}
	}
}