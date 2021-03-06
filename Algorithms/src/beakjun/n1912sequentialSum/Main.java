package beakjun.n1912sequentialSum;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] array = new int[n+1];
		int[] dt = new int[n + 1];
		Arrays.fill(dt, -1001);
		for (int i = 1; i <= n; i++) {
			array[i] = Integer.parseInt(st.nextToken());
			dt[i] = Math.max(dt[i-1] + array[i], array[i]);
		}
		Arrays.sort(dt);
		System.out.println(dt[n]);
	}
}
